package compilation_steps.syntax;
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

%%
/* Section 3 : règles lexicales sous la forme :              */
/* Rexexp  {  Actions = code Java                     */

//Token words
"Theory"     { return (TOKEN(THEORY));}
"Theorem"     { return (TOKEN(THEOREM));}
"Proposition"     { return (TOKEN(PROPOSITION));}

"{"     { return (TOKEN(LBRACK));}
"}"     { return (TOKEN(RBRACK));}





{IGNORE}  { }
{ANY}     { WARN("Unknown char.: " + yytext()); return TOKEN(ERROR); }


