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

CRLF= \n|\r|\r\n
WHITE_SPACE=[\ \t\f]
FIRST_VALUE_CHARACTER=[^ \n\r\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\r\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\r\t\f\\] | "\\"{CRLF} | "\\".
WHITE_SPACE_CHAR=[\ \n\r\t\f]
MODIFIER="!"|"*"

%x cond_string
%x cond_include
%x cond_use

D=[0-9]
E=[Ee][+-]?{D}+

%%

\/\/[^\n]*\n? |
"/*"~"*/" {return OscadTypes.COMMENT;}

"include" |
"use"       {yybegin(cond_include); return OscadTypes.IMPORT; }
<cond_include> {
{WHITE_SPACE_CHAR}+  {}
    "<"         { return OscadTypes.LEFT_ANGLE; }
    [^\n><]*     { return OscadTypes.FILENAME; }
    ">"         { yybegin(YYINITIAL); return OscadTypes.RIGHT_ANGLE; }
}

{WHITE_SPACE_CHAR}+  {return TokenType.WHITE_SPACE;}
<YYINITIAL> \"	{ yybegin(cond_string); }
<cond_string> {
    \\n		|
    \\t		|
    \\r		|
    \\\\	|
    \\\"	|
    [^\\\n\"]+		{  }
    \"			{ yybegin(YYINITIAL);
                return OscadTypes.STRING; }
}

<YYINITIAL> {

"module"	{return OscadTypes.MODULE;}
"function"	{return OscadTypes.FUNCTION;}
"if"		{return OscadTypes.IF;}
"for"       {return OscadTypes.FOR;}
"assign"    {return OscadTypes.ASSIGN;}
"else"		{return OscadTypes.ELSE;}

"scale"     |
"rotate"    |
"translate" |
"color"     {return OscadTypes.TRANSFORM_KEY;}

"difference" |
intersection |
union       {return OscadTypes.CSG; }

[-+]?{D}+{E}? |
[-+]?{D}*\.{D}+{E}? |
[-+]?{D}+\.{D}*{E}?          {  return OscadTypes.NUMBER; }

"$"?[a-zA-Z0-9_]+       {  return OscadTypes.ID; }

"("     { return OscadTypes.LEFT_PAREN; }
")"     { return OscadTypes.RIGHT_PAREN; }
"{"     { return OscadTypes.LEFT_BRACE; }
"}"     { return OscadTypes.RIGHT_BRACE; }
"["     { return OscadTypes.LEFT_SQUARE; }
"]"     { return OscadTypes.RIGHT_SQUARE; }

"="     { return OscadTypes.EQUALS; }

"<="	|
">="	|
"=="	|
"!="	|
"&&"	|
"||"	{return OscadTypes.COMPARATOR; }

";"     { return OscadTypes.SEMICOLON; }
":"     { return OscadTypes.COLON; }
","     { return OscadTypes.COMMA; }
"*"     {return OscadTypes.STAR; }
"/"     {return OscadTypes.SLASH; }
"+"     {return OscadTypes.PLUS; }
"-"     {return OscadTypes.MINUS; }


"!" {return OscadTypes.MODIFIER;}
}
 . { return  TokenType.BAD_CHARACTER;}
