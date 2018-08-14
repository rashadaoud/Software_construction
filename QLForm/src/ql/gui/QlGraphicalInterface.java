package ql.gui;

import ql.ast.Form;
import ql.ast.expression.Expression;
import ql.ast.statement.Question;
import ql.visiting.EvaluationContext;

public interface QlGraphicalInterface<T, U, V> {
	
	public T createFormGUI(Form form);
	public U createQuestionGUI(Question question, Expression enableExpression,
								Expression computableExpression, EvaluationContext ctx);
	
	public V createLabel(Question question, EvaluationContext ctx);
	public V createValueWidget(Question question, EvaluationContext ctx);
}
