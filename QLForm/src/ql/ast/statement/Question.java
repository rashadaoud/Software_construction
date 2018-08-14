package ql.ast.statement;

import ql.ast.literal.Identifier;
import ql.ast.type.Type;
import ql.utils.CodeReference;

public abstract class Question extends Statement {

	private final Identifier id;
	private final String name;
	private final Type type;

	public Question(Identifier id, String name, Type type, CodeReference location) {
		super(location);
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public Identifier getIdentifier() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

}