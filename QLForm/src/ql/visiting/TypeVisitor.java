package ql.visiting;

import ql.ast.type.*;

public interface TypeVisitor<T, U> {
	public T visit(BooleanType type, U ctx);
	public T visit(DateType type, U ctx);
	public T visit(StringType type, U ctx);
	public T visit(IntegerType type, U ctx);
	public T visit(MoneyType type, U ctx);
	public T visit(DecimalType type, U ctx);
	public T visit(UndefinedType type, U ctx);
}
