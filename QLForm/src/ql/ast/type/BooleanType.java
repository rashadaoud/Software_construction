package ql.ast.type;

import ql.visiting.TypeVisitor;

public class BooleanType extends Type {
	
	private boolean val;

	public BooleanType() {

	}
	
	public BooleanType(boolean val) {
		this.setVal(val);
	}

	public boolean getVal() {
		return val;
	}

	public void setVal(boolean val) {
		this.val = val;
	}

    @Override
    public String getTypeString() {
      return "BooleanType";
    }
    
	@Override
	public <T, U> T accept(TypeVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
