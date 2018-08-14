package ql.ast.type;

import ql.visiting.TypeVisitor;

public class DecimalType extends Type {
    
    private double val;
    
    public DecimalType() {
        this.setVal(0.00);
    }
    
    public DecimalType(double val) {
        this.setVal(val);
    }

	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}
	
    @Override
    public String getTypeString() {
      return "DecimalType";
    }
    
	@Override
	public <T, U> T accept(TypeVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
