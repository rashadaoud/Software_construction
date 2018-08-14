package ql.ast.statement;

import ql.ast.AstNode;
import ql.utils.CodeReference;
import ql.visiting.StatementVisitor;

public abstract class Statement extends AstNode {

	public Statement(CodeReference location) {
		super(location);
	}
	
	public abstract <T, U> T accept(StatementVisitor<T, U> visitor, U ctx);
}