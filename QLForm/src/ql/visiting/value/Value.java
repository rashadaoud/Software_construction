package ql.visiting.value;

public abstract class Value {
	// value
	public abstract Value add(Value val);
	public abstract Value sub(Value val);
	public abstract Value mul(Value val);
	public abstract Value div(Value val);
	public abstract Value neg();
	public abstract Value pos();
	public abstract Value translate(String str);
	
	public abstract String getValueString();
	
	public abstract BooleanValue and(Value val);
	public abstract BooleanValue or(Value val);
	public abstract BooleanValue gt(Value val);
	public abstract BooleanValue gEq(Value val);
	public abstract BooleanValue lt(Value val);
	public abstract BooleanValue lEq(Value val);
	
	//logical
	public abstract BooleanValue or(IntegerValue val);
	public abstract BooleanValue or(BooleanValue val);
	public abstract BooleanValue or(StringValue val);
	public abstract BooleanValue or(DateValue val);
	public abstract BooleanValue or(MoneyValue val);
	public abstract BooleanValue or(DecimalValue val);
	
	public abstract BooleanValue and(IntegerValue val);
	public abstract BooleanValue and(BooleanValue val);
	public abstract BooleanValue and(StringValue val);
	public abstract BooleanValue and(DateValue val);
	public abstract BooleanValue and(MoneyValue val);
	public abstract BooleanValue and(DecimalValue val);
	
	public abstract BooleanValue not();
	

	//math
	public abstract Value add(IntegerValue val);
	public abstract Value add(BooleanValue val);
	public abstract Value add(StringValue val);
	public abstract Value add(DateValue val);
	public abstract Value add(MoneyValue val);
	public abstract Value add(DecimalValue val);
	public abstract Value sub(IntegerValue val);
	public abstract Value sub(BooleanValue val);
	public abstract Value sub(StringValue val);
	public abstract Value sub(DateValue val);
	public abstract Value sub(MoneyValue val);
	public abstract Value sub(DecimalValue val);
	public abstract Value mul(IntegerValue val);
	public abstract Value mul(BooleanValue val);
	public abstract Value mul(StringValue val);
	public abstract Value mul(DateValue val);
	public abstract Value mul(MoneyValue val);
	public abstract Value mul(DecimalValue val);
	public abstract Value div(IntegerValue val);
	public abstract Value div(BooleanValue val);
	public abstract Value div(StringValue val);
	public abstract Value div(DateValue val);
	public abstract Value div(MoneyValue val);
	public abstract Value div(DecimalValue val);
	
	// comparison
	public abstract BooleanValue gt(IntegerValue val);
	public abstract BooleanValue gt(BooleanValue val);
	public abstract BooleanValue gt(StringValue val);
	public abstract BooleanValue gt(DateValue val);
	public abstract BooleanValue gt(MoneyValue val);
	public abstract BooleanValue gt(DecimalValue val);
	public abstract BooleanValue gEq(IntegerValue val);
	public abstract BooleanValue gEq(BooleanValue val);
	public abstract BooleanValue gEq(StringValue val);
	public abstract BooleanValue gEq(DateValue val);
	public abstract BooleanValue gEq(MoneyValue val);
	public abstract BooleanValue gEq(DecimalValue val);
	public abstract BooleanValue lt(IntegerValue val);
	public abstract BooleanValue lt(BooleanValue val);
	public abstract BooleanValue lt(StringValue val);
	public abstract BooleanValue lt(DateValue val);
	public abstract BooleanValue lt(MoneyValue val);
	public abstract BooleanValue lt(DecimalValue val);
	public abstract BooleanValue lEq(IntegerValue val);
	public abstract BooleanValue lEq(BooleanValue val);
	public abstract BooleanValue lEq(StringValue val);
	public abstract BooleanValue lEq(DateValue val);
	public abstract BooleanValue lEq(MoneyValue val);
	public abstract BooleanValue lEq(DecimalValue val);
	public abstract BooleanValue eq(Value val);
	public abstract BooleanValue eq(IntegerValue val);
	public abstract BooleanValue eq(BooleanValue val);
	public abstract BooleanValue eq(StringValue val);
	public abstract BooleanValue eq(DateValue val);
	public abstract BooleanValue eq(MoneyValue val);
	public abstract BooleanValue eq(DecimalValue val);
	
	//to handle non-allowed operations during evaluation
	public abstract <T extends Value> T throwException();
}
