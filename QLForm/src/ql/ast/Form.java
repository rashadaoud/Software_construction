package ql.ast;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import ql.ast.AstNode;
import ql.ast.literal.Identifier;
import ql.ast.parser.QLLexer;
import ql.ast.parser.QLParser;

public class Form extends AstNode{

	private final Identifier id;
	private final Block block;

	public Form(Identifier id, Block block) {
		this.id = id;
		this.block = block;
	}

	public Identifier getId() {
		return id;
	}

	public Block getBlock() {
		return block;
	}
	
	// generate Form from ql-program
	public static Form parseFileToForm(File file) throws IOException {
		return Form.add(new ANTLRFileStream(file.getAbsolutePath()));
	}
	
	public static Form add(InputStream istream) throws IOException {
		return Form.add(new ANTLRInputStream(istream));
	}

	private static Form add(CharStream cSteam) throws IOException {
		TokenStream tokenStream = new CommonTokenStream(new QLLexer(cSteam));
		QLParser parser = new QLParser(tokenStream);
		return parser.form().result;
	}
}