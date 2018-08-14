package ql.ast.literal;

import java.math.BigDecimal;

import ql.visiting.LiteralVisitor;
import ql.visiting.value.MoneyValue;

public class MoneyLiteral extends Literal {

    private MoneyValue value;
    
    public MoneyLiteral(BigDecimal value) {
    	this.value = new MoneyValue(value);
    }
    
    @Override
	public MoneyValue getValue() {
		return value;
	}

	@Override
	public <T, U> T accept(LiteralVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
