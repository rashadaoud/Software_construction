package ql.ast.expression;

import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

import ql.visiting.ExpressionVisitor;
import ql.visiting.MainVisitor;
import ql.ast.AstNode;

public abstract class Expression extends AstNode {
	public abstract <T, U> T accept(ExpressionVisitor<T, U> visitor, U ctx);
	 
	public Set<String> collectVariables() {
		Collections.emptySet();
		Set<String> variables = new HashSet<>();
		this.accept(new MainVisitor<Void, Void>(){
			@Override
			public Void visit(IdentityExpression var, Void ctx) {
				variables.add(var.getName());
                return null;
			}
		},
		null);
		return Collections.unmodifiableSet(variables);
	}
}