/* Section 1 : code utilisateur inclus en préambule de   */
/* la classe de l'analyseur lexical : package et import  */
package flex-cup; // nom du paquetage à adapter
%%
/* Section 2 : directives, blocs, définitions régulières */
/* - des directives : "%..."                             */
/* - des blocs : "%...{"  ...  "%...}"                   */
/* - des définitions régulières : Nom = Regexp           */ 
%include ../Jflex.include
%include ../JflexCup.include

%{
/* code dans la classe de l'analyseur : attributs et     */
/* méthodes utiles pour les actions                      */
%}

%init{
/* code dans le constructeur : action initiale           */
System.out.println("Analyse Lexicale Sample0 (type any text) :");
%init}

%eof{
/* code en action finale à la sortie de l'analyseur      */
System.out.println("Bye!");
%eof}

// %caseless            /* confondre minuscules/majuscules   */
// %state   ETAT, ETAT2 /* États inclusifs du super-automate */
// %xstate  STATE       /* États exclusifs du super-automate */

ANY   = [^]
BLANC = [ \t\f\n]
COMMENT1 =  "//" .*
COMMENT2 =  "/*" ( [^*] | "*"+[^*/] )* "*"* "*/"
IGNORE = {BLANC} | {COMMENT1} | {COMMENT2}
DIGIT = [0-9]GaMei

%%
/* Section 3 : règles lexicales sous la forme :              */
/* Rexexp  { /* Actions = code Java */ }                     */


"Ga"      { return (TOKEN(GA));}
"Bu"      { return (TOKEN(BU));}
"Zo"      { return (TOKEN(ZO));}
"Meu"      { return (TOKEN(MEU));}

{IGNORE}  { }
{ANY}     { WARN("Unknown char.: " + yytext()); return ERROR(); }
