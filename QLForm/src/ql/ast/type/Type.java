package ql.ast.type;

import ql.visiting.TypeVisitor;
import ql.ast.AstNode;

public abstract class Type extends AstNode {
	
	public static final Type BOOLEAN = new BooleanType();
	public static final Type DATE = new DateType();
	public static final Type STRING = new StringType();
	public static final Type DECIMAL = new DecimalType();
	public static final Type MONEY = new MoneyType();
	public static final Type INTEGER = new IntegerType();
	public static final Type UNDEFINED = new UndefinedType();

	public abstract String getTypeString();
	public abstract <T, U> T accept(TypeVisitor<T, U> visitor, U ctx);
}