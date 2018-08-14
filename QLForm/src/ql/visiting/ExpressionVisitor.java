package ql.visiting;

import ql.ast.expression.*;

public interface ExpressionVisitor<T, U> {
	
	public T visit(IdentityExpression node, U ctx);
	public T visit(LiteralExpression node, U ctx);
	public T visit(ParenthesesExpression parenthesesExpression, U ctx);
	  
	public T visit(Add node, U ctx);
	public T visit(Sub node, U ctx);
	public T visit(Div node, U ctx);
	public T visit(Mul node, U ctx);
	
	public T visit(Eq node, U ctx);
	public T visit(NEq node, U ctx);
	
	public T visit(GEq node, U ctx);
	public T visit(GT node, U ctx);
	public T visit(LEq node, U ctx);
	public T visit(LT node, U ctx);
	
	public T visit(And node, U ctx);
	public T visit(Or node, U ctx);
	public T visit(Not node, U ctx);
	  
	public T visit(Pos node, U ctx);
	public T visit(Neg node, U ctx);
}
