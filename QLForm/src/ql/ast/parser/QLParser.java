// Generated from .\QL\QL.g4 by ANTLR 4.7.1

	package ql.ast.parser;
	import ql.antlr.grammar.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import ql.ast.AstNode;
import ql.ast.Block;
import ql.ast.Form;
import ql.ast.expression.*;
import ql.ast.statement.*;
import ql.ast.literal.*;
import ql.ast.type.*;
import ql.utils.CodeReference;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, WHITESPACE=29, SingleComment=30, 
		BlockComment=31, IDENT=32, DIGIT=33, INTEGER=34, STRING=35, BOOLEAN=36, 
		TwoDigits=37, QuadDigits=38, MONEY=39, DECIMAL=40, DATE=41;
	public static final int
		RULE_literal = 0, RULE_identifier = 1, RULE_questionType = 2, RULE_expr = 3, 
		RULE_statement = 4, RULE_question = 5, RULE_ifElseStatement = 6, RULE_block = 7, 
		RULE_form = 8;
	public static final String[] ruleNames = {
		"literal", "identifier", "questionType", "expr", "statement", "question", 
		"ifElseStatement", "block", "form"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'money'", "'integer'", "'boolean'", "'string'", "'date'", "'decimal'", 
		"'!'", "'('", "')'", "'+'", "'-'", "'&&'", "'||'", "'=='", "'!='", "'*'", 
		"'/'", "'>'", "'>='", "'<'", "'<='", "':'", "'if'", "'else'", "'{'", "'}'", 
		"'Form'", "'form'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "WHITESPACE", "SingleComment", "BlockComment", 
		"IDENT", "DIGIT", "INTEGER", "STRING", "BOOLEAN", "TwoDigits", "QuadDigits", 
		"MONEY", "DECIMAL", "DATE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

    private <T extends AstNode> T addCodeReference(ParserRuleContext context, T node){
        node.setLocation(new CodeReference(context));
        return (T) node;
    }

	public QLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LiteralContext extends ParserRuleContext {
		public Literal result;
		public Token MONEY;
		public Token INTEGER;
		public Token BOOLEAN;
		public Token STRING;
		public Token DATE;
		public Token DECIMAL;
		public TerminalNode MONEY() { return getToken(QLParser.MONEY, 0); }
		public TerminalNode INTEGER() { return getToken(QLParser.INTEGER, 0); }
		public TerminalNode BOOLEAN() { return getToken(QLParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public TerminalNode DATE() { return getToken(QLParser.DATE, 0); }
		public TerminalNode DECIMAL() { return getToken(QLParser.DECIMAL, 0); }
		public TerminalNode IDENT() { return getToken(QLParser.IDENT, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_literal);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MONEY:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				((LiteralContext)_localctx).MONEY = match(MONEY);
				 ((LiteralContext)_localctx).result =  addCodeReference(_localctx, new MoneyLiteral(BigDecimal(Double.valueOf(((LiteralContext)_localctx).DECIMAL.getText())))); 
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				((LiteralContext)_localctx).INTEGER = match(INTEGER);
				 ((LiteralContext)_localctx).result = addCodeReference(_localctx, new IntegerLiteral(Integer.valueOf((((LiteralContext)_localctx).INTEGER!=null?((LiteralContext)_localctx).INTEGER.getText():null)))); 
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(22);
				((LiteralContext)_localctx).BOOLEAN = match(BOOLEAN);
				 ((LiteralContext)_localctx).result =  addCodeReference(_localctx, new BooleanLiteral(Boolean.valueOf((((LiteralContext)_localctx).BOOLEAN!=null?((LiteralContext)_localctx).BOOLEAN.getText():null)))); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(24);
				((LiteralContext)_localctx).STRING = match(STRING);
				 ((LiteralContext)_localctx).result =  addCodeReference(_localctx, new StringLiteral(String.valueOf(((LiteralContext)_localctx).STRING))); 
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 5);
				{
				setState(26);
				((LiteralContext)_localctx).DATE = match(DATE);
				 ((LiteralContext)_localctx).result =  addCodeReference(_localctx, new DateLiteral(new Date((((LiteralContext)_localctx).DATE.getText().toString())))); 
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(28);
				((LiteralContext)_localctx).DECIMAL = match(DECIMAL);
				 ((LiteralContext)_localctx).result =  addCodeReference(_localctx, new DecimalLiteral(Double.valueOf(((LiteralContext)_localctx).DECIMAL.getText()))); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	private BigDecimal BigDecimal(Double value) {
		return BigDecimal.valueOf(value);
	}
	public static class IdentifierContext extends ParserRuleContext {
		public Identifier result;
		public Token IDENT;
		public TerminalNode IDENT() { return getToken(QLParser.IDENT, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			((IdentifierContext)_localctx).IDENT = match(IDENT);
			 ((IdentifierContext)_localctx).result =  addCodeReference(_localctx, new Identifier((((IdentifierContext)_localctx).IDENT!=null?((IdentifierContext)_localctx).IDENT.getText():null))); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionTypeContext extends ParserRuleContext {
		public Type result;
		public QuestionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestionType(this);
		}
	}

	public final QuestionTypeContext questionType() throws RecognitionException {
		QuestionTypeContext _localctx = new QuestionTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_questionType);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(T__0);
				 ((QuestionTypeContext)_localctx).result =  addCodeReference(_localctx, new MoneyType());
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(T__1);
				 ((QuestionTypeContext)_localctx).result =  addCodeReference(_localctx, new IntegerType());
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				match(T__2);
				 ((QuestionTypeContext)_localctx).result =  addCodeReference(_localctx, new BooleanType());
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				match(T__3);
				 ((QuestionTypeContext)_localctx).result =  addCodeReference(_localctx, new StringType());
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				match(T__4);
				 ((QuestionTypeContext)_localctx).result =  addCodeReference(_localctx, new DateType());
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 6);
				{
				setState(47);
				match(T__5);
				 ((QuestionTypeContext)_localctx).result =  addCodeReference(_localctx, new DecimalType());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Expression result;
		public ExprContext left;
		public IdentifierContext identifier;
		public LiteralContext literal;
		public ExprContext expr;
		public ExprContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(52);
				((ExprContext)_localctx).identifier = identifier();
				 ((ExprContext)_localctx).result =  addCodeReference(_localctx, new IdentityExpression(((ExprContext)_localctx).identifier.getText())); 
				}
				break;
			case 2:
				{
				setState(55);
				((ExprContext)_localctx).literal = literal();
				 ((ExprContext)_localctx).result =  addCodeReference(_localctx, new LiteralExpression(((ExprContext)_localctx).literal.result)); 
				}
				break;
			case 3:
				{
				setState(58);
				match(T__6);
				setState(59);
				((ExprContext)_localctx).expr = expr(16);
				 ((ExprContext)_localctx).result =  addCodeReference(_localctx, new Not(((ExprContext)_localctx).expr.result)); 
				}
				break;
			case 4:
				{
				setState(62);
				match(T__7);
				setState(63);
				((ExprContext)_localctx).expr = expr(0);
				setState(64);
				match(T__8);
				 ((ExprContext)_localctx).result =  ((ExprContext)_localctx).expr.result; 
				}
				break;
			case 5:
				{
				setState(67);
				match(T__9);
				setState(68);
				((ExprContext)_localctx).expr = expr(14);
				 ((ExprContext)_localctx).result =  addCodeReference(_localctx, new Pos(((ExprContext)_localctx).expr.result)); 
				}
				break;
			case 6:
				{
				setState(71);
				match(T__10);
				setState(72);
				((ExprContext)_localctx).expr = expr(13);
				 ((ExprContext)_localctx).result =  addCodeReference(_localctx, new Neg(((ExprContext)_localctx).expr.result)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(140);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						{
						setState(78);
						match(T__11);
						}
						setState(79);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(13);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new And(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						{
						setState(83);
						match(T__12);
						}
						setState(84);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(12);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new Or(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(87);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						{
						setState(88);
						match(T__13);
						}
						setState(89);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(11);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new Eq(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						{
						setState(93);
						match(T__14);
						}
						setState(94);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(10);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new NEq(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						{
						setState(98);
						match(T__15);
						}
						setState(99);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(9);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new Mul(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(102);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(105);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__6:
						case T__7:
						case T__9:
						case T__10:
						case IDENT:
						case INTEGER:
						case STRING:
						case BOOLEAN:
						case MONEY:
						case DECIMAL:
						case DATE:
							{
							}
							break;
						case T__16:
							{
							setState(104);
							match(T__16);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(107);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(8);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new Div(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						{
						setState(111);
						match(T__9);
						}
						setState(112);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(7);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new Add(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						{
						setState(116);
						match(T__10);
						}
						setState(117);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(6);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new Sub(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(120);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						{
						setState(121);
						match(T__17);
						}
						setState(122);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(5);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new GT(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						{
						setState(126);
						match(T__18);
						}
						setState(127);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(4);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new GEq(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(131);
						match(T__19);
						}
						setState(132);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(3);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new LT(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(136);
						match(T__20);
						}
						setState(137);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(2);
						((ExprContext)_localctx).result =   addCodeReference(_localctx, new LEq(((ExprContext)_localctx).left.result, ((ExprContext)_localctx).right.result));
						}
						break;
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Statement result;
		public QuestionContext question;
		public IfElseStatementContext ifElseStatement;
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public IfElseStatementContext ifElseStatement() {
			return getRuleContext(IfElseStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				((StatementContext)_localctx).question = question();
				 ((StatementContext)_localctx).result =  addCodeReference(_localctx, ((StatementContext)_localctx).question.result); 
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				((StatementContext)_localctx).ifElseStatement = ifElseStatement();
				 ((StatementContext)_localctx).result =  addCodeReference(_localctx, ((StatementContext)_localctx).ifElseStatement.result); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionContext extends ParserRuleContext {
		public Question result;
		public IdentifierContext identifier;
		public Token STRING;
		public QuestionTypeContext questionType;
		public ExprContext expr;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QLParser.STRING, 0); }
		public QuestionTypeContext questionType() {
			return getRuleContext(QuestionTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_question);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				((QuestionContext)_localctx).identifier = identifier();
				setState(154);
				match(T__21);
				setState(155);
				((QuestionContext)_localctx).STRING = match(STRING);
				setState(156);
				((QuestionContext)_localctx).questionType = questionType();
				((QuestionContext)_localctx).result =  addCodeReference(_localctx, new AnswerableQuestion(((QuestionContext)_localctx).identifier.result, (((QuestionContext)_localctx).STRING!=null?((QuestionContext)_localctx).STRING.getText():null), ((QuestionContext)_localctx).questionType.result, null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				((QuestionContext)_localctx).identifier = identifier();
				setState(160);
				match(T__21);
				setState(161);
				((QuestionContext)_localctx).STRING = match(STRING);
				setState(162);
				((QuestionContext)_localctx).questionType = questionType();
				setState(163);
				match(T__7);
				setState(164);
				((QuestionContext)_localctx).expr = expr(0);
				setState(165);
				match(T__8);
				((QuestionContext)_localctx).result =  addCodeReference(_localctx, new ComputedQuestion(((QuestionContext)_localctx).identifier.result, (((QuestionContext)_localctx).STRING!=null?((QuestionContext)_localctx).STRING.getText():null), ((QuestionContext)_localctx).questionType.result, ((QuestionContext)_localctx).expr.result, null));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseStatementContext extends ParserRuleContext {
		public Statement result;
		public ExprContext expr;
		public BlockContext block;
		public BlockContext ifBody;
		public BlockContext elseBody;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterIfElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitIfElseStatement(this);
		}
	}

	public final IfElseStatementContext ifElseStatement() throws RecognitionException {
		IfElseStatementContext _localctx = new IfElseStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifElseStatement);
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(T__22);
				setState(171);
				match(T__7);
				setState(172);
				((IfElseStatementContext)_localctx).expr = expr(0);
				setState(173);
				match(T__8);
				setState(174);
				((IfElseStatementContext)_localctx).block = block();
				 ((IfElseStatementContext)_localctx).result =  addCodeReference(_localctx, new IfThenStatement(((IfElseStatementContext)_localctx).expr.result, ((IfElseStatementContext)_localctx).block.result, null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(T__22);
				setState(178);
				match(T__7);
				setState(179);
				((IfElseStatementContext)_localctx).expr = expr(0);
				setState(180);
				match(T__8);
				setState(181);
				((IfElseStatementContext)_localctx).ifBody = block();
				setState(182);
				match(T__23);
				setState(183);
				((IfElseStatementContext)_localctx).elseBody = block();
				 ((IfElseStatementContext)_localctx).result =  addCodeReference(_localctx, new IfThenElseStatement(((IfElseStatementContext)_localctx).expr.result, ((IfElseStatementContext)_localctx).ifBody.result, ((IfElseStatementContext)_localctx).elseBody.result, null ));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public Block result;
		public List<Statement> statements = new ArrayList<>();;
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(188);
				match(T__24);
				}
				}
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__24 );
			setState(196); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(193);
				((BlockContext)_localctx).statement = statement();
				 _localctx.statements.add(((BlockContext)_localctx).statement.result); 
				}
				}
				setState(198); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__22 || _la==IDENT );
			setState(200);
			match(T__25);
			}
			_ctx.stop = _input.LT(-1);
			 List<Statement> statements = _localctx.statements;
			((BlockContext)_localctx).result =  addCodeReference(_localctx, new Block(statements ));
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormContext extends ParserRuleContext {
		public Form result;
		public IdentifierContext identifier;
		public BlockContext block;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if ( !(_la==T__26 || _la==T__27) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(203);
			((FormContext)_localctx).identifier = identifier();
			setState(204);
			((FormContext)_localctx).block = block();
			 ((FormContext)_localctx).result =  addCodeReference(_localctx, new Form(((FormContext)_localctx).identifier.result, ((FormContext)_localctx).block.result)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00d2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2#\n\2\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\64\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5N\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5l\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5\u008f\n\5\f\5\16\5\u0092\13\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u009a\n"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00ab"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\b\u00bd\n\b\3\t\6\t\u00c0\n\t\r\t\16\t\u00c1\3\t\3\t\3\t\6\t\u00c7\n"+
		"\t\r\t\16\t\u00c8\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\2\3\b\13\2\4\6\b\n\f"+
		"\16\20\22\2\3\3\2\35\36\2\u00ea\2\"\3\2\2\2\4$\3\2\2\2\6\63\3\2\2\2\b"+
		"M\3\2\2\2\n\u0099\3\2\2\2\f\u00aa\3\2\2\2\16\u00bc\3\2\2\2\20\u00bf\3"+
		"\2\2\2\22\u00cc\3\2\2\2\24\25\7)\2\2\25#\b\2\1\2\26\27\7$\2\2\27#\b\2"+
		"\1\2\30\31\7&\2\2\31#\b\2\1\2\32\33\7%\2\2\33#\b\2\1\2\34\35\7+\2\2\35"+
		"#\b\2\1\2\36\37\7*\2\2\37#\b\2\1\2 !\7\"\2\2!#\b\2\1\2\"\24\3\2\2\2\""+
		"\26\3\2\2\2\"\30\3\2\2\2\"\32\3\2\2\2\"\34\3\2\2\2\"\36\3\2\2\2\" \3\2"+
		"\2\2#\3\3\2\2\2$%\7\"\2\2%&\b\3\1\2&\5\3\2\2\2\'(\7\3\2\2(\64\b\4\1\2"+
		")*\7\4\2\2*\64\b\4\1\2+,\7\5\2\2,\64\b\4\1\2-.\7\6\2\2.\64\b\4\1\2/\60"+
		"\7\7\2\2\60\64\b\4\1\2\61\62\7\b\2\2\62\64\b\4\1\2\63\'\3\2\2\2\63)\3"+
		"\2\2\2\63+\3\2\2\2\63-\3\2\2\2\63/\3\2\2\2\63\61\3\2\2\2\64\7\3\2\2\2"+
		"\65\66\b\5\1\2\66\67\5\4\3\2\678\b\5\1\28N\3\2\2\29:\5\2\2\2:;\b\5\1\2"+
		";N\3\2\2\2<=\7\t\2\2=>\5\b\5\22>?\b\5\1\2?N\3\2\2\2@A\7\n\2\2AB\5\b\5"+
		"\2BC\7\13\2\2CD\b\5\1\2DN\3\2\2\2EF\7\f\2\2FG\5\b\5\20GH\b\5\1\2HN\3\2"+
		"\2\2IJ\7\r\2\2JK\5\b\5\17KL\b\5\1\2LN\3\2\2\2M\65\3\2\2\2M9\3\2\2\2M<"+
		"\3\2\2\2M@\3\2\2\2ME\3\2\2\2MI\3\2\2\2N\u0090\3\2\2\2OP\f\16\2\2PQ\7\16"+
		"\2\2QR\5\b\5\17RS\b\5\1\2S\u008f\3\2\2\2TU\f\r\2\2UV\7\17\2\2VW\5\b\5"+
		"\16WX\b\5\1\2X\u008f\3\2\2\2YZ\f\f\2\2Z[\7\20\2\2[\\\5\b\5\r\\]\b\5\1"+
		"\2]\u008f\3\2\2\2^_\f\13\2\2_`\7\21\2\2`a\5\b\5\fab\b\5\1\2b\u008f\3\2"+
		"\2\2cd\f\n\2\2de\7\22\2\2ef\5\b\5\13fg\b\5\1\2g\u008f\3\2\2\2hk\f\t\2"+
		"\2il\3\2\2\2jl\7\23\2\2ki\3\2\2\2kj\3\2\2\2lm\3\2\2\2mn\5\b\5\nno\b\5"+
		"\1\2o\u008f\3\2\2\2pq\f\b\2\2qr\7\f\2\2rs\5\b\5\tst\b\5\1\2t\u008f\3\2"+
		"\2\2uv\f\7\2\2vw\7\r\2\2wx\5\b\5\bxy\b\5\1\2y\u008f\3\2\2\2z{\f\6\2\2"+
		"{|\7\24\2\2|}\5\b\5\7}~\b\5\1\2~\u008f\3\2\2\2\177\u0080\f\5\2\2\u0080"+
		"\u0081\7\25\2\2\u0081\u0082\5\b\5\6\u0082\u0083\b\5\1\2\u0083\u008f\3"+
		"\2\2\2\u0084\u0085\f\4\2\2\u0085\u0086\7\26\2\2\u0086\u0087\5\b\5\5\u0087"+
		"\u0088\b\5\1\2\u0088\u008f\3\2\2\2\u0089\u008a\f\3\2\2\u008a\u008b\7\27"+
		"\2\2\u008b\u008c\5\b\5\4\u008c\u008d\b\5\1\2\u008d\u008f\3\2\2\2\u008e"+
		"O\3\2\2\2\u008eT\3\2\2\2\u008eY\3\2\2\2\u008e^\3\2\2\2\u008ec\3\2\2\2"+
		"\u008eh\3\2\2\2\u008ep\3\2\2\2\u008eu\3\2\2\2\u008ez\3\2\2\2\u008e\177"+
		"\3\2\2\2\u008e\u0084\3\2\2\2\u008e\u0089\3\2\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\t\3\2\2\2\u0092\u0090\3\2\2\2"+
		"\u0093\u0094\5\f\7\2\u0094\u0095\b\6\1\2\u0095\u009a\3\2\2\2\u0096\u0097"+
		"\5\16\b\2\u0097\u0098\b\6\1\2\u0098\u009a\3\2\2\2\u0099\u0093\3\2\2\2"+
		"\u0099\u0096\3\2\2\2\u009a\13\3\2\2\2\u009b\u009c\5\4\3\2\u009c\u009d"+
		"\7\30\2\2\u009d\u009e\7%\2\2\u009e\u009f\5\6\4\2\u009f\u00a0\b\7\1\2\u00a0"+
		"\u00ab\3\2\2\2\u00a1\u00a2\5\4\3\2\u00a2\u00a3\7\30\2\2\u00a3\u00a4\7"+
		"%\2\2\u00a4\u00a5\5\6\4\2\u00a5\u00a6\7\n\2\2\u00a6\u00a7\5\b\5\2\u00a7"+
		"\u00a8\7\13\2\2\u00a8\u00a9\b\7\1\2\u00a9\u00ab\3\2\2\2\u00aa\u009b\3"+
		"\2\2\2\u00aa\u00a1\3\2\2\2\u00ab\r\3\2\2\2\u00ac\u00ad\7\31\2\2\u00ad"+
		"\u00ae\7\n\2\2\u00ae\u00af\5\b\5\2\u00af\u00b0\7\13\2\2\u00b0\u00b1\5"+
		"\20\t\2\u00b1\u00b2\b\b\1\2\u00b2\u00bd\3\2\2\2\u00b3\u00b4\7\31\2\2\u00b4"+
		"\u00b5\7\n\2\2\u00b5\u00b6\5\b\5\2\u00b6\u00b7\7\13\2\2\u00b7\u00b8\5"+
		"\20\t\2\u00b8\u00b9\7\32\2\2\u00b9\u00ba\5\20\t\2\u00ba\u00bb\b\b\1\2"+
		"\u00bb\u00bd\3\2\2\2\u00bc\u00ac\3\2\2\2\u00bc\u00b3\3\2\2\2\u00bd\17"+
		"\3\2\2\2\u00be\u00c0\7\33\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2"+
		"\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c6\3\2\2\2\u00c3\u00c4"+
		"\5\n\6\2\u00c4\u00c5\b\t\1\2\u00c5\u00c7\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00cb\7\34\2\2\u00cb\21\3\2\2\2\u00cc\u00cd\t\2\2\2\u00cd\u00ce"+
		"\5\4\3\2\u00ce\u00cf\5\20\t\2\u00cf\u00d0\b\n\1\2\u00d0\23\3\2\2\2\r\""+
		"\63Mk\u008e\u0090\u0099\u00aa\u00bc\u00c1\u00c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}