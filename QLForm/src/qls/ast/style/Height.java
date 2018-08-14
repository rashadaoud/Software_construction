package qls.ast.style;

import ql.ast.literal.IntegerLiteral;
import qls.visiting.StyleVisitor;

public class Height extends StyleProperty {
	private IntegerLiteral heightVal;

	//constructor
	public Height(IntegerLiteral heightVal) {
		this.heightVal = heightVal;
	}

	public int getHeightVal() {
		return heightVal.getValue().getValue();
	}

	@Override
	public <T, U> T accept(StyleVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this,  ctx);
	}
}