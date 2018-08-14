package ql.ast.statement;

import ql.ast.Block;
import ql.ast.expression.Expression;
import ql.utils.CodeReference;

public class IfThenElseStatement extends IfThenStatement {

	private final Block elseBody;

	public IfThenElseStatement(Expression condition, Block ifBody, Block elseBody, CodeReference location) {
		super(condition, ifBody, location);
		this.elseBody = elseBody;
	}

	public Block getElseBody() {
		return elseBody;
	}
}