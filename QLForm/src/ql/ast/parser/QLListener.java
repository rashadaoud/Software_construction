// Generated from .\QL\QL.g4 by ANTLR 4.7.1

	package ql.ast.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(QLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(QLParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(QLParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(QLParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterQuestionType(QLParser.QuestionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitQuestionType(QLParser.QuestionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(QLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(QLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(QLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(QLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QLParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QLParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(QLParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(QLParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(QLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(QLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(QLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(QLParser.FormContext ctx);
}