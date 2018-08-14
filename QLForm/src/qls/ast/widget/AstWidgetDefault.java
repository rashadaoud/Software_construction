package qls.ast.widget;

import qls.visiting.WidgetVisitor;

//to use ql widgets when question has no widget specified in the qls stylesheet
public class AstWidgetDefault extends AstWidget {
	//constructor
	public AstWidgetDefault() {

	}

	@Override
	public <T, U> T accept(WidgetVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
