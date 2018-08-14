package qls.visiting;

import qls.ast.rule.*;

public interface ItemVisitor<T, U> {
	public T visit(TypeItem rule, U ctx);
	public T visit(QuestionItem rule, U ctx);
}
