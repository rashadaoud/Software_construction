package qls.ast;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import ql.ast.AstNode;
import ql.ast.literal.Identifier;
import ql.ast.statement.Question;
import qls.ast.parser.QLSLexer;
import qls.ast.parser.QLSParser;
import qls.ast.rule.*;

public class StyleSheet extends AstNode {
	
	private final Identifier id;
	private final List<Page> pages;

	// constructor
	public StyleSheet(String id, List<Page> pages) {
		this.id = new Identifier(id);
		this.pages = pages;
	}

	public List<Page> getPages() {
		return Collections.unmodifiableList(pages);
	}
	
	public Identifier getIdentifier(){
		return id;
	}

	// generate ast tree
	public static StyleSheet parseFileToStyleSheetAst(File file)	throws IOException {
		return StyleSheet.add(new ANTLRFileStream(file.getAbsolutePath()));
	}

	private static StyleSheet add(CharStream cSteam) throws IOException {
		TokenStream tokenStream = new CommonTokenStream(new QLSLexer(cSteam));
		QLSParser parser = new QLSParser(tokenStream);
		return parser.stylesheet().result;
	}
	
	
	public QuestionItem getQuestionItem(Question question) {
		for (Page page : pages) {
			for (Section sc : page.getSections()) {
				if (!sc.hasQuestion(question)) {
					continue;
				}
				return sc.getQuestionItem(question);
			}
		}
		return null;
	}
}
