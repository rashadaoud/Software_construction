package ql.visiting;

import ql.visiting.value.BooleanValue;
import ql.visiting.value.Value;
import ql.ast.expression.*;

public class EvaluationVisitor implements ExpressionVisitor<Value, EvaluationContext> {
	
	// constructor
	private EvaluationVisitor() {

	}

	/**
	 * Main evaluator of expression
	* it evaluates each type of the expressions
	* it throws an error in case evaluation failed
	* @param Expression, Environment
	* @return Value
	*/
	public static Value evaluate(Expression expr, EvaluationContext ctx) {
		try {
			return expr.accept(new EvaluationVisitor(), ctx);
		} 
		catch (RuntimeException ex) {
			throw new RuntimeException("Error: not able to evaluate expression: " + expr.getLocation().getContent());
		}
	}


	@Override
	public Value visit(Add node, EvaluationContext ctx) {
		return node.getLeft().accept(this, ctx).add(node.getRight().accept(this, ctx));
	}

	@Override
	public Value visit(Sub node, EvaluationContext ctx) {
		return node.getLeft().accept(this,ctx).sub(node.getRight().accept(this, ctx));
	}
	
	@Override
	public Value visit(Mul node, EvaluationContext ctx) {
		return node.getLeft().accept(this, ctx).mul(node.getRight().accept(this,  ctx));
	}
	
	@Override
	public Value visit(Div node, EvaluationContext ctx) {
		return node.getLeft().accept(this, ctx).div(node.getRight().accept(this,  ctx));
	}
	
	@Override
	public Value visit(Pos node, EvaluationContext ctx) {
		return node.getExpression().accept(this,ctx).pos();
	}

	@Override
	public Value visit(Neg node, EvaluationContext ctx) {
		return node.getExpression().accept(this,ctx).neg();
	}

	@Override
	public Value visit(IdentityExpression node, EvaluationContext ctx) {
		return ctx.getValue(node.getName());
	}

	@Override
	public BooleanValue visit(And node, EvaluationContext ctx) {
		return node.getLeft().accept(this, ctx).and(node.getRight().accept(this, ctx));
	}

	@Override
	public BooleanValue visit(Or node, EvaluationContext ctx) {
		return node.getLeft().accept(this, ctx).or(node.getRight().accept(this, ctx));
	}

	@Override
	public BooleanValue visit(Not node, EvaluationContext ctx) {
		return node.getExpression().accept(this, ctx).not();
	}
	
	@Override
	public BooleanValue visit(GT node, EvaluationContext ctx) {
		return node.getLeft().accept(this, ctx).gt(node.getRight().accept(this, ctx));
	}

	@Override
	public BooleanValue visit(GEq node, EvaluationContext ctx) {
		return node.getLeft().accept(this,ctx).gEq(node.getRight().accept(this, ctx));
	}

	@Override
	public BooleanValue visit(LT node, EvaluationContext ctx) {
		return node.getLeft().accept(this,ctx).lt(node.getRight().accept(this,ctx));
	}

	@Override
	public BooleanValue visit(LEq node, EvaluationContext ctx) {
		return node.getLeft().accept(this,ctx).lEq(node.getRight().accept(this, ctx));
	}

	
	@Override
	public BooleanValue visit(Eq node, EvaluationContext ctx) {
		return node.getLeft().accept(this, ctx).eq(node.getRight().accept(this, ctx));
	}

	@Override
	public BooleanValue visit(NEq node, EvaluationContext ctx) {
		return node.getLeft().accept(this, ctx).eq(node.getRight().accept(this, ctx)).not();
	}

	@Override
	public Value visit(LiteralExpression node, EvaluationContext ctx) {
		return node.getLiteral().getValue();
	}

	@Override
	public Value visit(ParenthesesExpression node, EvaluationContext ctx) {
		return node.getExpression().accept(this, ctx);
	}
}
