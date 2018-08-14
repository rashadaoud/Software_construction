package ql.ast.expression;

public abstract class UnaryExpression extends Expression {

	private final Expression expr;

	public UnaryExpression(Expression expr){
		this.expr = expr;
	}

	public Expression getExpression() {
		return expr;
	}
}
