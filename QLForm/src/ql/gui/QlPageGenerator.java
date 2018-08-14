package ql.gui;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;

import ql.gui.widget.*;
import ql.ast.Form;
import ql.ast.statement.ComputedQuestion;
import ql.ast.statement.IfThenStatement;
import ql.ast.statement.AnswerableQuestion;
import ql.ast.statement.Question;
import ql.ast.type.*;
import ql.visiting.MainVisitor;
import ql.visiting.TypeVisitor;
import ql.visiting.EvaluationContext;
import ql.visiting.value.*;
import ql.ast.expression.Expression;
import ql.ast.expression.And;
import ql.ast.expression.LiteralExpression;
import ql.ast.literal.BooleanLiteral;


public class QlPageGenerator implements QlGraphicalInterface<FormGUI, QuestionGUI, Widget> {

	@Override
	public FormGUI createFormGUI(Form form) {
	    List<QuestionGUI> questions = new ArrayList<>();
	    EvaluationContext ctx = new EvaluationContext();
	
	    form.getBlock().accept(new MainVisitor<Void, Expression>() {
             @Override
             public Void visit(AnswerableQuestion question, Expression enableExpression) {
               questions.add(createQuestionGUI(question, enableExpression, null, ctx));
               return null;
             }

             @Override
             public Void visit(ComputedQuestion question, Expression enableExpression) {
            	 questions.add(createQuestionGUI(question, enableExpression,
			                                   question.getExpression(), ctx));
               return null;
             }
             
             @Override
             public Void visit(IfThenStatement node, Expression enableExpression) {
            	 // should be enabled && statement-condition is met
            	 node.getIfBody().accept(this, new And(enableExpression, node.getCondition()));
            	 return null;
             }
                     
           },
           new LiteralExpression(BooleanLiteral.TRUE));
	    
	    return new FormGUI(questions);
  }

	@Override
	public QuestionGUI createQuestionGUI (
	 Question question, Expression enableExpression,
	 Expression computableExpression, EvaluationContext ctx) {
		return new QuestionGUI(
						ctx,
						question,
						createLabel(question, ctx),
						createValueWidget(question, ctx),
						enableExpression,
						computableExpression
					);
	}

	@Override
	public Widget createValueWidget(Question question, EvaluationContext ctx) {
		return question.getType().accept(new TypeVisitor<Widget, Void>() {
			
			// type visitor found undefined type, no widget is created
			@Override
			public Widget visit(UndefinedType type, Void ctx) {
				throw new UnsupportedOperationException(
						"Error WidgetInterface: Value type is undefined!");
			}
			
			@Override
			public Widget visit(BooleanType type, Void ctx2){
				//default False "No"
				FieldOption defaultOption = new FieldOption("No", BooleanValue.FALSE);
				FieldOption otherOption = new FieldOption("Yes", BooleanValue.TRUE);
				List<FieldOption> optionsList = new ArrayList<>();
				optionsList.add(defaultOption);
				optionsList.add(otherOption);
				FieldOptions options = new FieldOptions(optionsList, defaultOption);
				return new RadioBtn(question, options, ctx);
			}
			
			@Override
			public Widget visit(StringType type, Void ctx2) {
				//default empty string
				return new TextField(question, new StringValue(""), ctx);
			}
				
			@Override
			public Widget visit(MoneyType type, Void ctx2) {
				//default 0.0
				return new TextField(question, new MoneyValue(BigDecimal.valueOf(0.0)), ctx);
			}
			
			@Override
			public Widget visit(DateType type, Void ctx2) {
				//default today
				return new TextField(question, new DateValue(new Date()), ctx);
			}
			
			@Override
			public Widget visit(IntegerType type, Void ctx2) {
				//default 0
				return new TextField(question, new IntegerValue(0), ctx);
			}
			
			@Override
			public Widget visit(DecimalType type, Void ctx2) {
				//default 0.0
				return new TextField(question, new MoneyValue(BigDecimal.valueOf(0.0)), ctx);
			}
				
		  },
		  null);
	}
	
	@Override
	public Widget createLabel(Question question, EvaluationContext ctx) {
		//question label
		return new Label(question.getName()); 
	}
}
