package ql.visiting.value;

public class StringValue extends AbstractValue {
  
	private String value;

	public StringValue(String str) {
		this.value = str;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String getValueString() {
		return value;
	}

	@Override
	public BooleanValue or(Value val) {
		return throwException();
	}
	
	@Override
	public BooleanValue and(Value val) {
		return throwException();
	}
	
	@Override
	public BooleanValue not() {
		return throwException();
	}
	
	@Override
	public Value add(Value val) {
		return throwException();
	}

	@Override
	public Value sub(Value val) {
		return throwException();
	}

	@Override
	public Value mul(Value val) {
		return throwException();
	}

	@Override
	public Value div(Value val) {
		return throwException();
	}
	
	@Override
	public BooleanValue gt(Value val) {
		return throwException();
	}

	@Override
	public BooleanValue gEq(Value val) {
		return throwException();
	}

	@Override
	public BooleanValue lt(Value val) {
		return throwException();
	}

	@Override
	public BooleanValue lEq(Value val) {
		return throwException();
	}
	
	
	@Override
	public BooleanValue eq(Value val) {
		return val.eq(this);
	}
	
	@Override
	public BooleanValue eq(StringValue val) {
		return new BooleanValue(this.value.equals(val.value));
	}
	
	@Override
	public BooleanValue eq(BooleanValue val) {
		return BooleanValue.FALSE;
	}

	
	@Override
	public BooleanValue eq(IntegerValue val) {
		return BooleanValue.FALSE;
	}
	

	@Override
	public BooleanValue eq(DateValue val) {
		return BooleanValue.FALSE;
	}
	

	@Override
	public BooleanValue eq(MoneyValue val) {
		return BooleanValue.FALSE;
	}

	@Override
	public BooleanValue eq(DecimalValue val) {
		return BooleanValue.FALSE;
	}
	
	@Override
	public StringValue translate(String str) {
		return new StringValue(str);
	}
	
	@Override
	public <T extends Value> T throwException() {
		throw new UnsupportedOperationException(getClass().getName());
	}
	
}