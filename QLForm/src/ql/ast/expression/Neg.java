package ql.ast.expression;

import ql.visiting.ExpressionVisitor;

public class Neg extends UnaryExpression {

	public Neg(Expression expr) {
		super(expr);
	}
	
	@Override
	public <T, U> T accept(ExpressionVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
