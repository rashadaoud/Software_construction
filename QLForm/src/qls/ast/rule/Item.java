package qls.ast.rule;

import java.util.Collections;
import java.util.List;

import ql.ast.AstNode;
import qls.visiting.ItemVisitor;
import qls.ast.style.StyleProperty;
import qls.ast.widget.*;

public abstract class Item extends AstNode {
	
	private final AstWidget widget;
	private final List<StyleProperty> properties;
	
	// constructor
	public Item(AstWidget widget, List<StyleProperty> properties) {
		this.widget = widget;
		this.properties = properties;
	}

	public List<StyleProperty> getProperties() {
		return Collections.unmodifiableList(properties);
	}
	
	public abstract <T, U> T accept(ItemVisitor<T, U> visitor, U ctx);

	public AstWidget getWidget() {
		// if no widget specified for item (e.g question) in stylesheet, get default one 
		// ql-default: RadioBtn for boolean, and TextField for other types
		if (widget == null) {
			return new AstWidgetDefault();
		}
		return widget;
	}
}
