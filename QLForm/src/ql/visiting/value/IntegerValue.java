package ql.visiting.value;

public class IntegerValue extends AbstractValue {
  
	private int value;
	
	public IntegerValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String getValueString() {
		return new Integer(value).toString();
	}
	
	@Override
	public Value add(Value val) {
		return val.add(this);
	}
	
	@Override
	public Value add(IntegerValue val) {
		int result = this.value + val.value;
		return new IntegerValue(result);
	}
	
	@Override
	public Value sub(Value val) {
		return val.sub(this);
	}
	
	@Override
	public Value sub(IntegerValue val) {
		int result = this.value - val.value;
		return new IntegerValue(result);
	}
	
	@Override
	public Value mul(Value val) {
		return val.mul(this);
	}
	
	@Override
	public Value mul(IntegerValue val) {
		int result = this.value * val.value;
		return new IntegerValue(result);
	}
	
	@Override
	public Value div(Value val) {
		return val.div(this);
	}
	
	@Override
	public Value div(IntegerValue val) {
		if (val.value != 0) {
			int result = this.value / val.value;
			return new IntegerValue(result);
		}
		return throwException();
	}

	
	@Override
	public BooleanValue eq(Value val) {
		return val.eq(this);
	}
	
	@Override
	public BooleanValue eq(IntegerValue val) {
		boolean result = this.value == val.value;
		return new BooleanValue(result);
	}
	
	@Override
	public BooleanValue eq(BooleanValue val) {
		return BooleanValue.FALSE;
	}

	
	@Override
	public BooleanValue eq(StringValue val) {
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
	public BooleanValue gt(Value val) {
		return val.gt(this);
	}
	
	@Override
	public BooleanValue gt(IntegerValue val) {
		boolean result = this.value > val.value;
		return new BooleanValue(result);
	}

	@Override
	public BooleanValue gEq(Value val) {
		return val.gt(this).or(val.eq(this));
	}
	
	@Override
	public BooleanValue gEq(IntegerValue val) {
		boolean result = this.value >= val.value;
		return new BooleanValue(result);
	}

	@Override
	public BooleanValue lt(Value val) {
		return val.lt(this);
	}
	
	@Override
	public BooleanValue lt(IntegerValue val) {
		boolean result = this.value < val.value;
		return new BooleanValue(result);
	}
	

	@Override
	public BooleanValue lEq(Value val) {
		return val.lt(this).or(val.eq(this));
	}
	
	@Override
	public BooleanValue lEq(IntegerValue val) {
		boolean result = this.value <= val.value;
		return new BooleanValue(result);
	}
	
	@Override
	public IntegerValue neg() {
		return new IntegerValue((-1)*this.value);
	}

	@Override
	public IntegerValue pos() {
		return new IntegerValue(+(this.value));
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
	public Value translate(String str) {
		return new IntegerValue(Integer.parseUnsignedInt(str));
	}
	
	
	@Override
	public <T extends Value> T throwException() {
		throw new UnsupportedOperationException(getClass().getName());
	}
	
}