package com.oscadplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.oscadplugin.psi.OscadTypes;
import com.intellij.psi.TokenType;

%%

%class OscadLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF= \n|\r|\r\n
WHITE_SPACE=[\ \t\f]
FIRST_VALUE_CHARACTER=[^ \n\r\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\r\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\r\t\f\\] | "\\"{CRLF} | "\\".
WHITE_SPACE_CHAR=[\ \n\r\t\f]
MODIFIER="!"|"*"

%x cond_comment
%x cond_string
%x cond_include
%x cond_use

D=[0-9]
E=[Ee][+-]?{D}+

%%

{WHITE_SPACE_CHAR}+  {return TokenType.WHITE_SPACE;}

include[ \t\r\n>]*"<"	{ yybegin(cond_include); }
<cond_include>{
[^\t\r\n>]*"/"	{ }
[^\t\r\n>/]+	{ }
">"		{ yybegin(YYINITIAL); return OscadTypes.INCLUDE; }
}


"use"[ \t\r\n>]*"<"	{ yybegin(cond_use) ; }
<cond_use>{
[^\t\r\n>]+	{ }
 ">"		{ yybegin(YYINITIAL); return OscadTypes.USE; }
}

"module"	{ return OscadTypes.MODULE;}
"function"	{return OscadTypes.FUNCTION;}
"if"		{return OscadTypes.IF;}
"else"		{return OscadTypes.ELSE;}

"true"		{return OscadTypes.TRUE;}
"false"		{return OscadTypes.FALSE;}
"undef"		{return OscadTypes.UNDEF;}

{D}+{E}? |
{D}*\.{D}+{E}? |
{D}+\.{D}*{E}?          {  return OscadTypes.NUMBER; }
"$"?[a-zA-Z0-9_]+       {  return OscadTypes.ID; }

\"			{ yybegin(cond_string); }
<cond_string>{
\\n		|
\\t		|
\\r		|
\\\\	|
\\\"	|
[^\\\n\"]+		{  }
\"			{ yybegin(YYINITIAL);
			return OscadTypes.STRING; }
}

\/\/[^\n]*\n? |
"/*" { yybegin(cond_comment); }
<cond_comment>"*/" {yybegin(YYINITIAL); return OscadTypes.COMMENT;}
<cond_comment>.|\n {}

"="     { return OscadTypes.EQUALS; }

"<="	|
">="	|
"=="	|
"!="	|
"&&"	|
"||"	{return OscadTypes.OPERATOR; }

";"     { return OscadTypes.SEMICOLON; }

YYINITIAL {MODIFIER} {return OscadTypes.MODIFIER;}
YYINITIAL . { return  TokenType.BAD_CHARACTER;}
