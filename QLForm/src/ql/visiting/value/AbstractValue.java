package ql.visiting.value;

public abstract class AbstractValue extends Value {
	
	@Override
	public Value add(IntegerValue v) {
		return throwException();
	}

	@Override
	public Value add(BooleanValue val){
		return throwException();
	}

	@Override
	public Value add(StringValue val){
		return throwException();
	}

	@Override
	public Value add(DateValue val){
		return throwException();
	}

	@Override
	public Value add(MoneyValue val){
		return throwException();
	}

	@Override
	public Value add(DecimalValue val){
		return throwException();
	}
	
	@Override
	public Value sub(IntegerValue val){
		return throwException();
	}

	@Override
	public Value sub(BooleanValue val){
		return throwException();
	}

	@Override
	public Value sub(StringValue val){
		return throwException();
	}
	
	@Override
	public Value sub(DateValue val){
		return throwException();
	}
	
	@Override
	public Value sub(MoneyValue val){
		return throwException();
	}

	@Override
	public Value sub(DecimalValue val){
		return throwException();
	}
	
	@Override
	public Value mul(IntegerValue val){
		return throwException();
	}

	@Override
	public Value mul(BooleanValue val){
		return throwException();
	}

	@Override
	public Value mul(StringValue val){
		return throwException();
	}
	
	@Override
	public Value mul(DateValue val){
		return throwException();
	}
	
	@Override
	public Value mul(MoneyValue val){
		return throwException();
	}

	@Override
	public Value mul(DecimalValue val){
		return throwException();
	}
	
	@Override
	public Value div(IntegerValue val){
		return throwException();
	}

	@Override
	public Value div(BooleanValue val){
		return throwException();
	}

	@Override
	public Value div(StringValue val){
		return throwException();
	}
	
	@Override
	public Value div(DateValue val){
		return throwException();
	}
	
	@Override
	public Value div(MoneyValue val){
		return throwException();
	}

	@Override
	public Value div(DecimalValue val){
		return throwException();
	}
	
	@Override
	public Value neg(){
		return throwException();
	}

	@Override
	public Value pos() {
		return throwException();
	}
	
	@Override
	public BooleanValue gt(IntegerValue val){
		return throwException();
	}

	@Override
	public BooleanValue gt(BooleanValue val){
		return throwException();
	}

	@Override
	public BooleanValue gt(StringValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue gt(DateValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue gt(MoneyValue val){
		return throwException();
	}

	@Override
	public BooleanValue gt(DecimalValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue lt(IntegerValue val){
		return throwException();
	}

	@Override
	public BooleanValue lt(BooleanValue val){
		return throwException();
	}

	@Override
	public BooleanValue lt(StringValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue lt(DateValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue lt(MoneyValue val){
		return throwException();
	}

	@Override
	public BooleanValue lt(DecimalValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue gEq(IntegerValue val){
		return throwException();
	}

	@Override
	public BooleanValue gEq(BooleanValue val){
		return throwException();
	}

	@Override
	public BooleanValue gEq(StringValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue gEq(MoneyValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue gEq(DateValue val){
		return throwException();
	}

	@Override
	public BooleanValue gEq(DecimalValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue lEq(IntegerValue val){
		return throwException();
	}

	@Override
	public BooleanValue lEq(BooleanValue val){
		return throwException();
	}


	@Override
	public BooleanValue lEq(StringValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue lEq(MoneyValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue lEq(DateValue val){
		return throwException();
	}

	@Override
	public BooleanValue lEq(DecimalValue val){
		return throwException();
	}
	

	@Override
	public BooleanValue or(IntegerValue val){
		return throwException();
	}

	@Override
	public BooleanValue or(BooleanValue val){
		return throwException();
	}

	@Override
	public BooleanValue or(StringValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue or(MoneyValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue or(DateValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue or(DecimalValue val){
		return throwException();
	}

	@Override
	public BooleanValue and(IntegerValue val){
		return throwException();
	}

	@Override
	public BooleanValue and(BooleanValue val){
		return throwException();
	}

	@Override
	public BooleanValue and(StringValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue and(MoneyValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue and(DateValue val){
		return throwException();
	}
	
	@Override
	public BooleanValue and(DecimalValue val){
		return throwException();
	}

	@Override
	public BooleanValue not(){
		return throwException();
	}


	public <T extends Value> T throwException() {
		throw new UnsupportedOperationException(getClass().getName());
	}
}
