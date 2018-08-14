package qls.ast.parser;
// Generated from .\QLS.g4 by ANTLR 4.7.1

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

import ql.ast.*;
import ql.ast.literal.*;
import ql.ast.parser.QLParser.LiteralContext;
import ql.ast.type.*;
import ql.utils.CodeReference;
import qls.ast.*;
import qls.ast.rule.*;
import qls.ast.style.*;
import qls.ast.widget.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, WHITESPACE=31, 
		SingleComment=32, BlockComment=33, IDENT=34, DIGIT=35, INTEGER=36, STRING=37, 
		BOOLEAN=38, TwoDigits=39, QuadDigits=40, MONEY=41, DECIMAL=42, DATE=43;
	public static final int
		RULE_identifier = 0, RULE_literal = 1, RULE_questionType = 2, RULE_style = 3, 
		RULE_styles = 4, RULE_widgetType = 5, RULE_question = 6, RULE_defaultType = 7, 
		RULE_item = 8, RULE_widgetOptions = 9, RULE_section = 10, RULE_page = 11, 
		RULE_stylesheet = 12;
	public static final String[] ruleNames = {
		"identifier", "literal", "questionType", "style", "styles", "widgetType", 
		"question", "defaultType", "item", "widgetOptions", "section", "page", 
		"stylesheet"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'money'", "'integer'", "'boolean'", "'string'", "'date'", "'decimal'", 
		"'color'", "':'", "'fontSize'", "'font'", "'width'", "'height'", "'text'", 
		"'checkbox'", "'('", "')'", "'default'", "'radioBtn'", "'dropdown'", "'slider'", 
		"'spinbox'", "'question'", "'widget'", "'{'", "'}'", "','", "'section'", 
		"'page'", "'Stylesheet'", "'stylesheet'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "WHITESPACE", "SingleComment", 
		"BlockComment", "IDENT", "DIGIT", "INTEGER", "STRING", "BOOLEAN", "TwoDigits", 
		"QuadDigits", "MONEY", "DECIMAL", "DATE"
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
	public String getGrammarFileName() { return "QLS.g4"; }

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

	public QLSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	

	private BigDecimal BigDecimal(Double value) {
		return BigDecimal.valueOf(value);
	}
	
	public static class IdentifierContext extends ParserRuleContext {
		public Identifier result;
		public Token IDENT;
		public TerminalNode IDENT() { return getToken(QLSParser.IDENT, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
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

	public static class LiteralContext extends ParserRuleContext {
		public Literal result;
		public Token INTEGER;
		public Token BOOLEAN;
		public Token STRING;
		public Token DECIMAL;
		public Token MONEY;
		public Token DATE;
		public TerminalNode INTEGER() { return getToken(QLSParser.INTEGER, 0); }
		public TerminalNode BOOLEAN() { return getToken(QLSParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public TerminalNode DECIMAL() { return getToken(QLSParser.DECIMAL, 0); }
		public TerminalNode MONEY() { return getToken(QLSParser.MONEY, 0); }
		public TerminalNode DATE() { return getToken(QLSParser.DATE, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_literal);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				((LiteralContext)_localctx).INTEGER = match(INTEGER);
				 ((LiteralContext)_localctx).result = addCodeReference(_localctx, new IntegerLiteral(Integer.valueOf((((LiteralContext)_localctx).INTEGER!=null?((LiteralContext)_localctx).INTEGER.getText():null)))); 
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				((LiteralContext)_localctx).BOOLEAN = match(BOOLEAN);
				 ((LiteralContext)_localctx).result =  addCodeReference(_localctx, new BooleanLiteral(Boolean.valueOf((((LiteralContext)_localctx).BOOLEAN!=null?((LiteralContext)_localctx).BOOLEAN.getText():null)))); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				((LiteralContext)_localctx).STRING = match(STRING);
				 ((LiteralContext)_localctx).result =  addCodeReference(_localctx, new StringLiteral(String.valueOf(((LiteralContext)_localctx).STRING.getText()))); 
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				((LiteralContext)_localctx).DECIMAL = match(DECIMAL);
				 ((LiteralContext)_localctx).result =  addCodeReference(_localctx, new DecimalLiteral(Double.valueOf(((LiteralContext)_localctx).DECIMAL.getText())));
				}
				break;
			case MONEY:
				enterOuterAlt(_localctx, 5);
				{
				setState(37);
				((LiteralContext)_localctx).MONEY = match(MONEY);
				((LiteralContext)_localctx).result =  addCodeReference(_localctx, new MoneyLiteral(BigDecimal(Double.valueOf(((LiteralContext)_localctx).DECIMAL.getText())))); 
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 6);
				{
				setState(39);
				((LiteralContext)_localctx).DATE = match(DATE);
				 ((LiteralContext)_localctx).result =  addCodeReference(_localctx, new DateLiteral(new Date((((LiteralContext)_localctx).DATE.getText().toString())))); 
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

	public static class QuestionTypeContext extends ParserRuleContext {
		public Type result;
		public QuestionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterQuestionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitQuestionType(this);
		}
	}

	public final QuestionTypeContext questionType() throws RecognitionException {
		QuestionTypeContext _localctx = new QuestionTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_questionType);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(T__0);
				 ((QuestionTypeContext)_localctx).result =  addCodeReference(_localctx, new MoneyType());
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(T__1);
				 ((QuestionTypeContext)_localctx).result =  addCodeReference(_localctx, new IntegerType());
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(T__2);
				 ((QuestionTypeContext)_localctx).result =  addCodeReference(_localctx, new BooleanType());
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				match(T__3);
				 ((QuestionTypeContext)_localctx).result =  addCodeReference(_localctx, new StringType());
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				match(T__4);
				 ((QuestionTypeContext)_localctx).result =  addCodeReference(_localctx, new DateType());
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
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

	public static class StyleContext extends ParserRuleContext {
		public StyleProperty result;
		public Token STRING;
		public Token INTEGER;
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public TerminalNode INTEGER() { return getToken(QLSParser.INTEGER, 0); }
		public StyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_style; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterStyle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitStyle(this);
		}
	}

	public final StyleContext style() throws RecognitionException {
		StyleContext _localctx = new StyleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_style);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(T__6);
				setState(58);
				match(T__7);
				setState(59);
				((StyleContext)_localctx).STRING = match(STRING);
				 ((StyleContext)_localctx).result =  addCodeReference(_localctx, new FontColor(((StyleContext)_localctx).STRING!=null?((StyleContext)_localctx).STRING.getText():null)); 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(T__8);
				setState(62);
				match(T__7);
				setState(63);
				((StyleContext)_localctx).INTEGER = match(INTEGER);
				 ((StyleContext)_localctx).result =  addCodeReference(_localctx, new FontSize(new IntegerLiteral(Integer.valueOf((((StyleContext)_localctx).INTEGER!=null?((StyleContext)_localctx).INTEGER.getText():null))))); 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				match(T__9);
				setState(66);
				match(T__7);
				setState(67);
				((StyleContext)_localctx).STRING = match(STRING);
				 ((StyleContext)_localctx).result =  addCodeReference(_localctx, new FontName(new StringLiteral((((StyleContext)_localctx).STRING!=null?((StyleContext)_localctx).STRING.getText():null))));
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				match(T__10);
				setState(70);
				match(T__7);
				setState(71);
				((StyleContext)_localctx).INTEGER = match(INTEGER);
				 ((StyleContext)_localctx).result =  addCodeReference(_localctx, new Width(new IntegerLiteral(Integer.valueOf((((StyleContext)_localctx).INTEGER!=null?((StyleContext)_localctx).INTEGER.getText():null))))); 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				match(T__11);
				setState(74);
				match(T__7);
				setState(75);
				((StyleContext)_localctx).INTEGER = match(INTEGER);
				 ((StyleContext)_localctx).result =  addCodeReference(_localctx, new Height(new IntegerLiteral(Integer.valueOf((((StyleContext)_localctx).INTEGER!=null?((StyleContext)_localctx).INTEGER.getText():null))))); 
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

	public static class StylesContext extends ParserRuleContext {
		public List<StyleProperty> result;
		public StyleContext style;
		public List<StyleContext> style() {
			return getRuleContexts(StyleContext.class);
		}
		public StyleContext style(int i) {
			return getRuleContext(StyleContext.class,i);
		}
		public StylesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styles; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterStyles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitStyles(this);
		}
	}

	public final StylesContext styles() throws RecognitionException {
		StylesContext _localctx = new StylesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_styles);
		((StylesContext)_localctx).result =  new ArrayList<>();
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(79);
					((StylesContext)_localctx).style = style();
					_localctx.result.add(((StylesContext)_localctx).style.result);
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
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

	public static class WidgetTypeContext extends ParserRuleContext {
		public AstWidget result;
		public WidgetOptionsContext widgetOptions;
		public Token STRING;
		public WidgetOptionsContext widgetOptions() {
			return getRuleContext(WidgetOptionsContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public WidgetTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widgetType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterWidgetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitWidgetType(this);
		}
	}

	public final WidgetTypeContext widgetType() throws RecognitionException {
		WidgetTypeContext _localctx = new WidgetTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_widgetType);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(T__12);
				 ((WidgetTypeContext)_localctx).result =  addCodeReference(_localctx, new AstTextField()); 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(T__13);
				setState(90);
				match(T__14);
				setState(91);
				((WidgetTypeContext)_localctx).widgetOptions = widgetOptions();
				setState(92);
				match(T__15);
				setState(93);
				match(T__16);
				setState(94);
				((WidgetTypeContext)_localctx).STRING = match(STRING);
				 ((WidgetTypeContext)_localctx).result =  addCodeReference(_localctx, new AstCheckBox(((WidgetTypeContext)_localctx).widgetOptions.result, (((WidgetTypeContext)_localctx).STRING!=null?((WidgetTypeContext)_localctx).STRING.getText():null))); 
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(T__17);
				setState(98);
				match(T__14);
				setState(99);
				((WidgetTypeContext)_localctx).widgetOptions = widgetOptions();
				setState(100);
				match(T__15);
				setState(101);
				match(T__16);
				setState(102);
				((WidgetTypeContext)_localctx).STRING = match(STRING);
				 ((WidgetTypeContext)_localctx).result =  addCodeReference(_localctx, new AstRadioBtn(((WidgetTypeContext)_localctx).widgetOptions.result, (((WidgetTypeContext)_localctx).STRING!=null?((WidgetTypeContext)_localctx).STRING.getText():null))); 
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				match(T__18);
				setState(106);
				match(T__14);
				setState(107);
				((WidgetTypeContext)_localctx).widgetOptions = widgetOptions();
				setState(108);
				match(T__15);
				setState(109);
				match(T__16);
				setState(110);
				((WidgetTypeContext)_localctx).STRING = match(STRING);
				 ((WidgetTypeContext)_localctx).result =  addCodeReference(_localctx, new AstDropDown(((WidgetTypeContext)_localctx).widgetOptions.result, (((WidgetTypeContext)_localctx).STRING!=null?((WidgetTypeContext)_localctx).STRING.getText():null))); 
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				match(T__19);
				setState(114);
				match(T__14);
				setState(115);
				((WidgetTypeContext)_localctx).widgetOptions = widgetOptions();
				setState(116);
				match(T__15);
				setState(117);
				match(T__16);
				setState(118);
				((WidgetTypeContext)_localctx).STRING = match(STRING);
				 ((WidgetTypeContext)_localctx).result =  addCodeReference(_localctx, new AstSlider(((WidgetTypeContext)_localctx).widgetOptions.result, (((WidgetTypeContext)_localctx).STRING!=null?((WidgetTypeContext)_localctx).STRING.getText():null))); 
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 6);
				{
				setState(121);
				match(T__20);
				setState(122);
				match(T__14);
				setState(123);
				((WidgetTypeContext)_localctx).widgetOptions = widgetOptions();
				setState(124);
				match(T__15);
				setState(125);
				match(T__16);
				setState(126);
				((WidgetTypeContext)_localctx).STRING = match(STRING);
				 ((WidgetTypeContext)_localctx).result =  addCodeReference(_localctx, new AstSpinbox(((WidgetTypeContext)_localctx).widgetOptions.result, (((WidgetTypeContext)_localctx).STRING!=null?((WidgetTypeContext)_localctx).STRING.getText():null))); 
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
		public Item result;
		public AstWidget widget;
		List<StyleProperty> props = new ArrayList<>();
		public IdentifierContext identifier;
		public WidgetTypeContext widgetType;
		public StylesContext styles;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public WidgetTypeContext widgetType() {
			return getRuleContext(WidgetTypeContext.class,0);
		}
		public StylesContext styles() {
			return getRuleContext(StylesContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(131);
				match(T__21);
				}
				}
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__21 );
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(136);
				((QuestionContext)_localctx).identifier = identifier();
				}
				}
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(141);
				match(T__22);
				setState(142);
				((QuestionContext)_localctx).widgetType = widgetType();
				_localctx.widget=((QuestionContext)_localctx).widgetType.result; 
				}
			}

			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(147);
				match(T__23);
				setState(148);
				((QuestionContext)_localctx).styles = styles();
				_localctx.props.addAll(((QuestionContext)_localctx).styles.result); 
				setState(150);
				match(T__24);
				}
			}

				((QuestionContext)_localctx).result =  addCodeReference(_localctx, new QuestionItem(((QuestionContext)_localctx).identifier.result.toString(), _localctx.widget, _localctx.props));
			    
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

	public static class DefaultTypeContext extends ParserRuleContext {
		public TypeItem result;
		public AstWidget widget = null;;
		public QuestionTypeContext questionType;
		public StylesContext st;
		public WidgetTypeContext widgetType;
		public QuestionTypeContext questionType() {
			return getRuleContext(QuestionTypeContext.class,0);
		}
		public List<StylesContext> styles() {
			return getRuleContexts(StylesContext.class);
		}
		public StylesContext styles(int i) {
			return getRuleContext(StylesContext.class,i);
		}
		public WidgetTypeContext widgetType() {
			return getRuleContext(WidgetTypeContext.class,0);
		}
		public DefaultTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterDefaultType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitDefaultType(this);
		}
	}

	public final DefaultTypeContext defaultType() throws RecognitionException {
		DefaultTypeContext _localctx = new DefaultTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_defaultType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__16);
			setState(157);
			((DefaultTypeContext)_localctx).questionType = questionType();
			setState(158);
			match(T__23);
			setState(159);
			((DefaultTypeContext)_localctx).st = styles();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(160);
				match(T__22);
				setState(161);
				((DefaultTypeContext)_localctx).widgetType = widgetType();
				((DefaultTypeContext)_localctx).widget = ((DefaultTypeContext)_localctx).widgetType.result;
				}
			}

			setState(166);
			styles();
			setState(167);
			match(T__24);

					((DefaultTypeContext)_localctx).result =  addCodeReference(_localctx, new TypeItem(_localctx.widget, ((DefaultTypeContext)_localctx).questionType.result, ((DefaultTypeContext)_localctx).st.result));
			    
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

	public static class ItemContext extends ParserRuleContext {
		public Item result;
		public QuestionContext question;
		public DefaultTypeContext defaultType;
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public DefaultTypeContext defaultType() {
			return getRuleContext(DefaultTypeContext.class,0);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitItem(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_item);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				((ItemContext)_localctx).question = question();
				((ItemContext)_localctx).result =  ((ItemContext)_localctx).question.result;
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				((ItemContext)_localctx).defaultType = defaultType();
				((ItemContext)_localctx).result =  ((ItemContext)_localctx).defaultType.result;
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

	public static class WidgetOptionsContext extends ParserRuleContext {
		public List<String> result;
		public Token opt1;
		public Token opt2;
		public List<TerminalNode> STRING() { return getTokens(QLSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLSParser.STRING, i);
		}
		public WidgetOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widgetOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterWidgetOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitWidgetOptions(this);
		}
	}

	public final WidgetOptionsContext widgetOptions() throws RecognitionException {
		WidgetOptionsContext _localctx = new WidgetOptionsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_widgetOptions);
		((WidgetOptionsContext)_localctx).result =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			((WidgetOptionsContext)_localctx).opt1 = match(STRING);
			 _localctx.result.add((((WidgetOptionsContext)_localctx).opt1!=null?((WidgetOptionsContext)_localctx).opt1.getText():null)); 
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25) {
				{
				{
				setState(180);
				match(T__25);
				setState(181);
				((WidgetOptionsContext)_localctx).opt2 = match(STRING);
				 _localctx.result.add((((WidgetOptionsContext)_localctx).opt2!=null?((WidgetOptionsContext)_localctx).opt2.getText():null));
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class SectionContext extends ParserRuleContext {
		public Section result;
		public String name;
		      		List<Item> items = new ArrayList<>();;
		public Token STRING;
		public ItemContext item;
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitSection(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__26);
			setState(189);
			((SectionContext)_localctx).STRING = match(STRING);
			 _localctx.name=(((SectionContext)_localctx).STRING!=null?((SectionContext)_localctx).STRING.getText():null); 
			setState(191);
			match(T__23);
			setState(195); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(192);
				((SectionContext)_localctx).item = item();
				 _localctx.items.add(((SectionContext)_localctx).item.result); 
				}
				}
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__16 || _la==T__21 );
			setState(199);
			match(T__24);
			}
			_ctx.stop = _input.LT(-1);

			        ((SectionContext)_localctx).result =  addCodeReference(_localctx, new Section(_localctx.name, _localctx.items));
			    
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

	public static class PageContext extends ParserRuleContext {
		public Page result;
		public String name;
		List<Section> sections = new ArrayList<>();
		public IdentifierContext identifier;
		public SectionContext section;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public PageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_page; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterPage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitPage(this);
		}
	}

	public final PageContext page() throws RecognitionException {
		PageContext _localctx = new PageContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_page);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__27);
			setState(202);
			((PageContext)_localctx).identifier = identifier();
			 _localctx.name = ((PageContext)_localctx).identifier.result.toString(); 
			setState(204);
			match(T__23);
			setState(208); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(205);
				((PageContext)_localctx).section = section();
				 _localctx.sections.add(((PageContext)_localctx).section.result); 
				}
				}
				setState(210); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__26 );
			setState(212);
			match(T__24);
			}
			_ctx.stop = _input.LT(-1);

			        ((PageContext)_localctx).result =  addCodeReference(_localctx, new Page(_localctx.name, _localctx.sections));
			    
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

	public static class StylesheetContext extends ParserRuleContext {
		public StyleSheet result;
		public String id;
					List<Page> pages = new ArrayList<>();;
		public IdentifierContext identifier;
		public PageContext page;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<PageContext> page() {
			return getRuleContexts(PageContext.class);
		}
		public PageContext page(int i) {
			return getRuleContext(PageContext.class,i);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitStylesheet(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_la = _input.LA(1);
			if ( !(_la==T__28 || _la==T__29) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(215);
			((StylesheetContext)_localctx).identifier = identifier();
			 _localctx.id = ((StylesheetContext)_localctx).identifier.result.toString();
			setState(217);
			match(T__23);
			setState(221); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(218);
				((StylesheetContext)_localctx).page = page();
				_localctx.pages.add(((StylesheetContext)_localctx).page.result);
				}
				}
				setState(223); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__27 );
			setState(225);
			match(T__24);
			}
			_ctx.stop = _input.LT(-1);

			        ((StylesheetContext)_localctx).result =  addCodeReference(_localctx, new StyleSheet(_localctx.id, _localctx.pages));
			    
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u00e6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5P\n\5\3\6\3\6\3\6\7\6U\n\6\f\6\16\6X\13"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0084\n\7\3\b\6\b\u0087\n\b\r\b\16"+
		"\b\u0088\3\b\6\b\u008c\n\b\r\b\16\b\u008d\3\b\3\b\3\b\3\b\5\b\u0094\n"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b\u009b\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\t\u00a7\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b3"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\7\13\u00ba\n\13\f\13\16\13\u00bd\13\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00c6\n\f\r\f\16\f\u00c7\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\6\r\u00d3\n\r\r\r\16\r\u00d4\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\6\16\u00e0\n\16\r\16\16\16\u00e1\3\16\3\16\3"+
		"\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\3\3\2\37 \2\u00f6\2\34\3"+
		"\2\2\2\4+\3\2\2\2\69\3\2\2\2\bO\3\2\2\2\nV\3\2\2\2\f\u0083\3\2\2\2\16"+
		"\u0086\3\2\2\2\20\u009e\3\2\2\2\22\u00b2\3\2\2\2\24\u00b4\3\2\2\2\26\u00be"+
		"\3\2\2\2\30\u00cb\3\2\2\2\32\u00d8\3\2\2\2\34\35\7$\2\2\35\36\b\2\1\2"+
		"\36\3\3\2\2\2\37 \7&\2\2 ,\b\3\1\2!\"\7(\2\2\",\b\3\1\2#$\7\'\2\2$,\b"+
		"\3\1\2%&\7,\2\2&,\b\3\1\2\'(\7+\2\2(,\b\3\1\2)*\7-\2\2*,\b\3\1\2+\37\3"+
		"\2\2\2+!\3\2\2\2+#\3\2\2\2+%\3\2\2\2+\'\3\2\2\2+)\3\2\2\2,\5\3\2\2\2-"+
		".\7\3\2\2.:\b\4\1\2/\60\7\4\2\2\60:\b\4\1\2\61\62\7\5\2\2\62:\b\4\1\2"+
		"\63\64\7\6\2\2\64:\b\4\1\2\65\66\7\7\2\2\66:\b\4\1\2\678\7\b\2\28:\b\4"+
		"\1\29-\3\2\2\29/\3\2\2\29\61\3\2\2\29\63\3\2\2\29\65\3\2\2\29\67\3\2\2"+
		"\2:\7\3\2\2\2;<\7\t\2\2<=\7\n\2\2=>\7\'\2\2>P\b\5\1\2?@\7\13\2\2@A\7\n"+
		"\2\2AB\7&\2\2BP\b\5\1\2CD\7\f\2\2DE\7\n\2\2EF\7\'\2\2FP\b\5\1\2GH\7\r"+
		"\2\2HI\7\n\2\2IJ\7&\2\2JP\b\5\1\2KL\7\16\2\2LM\7\n\2\2MN\7&\2\2NP\b\5"+
		"\1\2O;\3\2\2\2O?\3\2\2\2OC\3\2\2\2OG\3\2\2\2OK\3\2\2\2P\t\3\2\2\2QR\5"+
		"\b\5\2RS\b\6\1\2SU\3\2\2\2TQ\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\13"+
		"\3\2\2\2XV\3\2\2\2YZ\7\17\2\2Z\u0084\b\7\1\2[\\\7\20\2\2\\]\7\21\2\2]"+
		"^\5\24\13\2^_\7\22\2\2_`\7\23\2\2`a\7\'\2\2ab\b\7\1\2b\u0084\3\2\2\2c"+
		"d\7\24\2\2de\7\21\2\2ef\5\24\13\2fg\7\22\2\2gh\7\23\2\2hi\7\'\2\2ij\b"+
		"\7\1\2j\u0084\3\2\2\2kl\7\25\2\2lm\7\21\2\2mn\5\24\13\2no\7\22\2\2op\7"+
		"\23\2\2pq\7\'\2\2qr\b\7\1\2r\u0084\3\2\2\2st\7\26\2\2tu\7\21\2\2uv\5\24"+
		"\13\2vw\7\22\2\2wx\7\23\2\2xy\7\'\2\2yz\b\7\1\2z\u0084\3\2\2\2{|\7\27"+
		"\2\2|}\7\21\2\2}~\5\24\13\2~\177\7\22\2\2\177\u0080\7\23\2\2\u0080\u0081"+
		"\7\'\2\2\u0081\u0082\b\7\1\2\u0082\u0084\3\2\2\2\u0083Y\3\2\2\2\u0083"+
		"[\3\2\2\2\u0083c\3\2\2\2\u0083k\3\2\2\2\u0083s\3\2\2\2\u0083{\3\2\2\2"+
		"\u0084\r\3\2\2\2\u0085\u0087\7\30\2\2\u0086\u0085\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a"+
		"\u008c\7$\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u0093\3\2\2\2\u008f\u0090\7\31\2\2\u0090"+
		"\u0091\5\f\7\2\u0091\u0092\b\b\1\2\u0092\u0094\3\2\2\2\u0093\u008f\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u009a\3\2\2\2\u0095\u0096\7\32\2\2\u0096"+
		"\u0097\5\n\6\2\u0097\u0098\b\b\1\2\u0098\u0099\7\33\2\2\u0099\u009b\3"+
		"\2\2\2\u009a\u0095\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009d\b\b\1\2\u009d\17\3\2\2\2\u009e\u009f\7\23\2\2\u009f\u00a0\5\6\4"+
		"\2\u00a0\u00a1\7\32\2\2\u00a1\u00a6\5\n\6\2\u00a2\u00a3\7\31\2\2\u00a3"+
		"\u00a4\5\f\7\2\u00a4\u00a5\b\t\1\2\u00a5\u00a7\3\2\2\2\u00a6\u00a2\3\2"+
		"\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\5\n\6\2\u00a9"+
		"\u00aa\7\33\2\2\u00aa\u00ab\b\t\1\2\u00ab\21\3\2\2\2\u00ac\u00ad\5\16"+
		"\b\2\u00ad\u00ae\b\n\1\2\u00ae\u00b3\3\2\2\2\u00af\u00b0\5\20\t\2\u00b0"+
		"\u00b1\b\n\1\2\u00b1\u00b3\3\2\2\2\u00b2\u00ac\3\2\2\2\u00b2\u00af\3\2"+
		"\2\2\u00b3\23\3\2\2\2\u00b4\u00b5\7\'\2\2\u00b5\u00bb\b\13\1\2\u00b6\u00b7"+
		"\7\34\2\2\u00b7\u00b8\7\'\2\2\u00b8\u00ba\b\13\1\2\u00b9\u00b6\3\2\2\2"+
		"\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\25"+
		"\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7\35\2\2\u00bf\u00c0\7\'\2\2"+
		"\u00c0\u00c1\b\f\1\2\u00c1\u00c5\7\32\2\2\u00c2\u00c3\5\22\n\2\u00c3\u00c4"+
		"\b\f\1\2\u00c4\u00c6\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7\33"+
		"\2\2\u00ca\27\3\2\2\2\u00cb\u00cc\7\36\2\2\u00cc\u00cd\5\2\2\2\u00cd\u00ce"+
		"\b\r\1\2\u00ce\u00d2\7\32\2\2\u00cf\u00d0\5\26\f\2\u00d0\u00d1\b\r\1\2"+
		"\u00d1\u00d3\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\7\33\2\2"+
		"\u00d7\31\3\2\2\2\u00d8\u00d9\t\2\2\2\u00d9\u00da\5\2\2\2\u00da\u00db"+
		"\b\16\1\2\u00db\u00df\7\32\2\2\u00dc\u00dd\5\30\r\2\u00dd\u00de\b\16\1"+
		"\2\u00de\u00e0\3\2\2\2\u00df\u00dc\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df"+
		"\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7\33\2\2"+
		"\u00e4\33\3\2\2\2\21+9OV\u0083\u0088\u008d\u0093\u009a\u00a6\u00b2\u00bb"+
		"\u00c7\u00d4\u00e1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}