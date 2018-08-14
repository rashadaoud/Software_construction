package ql.visiting;

import java.util.HashMap;
import java.util.Map;

import ql.ast.Block;
import ql.ast.Form;
import ql.ast.expression.*;
import ql.ast.literal.*;
import ql.ast.statement.*;
import ql.ast.type.*;
import ql.checking.eventHandling.CheckerMessages;
import ql.checking.eventHandling.EventMessage;
import ql.utils.MessageTypeEnum;

	
public class TypeCheckerVisitor 
    implements ExpressionVisitor<Type, Void>, StatementVisitor<Void, Void>, LiteralVisitor<Type, Void> {
	
	public CheckerMessages events = new CheckerMessages();
	
	// constructor
	public TypeCheckerVisitor(CheckerMessages events) {
		this.events = events;
	}
	
	private Map<String, Type> mapNameType = new HashMap<>();
	
 	public void insertToMap(String name, Type type) {
    	mapNameType.put(name, type);
 	}

	public Type getType(String name) {
		if (!mapNameType.containsKey(name)) {
			return Type.UNDEFINED;
		}
		return mapNameType.get(name);
 	}
	


	public void visit(Form form) {
		form.getBlock().accept(new MainVisitor<Void, Void>() {
						 @Override
						 public Void visit(ComputedQuestion question, Void ctx) {
							 insertToMap(question.getIdentifier().toString(), question.getType());
						   return null;
						 };
	
						 @Override
						 public Void visit(AnswerableQuestion question, Void ctx) {
							 insertToMap(question.getIdentifier().toString(), question.getType());
						   return null;
						 }
					 	},
					    null);
	
		form.getBlock().accept(this, null);
	}
	
	private void checkOperandsInvalidTypes(BinaryExpression expr, Type expectedType) {
		checkTypeMismatch(expr.getLeft(), expectedType);
		checkTypeMismatch(expr.getRight(), expectedType);
	}

	private void checkTypeMismatch(Expression expr, Type expectedType) {
		Type currentType =  expr.accept(this, null);
		/*System.out.println("Check types: " +
							currentType.getTypeString() + "\t" + expectedType.getTypeString());*/
		if (isUndefinedType(currentType)) {
			return;
		}
		if (currentType.getTypeString() != expectedType.getTypeString()) {
			events.insert(new EventMessage(
							"Type mismatch in " + expr.getLocation().getContent() + " between "+
					  		currentType.getTypeString() + ", and " + expectedType.getTypeString(),
							MessageTypeEnum.error));
		}
	}
	
	private boolean isUndefinedType(Type type) {
		return type.getTypeString() == (new UndefinedType()).getTypeString();
	}

	/* Block */
	@Override
	public Void visit(Block node, Void ctx) {
		node.getStatements().forEach(statement -> statement.accept(this, ctx));
		return null;
	}

	/* Statements and master-expressions */
	@Override
	public Void visit(IfThenStatement node, Void ctx) {
		checkTypeMismatch(node.getCondition(), Type.BOOLEAN);
		node.getIfBody().accept(TypeCheckerVisitor.this, ctx);
		return null;
	}
	
	@Override
	public Void visit(IfThenElseStatement node, Void ctx) {
		checkTypeMismatch(node.getCondition(), Type.BOOLEAN);
		node.getIfBody().accept(TypeCheckerVisitor.this, ctx);
		node.getElseBody().accept(TypeCheckerVisitor.this, ctx);
		return null;
	}
	
	@Override
	public Void visit(ComputedQuestion node, Void ctx) {
	   Type type =  getType(node.getIdentifier().toString());
	   checkTypeMismatch(node.getExpression(), type);
	   return null;
	}

	@Override
	public Void visit(AnswerableQuestion node, Void ctx) {
	   return null;
	}


	@Override
	public Type visit(LiteralExpression node, Void ctx) {
		return node.getLiteral().accept(this, ctx);
	}
	
	@Override
	public Type visit(IdentityExpression node, Void ctx) {
	   Type type;
	   type = getType(node.getName());
	   if (isUndefinedType(type)) {
			events.insert(new EventMessage(
					"Undeclared variable " + node.getName() +
					" at line:" + node.getLocation().getStartLine(),
					MessageTypeEnum.error));
		}
	   return type;
	}



	/* Literals, return type */
	@Override
	public Type visit(BooleanLiteral node, Void ctx) {
	   return Type.BOOLEAN;
	}

	@Override
	public Type visit(IntegerLiteral node, Void ctx) {
	   return Type.INTEGER;
	}

	@Override
	public Type visit(StringLiteral node, Void ctx) {
	   return Type.STRING;
	}
   
	@Override
	public Type visit(DateLiteral node, Void ctx) {
	   return Type.DATE;
	}
   
	@Override
	public Type visit(DecimalLiteral node, Void ctx) {
	   return Type.DECIMAL;
	}
   
	@Override
	public Type visit(MoneyLiteral node, Void ctx) {
	   return Type.MONEY;
	}


	/* Mathematical operations */
	@Override
	public Type visit(Add node, Void ctx) {
		Type exprType = node.accept(this, ctx);
		checkOperandsInvalidTypes(node, exprType);
		return exprType;
	}
	
	@Override
	public Type visit(Sub node, Void ctx) {
		Type exprType = node.accept(this, ctx);
		checkOperandsInvalidTypes(node, exprType);
		return exprType;
	}

	@Override
	public Type visit(Mul node, Void ctx)  {
		Type exprType = node.accept(this, ctx);
		checkOperandsInvalidTypes(node, exprType);
		return exprType;
	}
	
	@Override
	public Type visit(Div node, Void ctx) {
		Type exprType = node.accept(this, ctx);
		System.out.println(exprType.getTypeString());
		checkOperandsInvalidTypes(node, exprType);
		return exprType;
	}

	
	@Override
	public Type visit(Neg node, Void ctx) {
		Type exprType = node.accept(this, ctx);
		checkTypeMismatch(node, exprType);
		return exprType;
	}

	@Override
	public Type visit(Pos node, Void ctx) {
		Type exprType = node.accept(this, ctx);
		checkTypeMismatch(node, exprType);
		return exprType;
	}


	/* Comparison operations */
	@Override
	public Type visit(GT node, Void ctx) {
	   checkOperandsInvalidTypes(node, node.accept(this, ctx));
	   return Type.BOOLEAN;
	}
	
	@Override
	public Type visit(GEq node, Void ctx) {
		checkOperandsInvalidTypes(node, node.accept(this, ctx));
		return Type.BOOLEAN;
	}
	
	@Override
	public Type visit(LT node, Void ctx) {
		checkOperandsInvalidTypes(node, node.accept(this, ctx));
		return Type.BOOLEAN;
	}

	@Override
	public Type visit(LEq node, Void ctx) {
	   checkOperandsInvalidTypes(node, node.accept(this, ctx));
	   return Type.BOOLEAN;
	}
	
	@Override
	public Type visit(Eq node, Void ctx) {
		Type leftType = node.getLeft().accept(this, ctx);
		Type rightType = node.getRight().accept(this, ctx);
		if (!isUndefinedType(leftType) && !isUndefinedType(rightType)) {
		  if (leftType.getTypeString() != rightType.getTypeString()) {
			  events.insert(new EventMessage(
								"Invalid operand for Eq: " + 
					  			leftType.getTypeString() + ", " + rightType.getTypeString() +
					  			" in:" + node.getLocation().getContent(),
					  			MessageTypeEnum.error));
		  }
		}
		return Type.BOOLEAN;
	}

	@Override
	public Type visit(NEq node, Void ctx) {
		Type leftType = node.getLeft().accept(this, ctx);
		Type rightType = node.getRight().accept(this, ctx);
		if (!isUndefinedType(leftType) && !isUndefinedType(rightType)) {
		  if (leftType.getTypeString() != rightType.getTypeString()) {
			  events.insert(new EventMessage(
								"Invalid operand for NEq: " +
					  			leftType.getTypeString() + ", " + rightType.getTypeString() +
					  			" in:" + node.getLocation().getContent(),
					  			MessageTypeEnum.error));
		  }
		}
		return Type.BOOLEAN;
	}

	
	/* Logical operations */
	@Override
	public Type visit(And node, Void ctx) {
	   checkOperandsInvalidTypes(node, Type.BOOLEAN);
	   return Type.BOOLEAN;
	}

	@Override
	public Type visit(Or node, Void ctx) {
	   checkOperandsInvalidTypes(node, Type.BOOLEAN);
	   return Type.BOOLEAN;
	}

	@Override
	public Type visit(Not node, Void ctx) {
		checkTypeMismatch(node, Type.BOOLEAN);
		return Type.BOOLEAN;
	}

	/* (expression) */
	@Override
	public Type visit(ParenthesesExpression node, Void ctx) {
		checkTypeMismatch(node.getExpression(), Type.BOOLEAN);
		return Type.BOOLEAN;
	}

 }
