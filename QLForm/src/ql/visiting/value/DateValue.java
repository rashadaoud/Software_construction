package ql.visiting.value;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValue extends AbstractValue {
  
	private Date value;
	
	public DateValue(Date value) {
		this.value = value;
	}

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}
	
	@Override
	public String getValueString() {
		return value.toString();
	}

	@Override
	public BooleanValue gt(Value val) {
		return val.gt(this);
	}
	
	@Override
	public BooleanValue gt(DateValue val) {
		return val.gt(this);
	}

	@Override
	public BooleanValue gEq(Value val) {
		return val.gEq(this);
	}
	
	@Override
	public BooleanValue gEq(DateValue val) {
		return val.gEq(this);
	}

	@Override
	public BooleanValue lt(Value val) {
		return val.lt(this);
	}
	
	@Override
	public BooleanValue lt(DateValue val) {
		return val.lt(this);
	}

	@Override
	public BooleanValue lEq(Value val) {
		return val.lEq(this);
	}
	
	@Override
	public BooleanValue lEq(DateValue val) {
		return val.lEq(this);
	}
	
	@Override
	public BooleanValue eq(Value val) {
		return val.eq(this);
	}
	@Override
	public BooleanValue eq(DateValue val) {
		return val.eq(this);
	}
	
	@Override
	public BooleanValue eq(DecimalValue val) {
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
	public BooleanValue and(Value val) {
		return throwException();
	}

	@Override
	public BooleanValue or(Value val) {
		return throwException();
	}

	@Override
	public BooleanValue not() {
		return throwException();
	}

	@Override
	public Value add(IntegerValue val) {
		return throwException();
	}

	@Override
	public Value add(BooleanValue val) {
		return throwException();
	}

	@Override
	public Value add(StringValue val) {
		return throwException();
	}

	
	@Override
	public BooleanValue eq(IntegerValue val) {
		return throwException();
	}

	@Override
	public BooleanValue eq(BooleanValue val) {
		return throwException();
	}

	@Override
	public BooleanValue eq(StringValue val) {
		return throwException();
	}


	@Override
	public BooleanValue eq(MoneyValue val) {
		return throwException();
	}
	
	@Override
	public Value translate(String str) {
		DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new DateValue(date);
	}

	
	@Override
	public <T extends Value> T throwException() {
		throw new UnsupportedOperationException(getClass().getName());
	}

}