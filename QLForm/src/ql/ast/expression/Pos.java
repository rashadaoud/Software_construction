package ql.ast.expression;

import ql.visiting.ExpressionVisitor;

public class Pos extends UnaryExpression {

	public Pos(Expression expr) {
		super(expr);
	}
	
	@Override
	public <T, U> T accept(ExpressionVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
