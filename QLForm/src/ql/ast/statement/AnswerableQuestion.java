package ql.ast.statement;

import ql.ast.literal.Identifier;
import ql.ast.type.Type;
import ql.utils.CodeReference;
import ql.visiting.StatementVisitor;

public class AnswerableQuestion extends Question {
	
	public AnswerableQuestion(Identifier id, String name, Type type, CodeReference location) {
		super(id, name, type, location);
	}

	@Override
	public <T, U> T accept(StatementVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}