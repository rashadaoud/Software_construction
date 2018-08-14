package ql.ast.type;

import java.math.BigDecimal;

import ql.visiting.TypeVisitor;

public class MoneyType extends Type {

    private BigDecimal val;
    
    public MoneyType(BigDecimal val) {
        this.setVal(val);
    }

	public MoneyType() {
        this.setVal(new BigDecimal(0.00));
	}

	public BigDecimal getVal() {
		return val;
	}

	public void setVal(BigDecimal val) {
		this.val = val;
	}
	
    @Override
    public String getTypeString() {
      return "MoneyType";
    }
	
	@Override
	public <T, U> T accept(TypeVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
