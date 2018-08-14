package ql.checking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import ql.utils.MessageTypeEnum;
import ql.visiting.MainVisitor;
import ql.visiting.TypeCheckerVisitor;
import ql.ast.Form;
import ql.ast.statement.*;
import ql.ast.type.Type;
import ql.checking.cyclicDependency.QuestionDependencyData;
import ql.checking.cyclicDependency.QuestionDependencyData.*;
import ql.checking.eventHandling.*;


public class TypeChecker {
	
	private final Map<String, List<Question>> mapIdQuestion = new HashMap<>();
	private final Map<String, List<Question>> mapNameQuestion = new HashMap<>();
	
	public CheckerMessages events = new CheckerMessages();
	
	// constructor
	public TypeChecker() {
		
	}
	
	/**
	* Type checker to detect all problems defined in the specifications of QL interpreter
	* @param: Form 
	* @return: void
	*/
	public boolean runChecker(Form form){
		detectDuplicatedQuestions(form);
		detectCyclicDependencies(form);
		detectReferenceToUndefinedQuestion(form);
		detectInvalidTypesAndConditions(form);
		return handleEvents();
	}
	

	
	/**
	* detect problems within questions in the QL form.
	* This method will check for the following:
	*  duplicate question declarations with different types
	*  duplicate question labels
	* @param: Form 
	* @return: void
	*/
	public void detectDuplicatedQuestions(Form form) {
		form.getBlock().accept(new MainVisitor<Void, Void>() { 
				@Override
                 public Void visit(ComputedQuestion question, Void ctx) {
                	 addQuestionToMaps(question);
                   return null;
                 }

                 @Override
                 public Void visit(AnswerableQuestion question, Void ctx) {
                	 addQuestionToMaps(question);
                	 return null;
                 }
               }, null);


		// detect more than one question with same label (name)
		for (List<Question> questions : getDataByName().values()) {
			if (questions.size() > 1) {
				questions.forEach(question -> {
					events.insert(new EventMessage(
							"Duplicated label: " + question.getName() +
							" at line:" + question.getLocation().getStartLine(),
							MessageTypeEnum.warning));
				});
			}
		}
	
			
		// detect more than one question with same name but different types
		for (List<Question> questions : getDataById().values()) {
			Type type;
			if (questions.size() > 1) {
				type = questions.get(0).getType();
				for (Question question : questions) {
					// if same type, no problem
					if (question.getType().equals(type)) {
						continue;
					}
		
					// if not the same type, report the issue
					questions.forEach(qst -> {
					events.insert(new EventMessage(
									"Duplicated question declaration with different type: " + qst.getName() +
									" at line:" + qst.getLocation().getStartLine(),
									MessageTypeEnum.error));
					});
					
					//break inner loop, and go to next set of questions with same id
					break;
				}
			}
		}
	}
	

	// helper: get map of questions by Id (questions with shared identifier)
	public Map<String, List<Question>> getDataById() {
		Map<String, List<Question>> map = new HashMap<String, List<Question>>();
		mapIdQuestion.forEach((key, value) -> map.put(key, Collections.unmodifiableList(value)));
		return Collections.unmodifiableMap(map);
	}
	
	// helper: get map of questions by label (questions with shared name/label)
	public Map<String, List<Question>> getDataByName(){
		Map<String, List<Question>> map = new HashMap<String, List<Question>>();
		mapNameQuestion.forEach((key, value) -> map.put(key, Collections.unmodifiableList(value)));
		return Collections.unmodifiableMap(map);
	}
	
	// helper: add the given question to the lists of relevant identifier and label in checker's maps
	public void addQuestionToMaps(Question question) {
		List<Question> idQuestionList;
		List<Question> nameQuestionList;
		idQuestionList = mapIdQuestion.computeIfAbsent(question.getIdentifier().toString(), x -> new ArrayList<>());
		nameQuestionList = mapNameQuestion.computeIfAbsent(question.getName(), x -> new ArrayList<>());
		idQuestionList.add(question);
		nameQuestionList.add(question);
	}


	/**
	* detect cyclic dependencies between questions in the QL form.
	* e.g. 
	* A --> B --> C --> D --> A
	* @param: Form 
	* @return: void
	*/
	public void detectCyclicDependencies(Form form) {

		QuestionDependencyData dependencyTable = new QuestionDependencyData();
	    form.getBlock().accept(new MainVisitor<Void, Void>() {
                         @Override
                         public Void visit(ComputedQuestion question, Void ctx) {
                        	 dependencyTable.add(question);
                           return null;
                         }
                       }, null);

	    for (QuestionDependency dependency : dependencyTable.getDependencies()) {
	    	for (DependencyPath circlePath : dependency.getCirclePaths()) {
	    		events.insert(
	    				new EventMessage("Cyclic dependency found " + dependency + ", " + circlePath,
	    									MessageTypeEnum.error));
	    	}
	    }
	}

	
  /**
   * detect type defects in the QL form such as:
   *  operands of invalid type to operators (type mismatch)
   *  invalid conditions (non-boolean)
   * @param: Form 
   * @return: void
   */
	public void detectInvalidTypesAndConditions(Form form) {
		TypeCheckerVisitor typeCheckerVisitor = new TypeCheckerVisitor(events);
		typeCheckerVisitor.visit(form);
	}
	
	/**
	 * detect reference to undefined question in QL form
	* @param: Form 
	* @return: void
	*/
	public void detectReferenceToUndefinedQuestion(Form form) {
		QuestionDependencyData dependencyTable = new QuestionDependencyData();
	    form.getBlock().accept(new MainVisitor<Void, Void>() {
                         @Override
                         public Void visit(ComputedQuestion question, Void ctx) {
                        	 dependencyTable.add(question);
                           return null;
                         }
                       }, null);

	    for (QuestionDependency dependency : dependencyTable.getDependencies()) {
	    	boolean[] found = {false};
	    	mapIdQuestion.forEach((key, value) -> {
	    		if (dependency.toString() == key) {
	    			found[0] = true; // because we cannot change local boolean from lambda expr
	    		}
	    	});
	    	if (!found[0]) {
				events.insert(new EventMessage(
								"Reference to undefined question was found " + dependency.toString(),
								MessageTypeEnum.error));
	    	}
	    }
	}
	
	/**
	 * print out errors & warnings in styled way
	* @param: 
	* @return: void
	*/
	private boolean handleEvents() {
		int countErrors = 0 ;
		int countWarnings = 0;
		boolean checkSucceeded = true;
		
		List<EventMessage> errors = events.getMessagesOfType(MessageTypeEnum.error);
		List<EventMessage> warnings = events.getMessagesOfType(MessageTypeEnum.warning);
		
		//errors
		if(errors != null) {
			checkSucceeded = false;
			countErrors = errors.size();
			System.out.println("The checker found " + countErrors + "-errors....");
			for (EventMessage msg: errors) {
				System.out.println("\tError: " + msg.getText());
			}
			if(countErrors!=0) {
				System.out.println("\nPlease fix your QL code before you try again!\n");
			}
		}
		
		//warnings
		if(warnings != null) {
			//checkSucceeded = false;
			countWarnings = warnings.size();
			System.out.println("The checker found " + countWarnings + "-warnings....");
			for (EventMessage msg: warnings) {
				System.out.println("\tWarning: " + msg.getText());
			}
			if(countErrors!=0) {
				System.out.println("\nPlease review warnings and fix your QL code before you try again!");
			}
		}
		return checkSucceeded;
	}

}
