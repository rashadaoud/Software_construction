package ql.ast.literal;

import java.util.Date;

import ql.visiting.LiteralVisitor;
import ql.visiting.value.DateValue;

public class DateLiteral extends Literal{

    private DateValue value;
    

    public DateLiteral(Date value){
    	this.value = new DateValue(value);
    }
    
    @Override
	public DateValue getValue() {
		return value;
	}

	@Override
	public <T, U> T accept(LiteralVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
