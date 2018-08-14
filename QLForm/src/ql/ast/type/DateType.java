package ql.ast.type;

import java.util.Date;

import ql.visiting.TypeVisitor;

public class DateType extends Type {
    
    private Date val;
    
    public DateType(){
    	this.setVal(new Date());
    }
    
    public DateType(Date val) {
        this.setVal(val);
    }

	public Date getVal() {
		return val;
	}

	public void setVal(Date val) {
		this.val = val;
	}
	
    @Override
    public String getTypeString() {
      return "DateType";
    }
	
	@Override
	public <T, U> T accept(TypeVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
