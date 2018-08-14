package ql.ast.literal;

import ql.ast.AstNode;

public class Identifier extends AstNode {

	private final String id;

	public Identifier(String id) {
		this.id = id;
	}

	public String toString() {
		return id;
	}
}