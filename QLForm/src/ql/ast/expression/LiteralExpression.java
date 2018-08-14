package ql.ast.expression;

import ql.visiting.ExpressionVisitor;
import ql.ast.literal.Literal;

public class LiteralExpression extends Expression {

	private final Literal literal;
	
	public LiteralExpression(Literal literal) {
		this.literal = literal;
	}

	@Override
	public <T, U> T accept(ExpressionVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}

	public Literal getLiteral() {
		return literal;
	}
}
