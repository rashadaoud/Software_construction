package ql.utils;

import org.antlr.v4.runtime.ParserRuleContext;

public class CodeReference {

	private int startLine;
	private int startColumn;
	private String content;

	
	public CodeReference(int startLine, int startColumn, String content) {
		this.startLine = startLine;
		this.startColumn = startColumn;
		this.setContent(content);
	}
	
	public CodeReference(ParserRuleContext context) {
		StringBuilder contentBuilder;
		contentBuilder = new StringBuilder();
		for (int r = 0;r < context.getChildCount();r++) {
			contentBuilder.append(context.getChild(r).getText());
			contentBuilder.append(' ');
		}
		setContent(contentBuilder.toString());
			
		startLine = context.getStart().getLine();
		startColumn = context.getStart().getCharPositionInLine() + 1;
	}

	public int getStartLine() {
		return startLine;
	}
	
	public int getStartColumn() {
		return startColumn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}