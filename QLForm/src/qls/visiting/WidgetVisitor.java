package qls.visiting;

import qls.ast.widget.*;

public interface WidgetVisitor<T, U> {
	public T visit(AstTextField widget, U ctx);
	public T visit(AstCheckBox widget, U ctx);
	public T visit(AstDropDown widget, U ctx);
	public T visit(AstRadioBtn widget, U ctx);
	public T visit(AstSpinbox widget, U ctx);
	public T visit(AstSlider widget, U ctx);
	public T visit(AstWidgetDefault widget, U ctx);
}
