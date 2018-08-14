package ql.ast.literal;

import ql.visiting.LiteralVisitor;
import ql.visiting.value.DecimalValue;

public class DecimalLiteral extends Literal{

    private DecimalValue value;
    

    public DecimalLiteral(double value) {
    	this.value = new DecimalValue(value);
    }
    
    @Override
    public DecimalValue getValue() {
		return value;
	}


	@Override
	public <T, U> T accept(LiteralVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
