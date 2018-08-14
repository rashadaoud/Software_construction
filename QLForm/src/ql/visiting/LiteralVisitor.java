package ql.visiting;

import ql.ast.literal.*;

public interface LiteralVisitor<T, U>{
	public T visit(IntegerLiteral literal, U ctx);
	public T visit(BooleanLiteral literal, U ctx);
	public T visit(DateLiteral literal, U ctx);
	public T visit(StringLiteral literal, U ctx);
	public T visit(MoneyLiteral literal, U ctx);
	public T visit(DecimalLiteral literal, U ctx);
}
