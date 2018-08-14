package ql.ast;

import ql.utils.CodeReference;

public abstract class AstNode {
	
	private CodeReference location;

	public AstNode() {
		location = null;
	}

	public AstNode(CodeReference location) {
		this.location = location;
	}
	
	public CodeReference getLocation() {
		return location;
	}
	
	public void setLocation(CodeReference location) {
		this.location = location;
	}
}