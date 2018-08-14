package ql.ast.expression;

import ql.visiting.ExpressionVisitor;

public class ParenthesesExpression extends UnaryExpression {

	public ParenthesesExpression(Expression expr) {
		super(expr);
	}
	
	@Override
	public <T, U> T accept(ExpressionVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
