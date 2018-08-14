package ql.ast.type;

import ql.visiting.TypeVisitor;

public class StringType extends Type {

	private String val;

	public StringType() {
		this.setVal("");
	}
	
	public StringType(String val) {
		this.setVal(val);
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	
    @Override
    public String getTypeString() {
      return "StringType";
    }
	
	@Override
	public <T, U> T accept(TypeVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
