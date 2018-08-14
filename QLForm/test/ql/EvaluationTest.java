package test.ql;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import org.junit.Assert.assertEquals;
import ast.expression.*;
import ast.type.*;
import ast.parser.*;
import visiting.EvaluationVisitor;
import visiting.value.*;

public class EvaluationTest {
	
	/**
	 * calls evaluation method in EvaluationVisitor to return objects such as Value
	 * so that it gets compared in different test methods against the exprected value
	 * @param: expressionStr
	 * @return: object
	 */
	private void Object evaluate(String expressionStr) throws IOException {
		return EvaluationVisitor.evaluate(createExpression(expressionStr), null);
	}

	/**
	 *  returns an Expression to be passed for the evaluator
	 * @param expressionStr
	 * @return Expression
	 * @throws IOException
	 */
	public static Expression createExpression(String expressionStr) throws IOException {
		TokenStream tokenStream = new CommonTokenStream(new QLLexer(new ANTLRInputStream(expressionStr)));
		QLParser parser = new QLParser(tokenStream);
		return parser.expr().result;
	}
	
	/** 
	 * test methods of values such as add, sub, or
	 * @return void
	 * @throws IOException
	 */
	@Test
	public void valueMethodsTest() throws IOException {
		/* logical expressions */
		assertEquals(BooleanValue.TRUE, evaluate("true || true"));
		assertEquals(BooleanValue.FALSE, evaluate("false || false"));
		assertEquals(BooleanValue.TRUE, evaluate("true || false"));
		assertEquals(BooleanValue.TRUE, evaluate("false || true"));

		assertEquals(BooleanValue.TRUE, evaluate("true && true"));
		assertEquals(BooleanValue.FALSE, evaluate("false && false"));
		assertEquals(BooleanValue.FALSE, evaluate("true && false"));
		assertEquals(BooleanValue.FALSE, evaluate("false && true"));

		assertEquals(BooleanValue.FALSE, evaluate("!true"));
		assertEquals(BooleanValue.TRUE, evaluate("!false"));
		
		/* literals */
		assertEquals(BooleanValue.TRUE, evaluate("true"));
		assertEquals(BooleanValue.TRUE, evaluate("yes"));
		assertEquals(BooleanValue.FALSE, evaluate("false"));
		assertEquals(BooleanValue.FALSE, evaluate("no"));
		
		assertEquals(new IntegerValue(20), evaluate("20"));
		assertEquals(new IntegerValue(21), evaluate("21"));

		assertEquals(new StringValue("testing evaluation visitor"), evaluate("\"text\""));

		/* mathematical-arithmetics */
		//add
		assertEquals(new IntegerValue(3), evaluate("1+2"));
		assertEquals(new IntegerValue(3), evaluate("(1+2)"));

		//sub
		assertEquals(new IntegerValue(-1), evaluate("1-2"));
		assertEquals(new IntegerValue(-1), evaluate("(1-2)"));

		//mul
		assertEquals(new IntegerValue(2), evaluate("1*2"));
		assertEquals(new IntegerValue(-2), evaluate("-1*2"));
		assertEquals(new IntegerValue(2), evaluate("-1*-2"));
		assertEquals(new IntegerValue(-2), evaluate("1*-2"));
		assertEquals(new IntegerValue(2), evaluate("(1*2)"));
		assertEquals(new IntegerValue(-2), evaluate("-(1*2)"));

		//div
		assertEquals(new IntegerValue(5), evaluate("10/2"));
		assertEquals(new IntegerValue(6), evaluate("(12/2)"));

		//GT
		assertEquals(BooleanValue.TRUE, evaluate("1>0"));
		assertEquals(BooleanValue.FALSE, evaluate("0>0"));
		assertEquals(BooleanValue.FALSE, evaluate("0>1"));

		//GEq
		assertEquals(BooleanValue.TRUE, evaluate("0>=0"));
		assertEquals(BooleanValue.TRUE, evaluate("1>=0"));
		assertEquals(BooleanValue.TRUE, evaluate("1>=0"));
		assertEquals(BooleanValue.FALSE, evaluate("0>=2"));

		//LT
		assertEquals(BooleanValue.FALSE, evaluate("0<0"));
		assertEquals(BooleanValue.TRUE, evaluate("0<1"));
		assertEquals(BooleanValue.FALSE, evaluate("1<0"));
		
		//LEq
		assertEquals(BooleanValue.TRUE, evaluate("1<=2"));
		assertEquals(BooleanValue.TRUE, evaluate("1<=1"));
		assertEquals(BooleanValue.FALSE, evaluate("1<=0"));
		assertEquals(BooleanValue.FALSE, evaluate("1<=-1"));

		//Eq - NEq
		assertEquals(BooleanValue.TRUE, evaluate("0==0"));
		assertEquals(BooleanValue.TRUE, evaluate("\"aa\"==\"aa\""));
		assertEquals(BooleanValue.TRUE, evaluate("\"aa\"!=\"bb\""));
		assertEquals(BooleanValue.TRUE, evaluate("\"cc\"!=\"dd\""));
		assertEquals(BooleanValue.FALSE, evaluate("1.2==0.0"));
	}

	/** 
	 * tests evaulating different types of expressions using assertEquals
	 * @return void
	 * @throws IOException
	 */
	@Test
	public void evaluateExpressionsTest() throws IOException {
		// arithmetic expressions evaluation
		assertEquals(new IntegerValue(14), evaluate("(1+6)*2"));
		assertEquals(new IntegerValue(14), evaluate("2+2*6"));
		assertEquals(new IntegerValue(3), evaluate("2--(2-1)"));
		assertEquals(new IntegerValue(1), evaluate("1+1*0"));
		assertEquals(new IntegerValue(0), evaluate("1*0"));
		assertEquals(new IntegerValue(0), evaluate("1-1"));
		assertEquals(new IntegerValue(0), evaluate("1 -1"));
		assertEquals(new IntegerValue(-14), evaluate("-14"));
		assertEquals(new IntegerValue(-28), evaluate("-14-14"));
		assertEquals(new IntegerValue(-28), evaluate("-(14+14)"));
		assertEquals(new IntegerValue(-8), evaluate("-1*(4*2)"));
		assertEquals(new IntegerValue(-2), evaluate("-1*(4/2)"));
		assertEquals(new IntegerValue(-4), evaluate("-1*(4*2/2)"));

		//logical evaluation
		assertEquals(BooleanValue.TRUE, evaluate("true || true && true || false"));
		assertEquals(BooleanValue.TRUE, evaluate("true || false && true || false"));
		
		assertEquals(BooleanValue.FALSE, evaluate("(false || false) && (false || true)"));
		assertEquals(BooleanValue.FALSE, evaluate("(false || false) && (true || false)"));
		assertEquals(BooleanValue.FALSE, evaluate("(false || false) && (false || false)"));
		assertEquals(BooleanValue.FALSE, evaluate("false || true && false"));
		assertEquals(BooleanValue.FALSE, evaluate("false || (true && false)"));
		assertEquals(BooleanValue.FALSE, evaluate("(false || true) && false"));
		assertEquals(BooleanValue.FALSE, evaluate("false || (false && true) || false"));
		assertEquals(BooleanValue.FALSE, evaluate("false || false && true || false"));

		//comparision & logical evaluation
		assertEquals(BooleanValue.TRUE, evaluate("1 > 2 || 2 > 1"));
		assertEquals(BooleanValue.TRUE, evaluate("(0*(14*4/2)) == 0"));
		assertEquals(BooleanValue.TRUE, evaluate("true || 0 > 1"));
		
		assertEquals(BooleanValue.FALSE, evaluate("1 >(1*1) || false"));
		assertEquals(BooleanValue.FALSE, evaluate("0 > 1 && 1 > 0"));
	}
}

