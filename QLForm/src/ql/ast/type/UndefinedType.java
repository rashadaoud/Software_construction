package ql.ast.type;

import ql.visiting.TypeVisitor;

public class UndefinedType extends Type {
	
	public UndefinedType() {
		
	}
	
    public String getTypeString() {
      return "UndefinedType";
    }
	
    @Override
    public <T, U> T accept(TypeVisitor<T, U> visitor, U ctx) {
      return visitor.visit(this, ctx);
    }
}
