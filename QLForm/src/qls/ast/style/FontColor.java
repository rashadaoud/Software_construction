package qls.ast.style;

import java.awt.Color;

import qls.visiting.StyleVisitor;

public class FontColor extends StyleProperty {
	private String color;

	//constructor
	public FontColor(String color) {
		this.color = color;
	}

	public Color getColor() {
		String[] split = color.split("#");
		return new Color(Integer.parseInt(split[1]));
	}
	

	@Override
	public <T, U> T accept(StyleVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}

}