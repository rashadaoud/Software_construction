package ql.ast.statement;

import ql.ast.Block;
import ql.ast.expression.Expression;
import ql.utils.CodeReference;
import ql.visiting.StatementVisitor;

public class IfThenStatement extends Statement {

	private final Expression condition;
	private final Block ifBody;

	public IfThenStatement(Expression condition, Block ifBody, CodeReference location) {
		super(location);
		this.condition = condition;
		this.ifBody = ifBody;
	}

	public Expression getCondition() {
		return condition;
	}

	public Block getIfBody() {
		return ifBody;
	}

	@Override
	public <T, U> T accept(StatementVisitor<T, U> visitor, U ctx) {
		 return visitor.visit(this, ctx);
	}
}
