package ql.visiting;

import ql.ast.Block;
import ql.ast.statement.*;

public interface StatementVisitor<T, U> {
	public T visit(Block node, U ctx);
	public T visit(IfThenStatement node, U ctx);
	public T visit(IfThenElseStatement node, U ctx);
	public T visit(AnswerableQuestion node, U ctx);
	public T visit(ComputedQuestion node, U ctx);
}
