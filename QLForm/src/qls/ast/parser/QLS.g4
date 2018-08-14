grammar QLS;

@parser::header {
	import java.util.ArrayList;
	import java.util.Map;
	import java.util.HashMap;
	import ql.ast.*;
	import ql.ast.literal.*;
	import ql.ast.type.*;
	import ql.utils.CodeReference;
	import qls.ast.*;
	import qls.ast.style;
	import qls.ast.widget.*;
}

@parser::members {
	private <T extends AstNode> T addCodeReference(ParserRuleContext context, T node){
        node.setLocation(new CodeReference(context));
        return (T) node;
    }
}

/*^^^^^^^^^^^^^^^^^^^^*
	Parser Rules
*^^^^^^^^^^^^^^^^^^^^*/

identifier returns [Identifier result]
	: IDENT { $result = addCodeReference($ctx, new Identifier($IDENT.text));}
   ;
 
literal returns [Literal result] // atom
	: INTEGER { $result =addCodeReference($ctx, new IntegerLiteral(Integer.valueOf($INTEGER.text))); }
	| BOOLEAN { $result = addCodeReference($ctx, new BooleanLiteral(Boolean.valueOf($BOOLEAN.text))); }	
	| STRING { $result = addCodeReference($ctx, new StringLiteral(String.valueOf($STRING.text))); }		
	| DATE { $result = addCodeReference($ctx, new DateLiteral(Date.valueOf($DATE.text))); }
	| MONEY { $result = addCodeReference($ctx, new MoneyLiteral(BigDecimal.valueOf($MONEY.text))); }
	| DECIMAL { $result = addCodeReference($ctx, new DecimalLiteral(Double.valueOf($DECIMAL.text))); }
   ;
  
questionType returns [Type result]
	: 'integer' { $result = addCodeReference($ctx, new IntegerType());}
	| 'boolean' { $result = addCodeReference($ctx, new BooleanType());}
	| 'string' { $result = addCodeReference($ctx, new StringType());}
	| 'date' { $result = addCodeReference($ctx, new DateType());}
	| 'money' { $result = addCodeReference($ctx, new MoneyType());}
	| 'decimal' { $result = addCodeReference($ctx, new DecimalType());}
   ; 

style returns [StyleProperty result]
	: 'width' ':' INTEGER { $result = addCodeReference($ctx, new Width(new IntegerLiteral(Integer.valueOf($INTEGER.text)))); }
    | 'height' ':' INTEGER { $result = addCodeReference($ctx, new Height(new IntegerLiteral(Integer.valueOf($INTEGER.text)))); }
    | 'color' ':' STRING { $result = addCodeReference($ctx, new FontColor($STRING.text)); }
    | 'fontSize' ':' INTEGER { $result = addCodeReference($ctx, new FontSize(new IntegerLiteral(Integer.valueOf($INTEGER.text)))); }
    | 'font' ':' STRING { $result = addCodeReference($ctx, new FontName(new StringLiteral($STRING.text)));}
    ;
    
styles returns [List<StyleProperty> result]
    @init{$result = new ArrayList<>();}
    : (style {$result.add($style.result);})*
    ;


widgetType returns [QLSWidget result]
    : 'text' { $result = addCodeReference($ctx, new AstTextField()); }
    | 'checkbox' '(' widgetOptions ')' 'default' STRING  { $result = addCodeReference($ctx, new AstCheckBox($widgetOptions.result, $STRING.text)); }
    | 'radioBtn' '(' widgetOptions ')' 'default' STRING  { $result = addCodeReference($ctx, new AstRadioBtn($widgetOptions.result, $STRING.text)); }
    | 'dropdown' '(' widgetOptions ')' 'default' STRING  { $result = addCodeReference($ctx, new AstDropDown($widgetOptions.result, $STRING.text)); }
    | 'slider' '(' widgetOptions ')' 'default' STRING    { $result = addCodeReference($ctx, new AstSlider($widgetOptions.result, $STRING.text)); }
    | 'spinbox' '(' widgetOptions ')' 'default' STRING   { $result = addCodeReference($ctx, new AstSpinbox($widgetOptions.result, $STRING.text)); }
   ; 

 
question returns [Item result]
    locals[QLSWidget widget;
        	List<StyleProperty> props = new ArrayList<>();
    		]
    : 'question' + identifier +  ('widget' widgetType {$ctx.widget=$widgetType.result; })?  ('{' styles {$ctx.props.addAll($styles.result); } '}')?
    {
        $result = addCodeReference($ctx, new QuestionItem($identifier.result.toString(), $ctx.widget, $ctx.props));
    }
   ;

    
defaultType returns [TypeItem result]
    locals[Widget widget = null;]
    : 'default' questionType '{' st=styles ('widget' widgetType {$widget=$widgetType.result;})? styles '}' 
    {
		$result = addCodeReference($ctx, new TypeItem($ctx.widget, $questionType.result, $st.result));
    }
   ;
 
   
item returns [Item result]
    : question {$result = $question.result;}
    | defaultType  {$result = $defaultType.result;}
   ;

 
widgetOptions returns [List<String> result] // e.g. "yes", "no"
    @init {$result = new ArrayList<>();}
    : opt1=STRING { $result.add($opt1.text); } (',' opt2=STRING { $result.add($opt2.text);})*
    ;

    
section returns [Section result]
    locals [String name;
      		List<Item> items = new ArrayList<>();
    		]
    @after{
        $result = addCodeReference($ctx, new Section($ctx.name, $ctx.items));
    }
    : 'section' STRING { $ctx.name=$STRING.text; }
		'{'
			( item { $ctx.items.add($item.result); })+ 
		'}'
    ;

page returns [Page result]
    locals [String name;
			List<Section> sections = new ArrayList<>();
    		]
    @after{
        $result = addCodeReference($ctx, new Page($ctx.name, $ctx.sections));
    }
    : 'page' identifier { $ctx.name = $identifier.result.toString(); }
      '{'
			(section { $ctx.sections.add($section.result); } )+ 
	  '}'
	;

  
stylesheet returns [StyleSheet result]
    locals [String id;
			List<Page> pages = new ArrayList<>();
			]
    @after{
        $result = addCodeReference($ctx, new StyleSheet($ctx.id, $ctx.pages));
    }
	: ('Stylesheet'|'stylesheet') identifier { $ctx.id = $identifier.result.toString();}
    '{'
		(page {$ctx.pages.add($page.result);} )+ 
	'}'
    ;

/*^^^^^^^^^^^^^^^^^^^^*
	Lexer Rules
*^^^^^^^^^^^^^^^^^^^^*/
WHITESPACE   : (' ' | '\t' | '\n' | '\r') -> channel(HIDDEN);
SingleComment: '//' ~[\r\n]+ -> channel(HIDDEN);
BlockComment : '/*' .*? '*/' -> channel(HIDDEN);
IDENT        : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
DIGIT        : ('0'..'9');
INTEGER      : DIGIT+;
STRING       : '"' .*? '"';
BOOLEAN      : ('true'|'false');
TwoDigits    : ('0'..'9')('0'..'9');
QuadDigits   : ('0'..'9')('0'..'9')('0'..'9')('0'..'9');
MONEY        : DIGIT+ '.' TwoDigits;
DECIMAL      : DIGIT+ '.' DIGIT+;
DATE	     : TwoDigits'-'TwoDigits'-'QuadDigits;