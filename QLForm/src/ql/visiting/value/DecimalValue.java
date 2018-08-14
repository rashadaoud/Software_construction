package ql.visiting.value;


public class DecimalValue extends AbstractValue {
  
	private double value;
	
	public DecimalValue(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String getValueString() {
		return Double.toString(value);
	}
	
	@Override
	public Value add(Value val) {
		return val.add(this);
	}
	
	@Override
	public Value add(DecimalValue val) {
		double result = this.value + val.value;
		return new DecimalValue(result);
	}
	
	@Override
	public Value sub(Value val) {
		return val.sub(this);
	}
	
	@Override
	public Value sub(DecimalValue val) {
		double result = this.value - val.value;
		return new DecimalValue(result);
	}
	
	@Override
	public Value mul(Value val) {
		return val.mul(this);
	}
	
	@Override
	public Value mul(DecimalValue val) {
		double result = this.value * val.value;
		return new DecimalValue(result);
	}
	
	@Override
	public Value div(Value val) {
		return val.div(this);
	}
	
	@Override
	public Value div(DecimalValue val) {
		if (val.value!=0) {
			double result = this.value / val.value;
			return new DecimalValue(result);
		}
		return throwException();
	}

	
	@Override
	public BooleanValue eq(Value val) {
		return val.eq(this);
	}
	
	@Override
	public BooleanValue eq(IntegerValue val) {
		return throwException();
	}
	
	@Override
	public BooleanValue gt(Value val) {
		return val.gt(this);
	}
	
	@Override
	public BooleanValue gt(DecimalValue val) {
		if (val.value > this.value) {
			return new BooleanValue(true);
		}
		return new BooleanValue(false);
	}

	@Override
	public BooleanValue gEq(Value val) {
		return val.gt(this).or(val.eq(this));
	}
	
	@Override
	public BooleanValue gEq(DecimalValue val) {
		if (val.value >= this.value) {
			return new BooleanValue(true);
		}
		return new BooleanValue(false);
	}

	@Override
	public BooleanValue lt(Value val) {
		return val.lt(this);
	}
	
	@Override
	public BooleanValue lt(DecimalValue val) {
		if (val.value < this.value) {
			return new BooleanValue(true);
		}
		return new BooleanValue(false);
	}
	
	
	@Override
	public BooleanValue lEq(Value val) {
		return val.lt(this).or(val.eq(this));
	}
	
	@Override
	public BooleanValue lEq(DecimalValue val) {
		if (val.value <= this.value) {
			return new BooleanValue(true);
		}
		return new BooleanValue(false);
	}
	
	@Override
	public DecimalValue neg() {
		return new DecimalValue((-1)*this.value);
	}

	@Override
	public DecimalValue pos() {
		return new DecimalValue((+1)*this.value);
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
	public BooleanValue eq(DecimalValue val) {
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
	public <T extends Value> T throwException() {
		throw new UnsupportedOperationException(getClass().getName());
	}

	@Override
	public Value translate(String str) {
		return null;
	}
}