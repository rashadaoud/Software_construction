package qls.ast.style;

import ql.ast.literal.StringLiteral;
import qls.visiting.StyleVisitor;

public class FontName extends StyleProperty {
	private StringLiteral name;

	//constructor
	public FontName(StringLiteral name) {
		this.name = name;
	}

	public String getName() {
		return name.getValue().getValue();
	}

	@Override
	public <T, U> T accept(StyleVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
