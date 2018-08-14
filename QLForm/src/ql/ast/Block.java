package ql.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ql.ast.statement.Statement;
import ql.visiting.StatementVisitor;


public class Block extends AstNode {

	private List<Statement> statements;

	public Block(List<Statement> statements) {
		this.statements = statements;
	}

	public Block() {
		statements = new ArrayList<>();
	}

    public void insertStatement(Statement statement){
        statements.add(statement);
    }
    
    public List<Statement> getStatements(){
        return Collections.unmodifiableList(statements);
    }
    
	public <T, U> T accept(StatementVisitor<T, U> visitor, U ctx){
		return visitor.visit(this, ctx);
    }
}
