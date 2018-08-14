package qls.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import ql.ast.AstNode;
import ql.ast.statement.Question;
import qls.visiting.ItemVisitor;
import qls.ast.rule.*;
import ql.gui.QuestionGUI;

public class Section extends AstNode {
	
	private final String name;
	private final List<Item> items;

	//construction
	public Section(String name, List<Item> items) {
		this.name = name;
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}

	public boolean hasQuestion(Question question) {
		return getQuestionItem(question) != null;
	}

	public QuestionItem getQuestionItem(Question question) {
		for (QuestionItem item : getQuestionItems()) {
			//match identifiers between ql question and qls question-item
			if (item.getIdentifier().equals(question.getIdentifier().toString())) {
				return item;
			}
		}
		return null;
	}

	private List<QuestionItem> getQuestionItems() {
		List<QuestionItem> questionItems = new ArrayList<>();
		for (Item item : items) {
			item.accept(new ItemVisitor<Void, Void>(){
				@Override
				public Void visit(TypeItem item, Void ctx) {
					return null;
				}
				@Override
				public Void visit(QuestionItem item, Void ctx) {
					questionItems.add(item);
					return null;
				}
			},
			null);
		}
		return questionItems;
	}

	public List<QuestionGUI> getFilteredQuestionsGui(List<QuestionGUI> questions) {
		return questions.stream().filter(ui -> hasQuestion(ui.getQuestion())).collect(Collectors.toList());
	}
	
	public List<QuestionGUI> sort(List<QuestionGUI> questions) {
		List<QuestionGUI> sortedQuestions = new ArrayList<>(questions);
		sortedQuestions.sort((q1, q2) -> {
			int q1Index = items.indexOf(getQuestionItem(q1.getQuestion()));
			int q2Index = items.indexOf(getQuestionItem(q2.getQuestion()));
			return Integer.compare(q1Index, q2Index);
		});
		return sortedQuestions;
	}

}
