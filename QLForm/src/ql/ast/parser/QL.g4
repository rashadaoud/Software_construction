grammar QL;
options {  language=Java; }

@parser::header
{
	package antlr.grammar;
	import antlr.grammar.*;
}

@lexer::header
{
	package antlr.grammar;
	import antlr.grammar.*;
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
literal returns [Literal result] // atom
   : MONEY { $result = addCodeReference($ctx, new MoneyLiteral(BigDecimal.valueOf($MONEY.text))); }
   | INTEGER { $result =addCodeReference($ctx, new IntegerLiteral(Integer.valueOf($INTEGER.text))); }
   | BOOLEAN { $result = addCodeReference($ctx, new BooleanLiteral(Boolean.valueOf($BOOLEAN.text))); }
   | STRING { $result = addCodeReference($ctx, new StringLiteral(String.valueOf($STRING))); }
   | DATE { $result = addCodeReference($ctx, new DateLiteral(Date.valueOf($DATE.text))); }
   | DECIMAL { $result = addCodeReference($ctx, new DecimalLiteral(Double.valueOf($DECIMAL.text))); }
  ;

identifier returns [Identifier result]
   : IDENT { $result = addCodeReference($ctx, new Identifier($IDENT.text)); }
  ;
   

questionType returns [Type result]
   : 'money' { $result = addCodeReference($ctx, new MoneyType());}
   | 'integer' { $result = addCodeReference($ctx, new IntegerType());}
   | 'boolean' { $result = addCodeReference($ctx, new BooleanType());}
   | 'string' { $result = addCodeReference($ctx, new StringType());}
   | 'date' { $result = addCodeReference($ctx, new DateType());}
   | 'decimal' { $result = addCodeReference($ctx, new DecimalType());}
  ; 

expr returns [Expression result]
  : identifier { $result = addCodeReference($ctx, new IdentityExpression($identifier.text)); }
  | literal  { $result = addCodeReference($ctx, new LiteralExpression($literal.result)); }
  | '!' expr { $result = addCodeReference($ctx, new Not($expr.result)); }
  | '(' expr ')' { $result = $expr.result; }
  | '+' expr { $result = addCodeReference($ctx, new Pos($expr.result)); }
  | '-' expr { $result = addCodeReference($ctx, new Neg($expr.result)); }
  | left=expr ('&&') right=expr {$result =  addCodeReference($ctx, new And($left.result, $right.result));}
  | left=expr ('||') right=expr {$result =  addCodeReference($ctx, new Or($left.result, $right.result));}
  | left=expr ('==') right=expr {$result =  addCodeReference($ctx, new Eq($left.result, $right.result));}
  | left=expr ('!=') right=expr {$result =  addCodeReference($ctx, new NEq($left.result, $right.result));}
  | left=expr ('*') right=expr {$result =  addCodeReference($ctx, new Mul($left.result, $right.result));}
  | left=expr (|'/') right=expr {$result =  addCodeReference($ctx, new Div($left.result, $right.result));}
  | left=expr ('+') right=expr {$result =  addCodeReference($ctx, new Add($left.result, $right.result));}
  | left=expr ('-') right=expr {$result =  addCodeReference($ctx, new Sub($left.result, $right.result));}
  | left=expr ('>') right=expr {$result =  addCodeReference($ctx, new GT($left.result, $right.result));}
  | left=expr ('>=') right=expr {$result =  addCodeReference($ctx, new GEq($left.result, $right.result));}
  | left=expr ('<') right=expr {$result =  addCodeReference($ctx, new LT($left.result, $right.result));}
  | left=expr ('<=') right=expr {$result =  addCodeReference($ctx, new LEq($left.result, $right.result));}
 ;

statement returns [Statement result]
  : question { $result= addCodeReference($ctx, $question.result); }
  | ifElseStatement { $result= addCodeReference($ctx, $ifElseStatement.result); }
 ;

question  returns [Question result]
  : identifier ':' STRING questionType  // question to be answered
    {$result = addCodeReference($ctx, new AnswerableQuestion($identifier.result, $STRING.text, $questionType.result));}
  | identifier ':' STRING questionType '(' expr ')' // question to be computed
    {$result = addCodeReference($ctx, new ComputedQuestion($identifier.result, $STRING.text, $questionType.result, $expr.result));}
 ;
  
ifElseStatement returns [Statement result]//if or if-else-statement
   : 'if' '(' expr ')' ifBody = block 
      { $result = addCodeReference($ctx, new IfThenStatement($expr.result, $ifBody.result));}
   | 'if' '(' expr ')' ifBody = block 'else' elseBody = block 
      { $result = addCodeReference($ctx, new IfThenElseStatement($expr.result, $ifBody.result, $elseBody.result ));}
  ;
 
block  returns [Block result] // block of multiple statements
    locals [List<Statement> statements = new ArrayList<>();]
    @after{ $result = addCodeReference($ctx, new Block(statements));}
    :'{' + (statement { $ctx.statements.addCodeReference($statement.result); })+ '}'
 ;
 

form returns [Form result] // form
   : ('Form'|'form') identifier block { $result = addCodeReference($ctx, new Form($identifier.result, $block.result)); }
  ;

/*^^^^^^^^^^^^^^^^^^^^^^^^*
	Lexer Rules - Tokens
*^^^^^^^^^^^^^^^^^^^^^^^^*/   
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
