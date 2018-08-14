package qls.visiting;

import qls.ast.style.*;

public interface StyleVisitor<T, U> {
	
	public T visit(Height property, U ctx);
	public T visit(Width property, U ctx);
	
	public T visit(FontColor property, U ctx);
	public T visit(FontSize property, U ctx);
	public T visit(FontName property, U ctx);
}
