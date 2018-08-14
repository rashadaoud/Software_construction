package qls.ast.style;

import ql.ast.literal.IntegerLiteral;
import qls.visiting.StyleVisitor;


public class FontSize extends StyleProperty {
	private IntegerLiteral size;

	//constructor
	public FontSize(IntegerLiteral size) {
		this.size = size;
	}

	public int getSize() {
		return size.getValue().getValue();
	}

	@Override
	public <T, U> T accept(StyleVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}