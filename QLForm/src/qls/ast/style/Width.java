package qls.ast.style;

import ql.ast.literal.IntegerLiteral;
import qls.visiting.StyleVisitor;

public class Width extends StyleProperty {
	private IntegerLiteral widthVal;

	//constructor
	public Width(IntegerLiteral widthVal) {
		this.widthVal = widthVal;
	}

	public int getWidthVal() {
		return widthVal.getValue().getValue();
	}

	@Override
	public <T, U> T accept(StyleVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}