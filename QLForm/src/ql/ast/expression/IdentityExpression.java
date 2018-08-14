package ql.ast.expression;

import ql.visiting.ExpressionVisitor;

public class IdentityExpression extends Expression {
	
	private final String name;

	public IdentityExpression(String name) {
		this.name = name;
	}

	@Override
	public <T, U> T accept(ExpressionVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}

	public String getName() {
		return name;
	}
}
