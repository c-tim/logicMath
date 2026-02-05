package compilation_steps;
%%
%include Jflex.include
%include JflexCup.include


ANY   = [^]
BLANC = [ \t\f\n]
COMMENT1 =  "//" .*
COMMENT2 =  "/*" ( [^*] | "*"+[^*/] )* "*"* "*/"
IGNORE = {BLANC} | {COMMENT1} | {COMMENT2}
DIGIT = [0-9]
NUMBER = [1-9] DIGIT*
IDENTIFIER = [a-zA-Z]*

%%
/* Section 3 : règles lexicales sous la forme :              */
/* Rexexp  {  Actions = code Java                     */

//Token words
"Theory"     { return (TOKEN(THEORY));}
"Theorem"     { return (TOKEN(THEOREM));}
"Proposition"     { return (TOKEN(PROPOSITION));}   
"Axiom"         {return (TOKEN(AXIOM));}
"Definition"         {return (TOKEN(DEFINITION));}

"let"         {return (TOKEN(LET));}
"forall"         {return (TOKEN(FORALL));}
"in"         {return (TOKEN(IN));}
"exists"         {return (TOKEN(EXISTS));}
"unique"         {return (TOKEN(UNIQUE));}


//default objects
"Set"     { return (TOKEN(SET));}


"Null"     { return (TOKEN(NULL));}

"and"     { return (TOKEN(AND));}
"or"     { return (TOKEN(OR));}

"non"     { return (TOKEN(NON));}
"is"     { return (TOKEN(IS));}






"{"     { return (TOKEN(LBRACK));}
"}"     { return (TOKEN(RBRACK));}
"("     { return (TOKEN(LPAR));}
")"     { return (TOKEN(RPAR));}
":"     { return (TOKEN(DOUBLEDOTS));}
";"     { return (TOKEN(SEMICOLON));}
"="     { return (TOKEN(EQUAL));}
">"     { return (TOKEN(GREATER));}
"<=>"     { return (TOKEN(EQUIVALENT));}
"=>"     { return (TOKEN(IMPLIES));}
"->"     { return (TOKEN(ARROWRIGHT));}
"->"     { return (TOKEN(ARROWRIGHT));}
","     { return (TOKEN(COMMA));}






{IDENTIFIER}   { return TOKEN(IDENT,    new String(yytext()));}

{IGNORE}  { }
{ANY}     { WARN("Unknown char.: " + yytext()); return TOKEN(error); }


