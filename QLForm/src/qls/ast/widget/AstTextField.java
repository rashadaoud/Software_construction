package qls.ast.widget;

import qls.visiting.WidgetVisitor;

public class AstTextField extends AstWidget {
	//constructor
	public AstTextField() {

	}

	@Override
	public <T, U> T accept(WidgetVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
