package ql.visiting.value;

public class BooleanValue extends AbstractValue {
  
	private boolean value;
	public static final BooleanValue FALSE = new BooleanValue(false);
	public static final BooleanValue TRUE = new BooleanValue(true);

	public BooleanValue(boolean value) {
		this.value = value;
	}
	
	public BooleanValue(String str) {
		if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes")) {
			value = true;
		}
		else if (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no")) {
			value = false;
		}
		else {
			throw new IllegalArgumentException(str);
		}
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public void setValue(String str) {
		if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes")) {
			this.value = true;
		}
		else if (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no")) {
			this.value = false;
		}
		else {
			throw new IllegalArgumentException(str);
		}
	}
	
	@Override
	public String getValueString() {
		if(value == true) {
			return "Yes";
		}
		return "No";
	}
	
	@Override
	public BooleanValue translate(String str) {
		return new BooleanValue(str);
	}
	
	@Override
	public BooleanValue or(Value val) {
		return val.or(this);
	}

	@Override
	public BooleanValue or(BooleanValue val) {
		boolean result = (val.value || this.value);
		return new BooleanValue(result);
	}
	
	@Override
	public BooleanValue and(Value val) {
		return val.or(this);
	}

	@Override
	public BooleanValue and(BooleanValue val) {
		boolean result = (val.value && this.value);
		return new BooleanValue(result);
	}

	@Override
	public BooleanValue not() {
  return new BooleanValue(!(this.value));
	}
	
	@Override
	public BooleanValue eq(Value val) {
		return val.eq(this);
	}
	
	@Override
	public BooleanValue eq(BooleanValue val) {
		boolean result = (val.value == this.value);
		return new BooleanValue(result);
	}
	
	@Override
	public BooleanValue eq(StringValue val) {
		return BooleanValue.FALSE;
	}
	
	@Override
	public BooleanValue eq(IntegerValue val) {
		return BooleanValue.FALSE;
	}
	
	@Override
	public BooleanValue eq(MoneyValue val) {
		return BooleanValue.FALSE;
	}

	@Override
	public BooleanValue eq(DateValue val) {
		return BooleanValue.FALSE;
	}
	
	@Override
	public BooleanValue eq(DecimalValue val) {
		return BooleanValue.FALSE;
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

}