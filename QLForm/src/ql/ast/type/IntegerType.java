package ql.ast.type;

import ql.visiting.TypeVisitor;

public class IntegerType extends Type {

    private int val;
    
    public IntegerType() {
        this.setVal(0);
    }
    
    public IntegerType(int val) {
        this.setVal(val);
    }


	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
    @Override
    public String getTypeString() {
      return "IntegerType";
    }
	
	@Override
	public <T, U> T accept(TypeVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
	
}
