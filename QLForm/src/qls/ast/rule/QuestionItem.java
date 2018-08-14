package qls.ast.rule;

import java.util.List;

import qls.ast.style.StyleProperty;
import qls.ast.widget.AstWidget;
import qls.visiting.ItemVisitor;

public class QuestionItem extends Item {
	private final String id;

	//constructor
	public QuestionItem(String id, AstWidget widget, List<StyleProperty> properties) {
		super(widget, properties);
		this.id = id;
	}

	public String getIdentifier() {
		return id;
	}

	@Override
	public <T, U> T accept(ItemVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}