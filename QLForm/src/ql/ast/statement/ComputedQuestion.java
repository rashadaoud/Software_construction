package ql.ast.statement;

import ql.ast.expression.Expression;
import ql.ast.literal.Identifier;
import ql.ast.type.Type;
import ql.utils.CodeReference;
import ql.visiting.StatementVisitor;

public class ComputedQuestion extends Question {

	private final Expression expression;

	public ComputedQuestion(Identifier id, String name, Type type, Expression expression, CodeReference location) {
		super(id, name, type, location);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public <T, U> T accept(StatementVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
