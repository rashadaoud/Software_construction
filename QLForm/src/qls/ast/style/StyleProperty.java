package qls.ast.style;

import ql.ast.AstNode;
import qls.visiting.StyleVisitor;


public abstract class StyleProperty extends AstNode {

	public abstract <T, U> T accept(StyleVisitor<T, U> visitor, U ctx);

}
