package qls.ast.parser;
// Generated from .\QLS.g4 by ANTLR 4.7.1

	import java.util.Map;
	import java.util.HashMap;
	import ql.ast.*;
	import ql.ast.literal.*;
	import ql.ast.type.*;
	import ql.utils.CodeReference;
	import qls.ast.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLSParser}. 
 */
public interface QLSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLSParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(QLSParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(QLSParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(QLSParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(QLSParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#questionType}.
	 * @param ctx the parse tree
	 */
	void enterQuestionType(QLSParser.QuestionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#questionType}.
	 * @param ctx the parse tree
	 */
	void exitQuestionType(QLSParser.QuestionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#style}.
	 * @param ctx the parse tree
	 */
	void enterStyle(QLSParser.StyleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#style}.
	 * @param ctx the parse tree
	 */
	void exitStyle(QLSParser.StyleContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#styles}.
	 * @param ctx the parse tree
	 */
	void enterStyles(QLSParser.StylesContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#styles}.
	 * @param ctx the parse tree
	 */
	void exitStyles(QLSParser.StylesContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void enterWidgetType(QLSParser.WidgetTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void exitWidgetType(QLSParser.WidgetTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QLSParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QLSParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#defaultType}.
	 * @param ctx the parse tree
	 */
	void enterDefaultType(QLSParser.DefaultTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#defaultType}.
	 * @param ctx the parse tree
	 */
	void exitDefaultType(QLSParser.DefaultTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(QLSParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(QLSParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#widgetOptions}.
	 * @param ctx the parse tree
	 */
	void enterWidgetOptions(QLSParser.WidgetOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#widgetOptions}.
	 * @param ctx the parse tree
	 */
	void exitWidgetOptions(QLSParser.WidgetOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(QLSParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(QLSParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(QLSParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(QLSParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(QLSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(QLSParser.StylesheetContext ctx);
}