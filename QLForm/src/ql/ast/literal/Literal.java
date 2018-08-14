package ql.ast.literal;

import ql.ast.AstNode;
import ql.visiting.LiteralVisitor;
import ql.visiting.value.Value;

public abstract class Literal extends AstNode {

	public abstract Value getValue();
		
	public abstract <T, U> T accept(LiteralVisitor<T, U> visitor, U ctx);
}
