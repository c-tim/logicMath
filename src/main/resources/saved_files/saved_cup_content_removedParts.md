


## used
|                           AXIOM:a identificator:b DOUBLEDOTS expression:c
{:      RESULT = Proposition.create(true, b, c);
        RESULT.setLocations(axleft, cxright); :}
|                           PROPOSITION:a identificator:b DOUBLEDOTS expression:c
{:      RESULT = Proposition.create(false, b, c);
        RESULT.setLocations(axleft, cxright); :}

expression ::=       FORALL:a liste_variables:b
|                liste_variables EXISTS
;


## unused
|                           PROPOSITION:a identificator:b DOUBLEDOTS expression:c LBRACK proof RBRACK:z
{:      RESULT = Proposition.create(false, b, c);
        RESULT.setLocations(axleft, zxright); :}


{:

//argument_predicat:a
{:     /* RESULT = ListVariables.create(a);
RESULT.setLocations(axleft, axright);*/:}
//|                               argument_predicat:a COMMA liste_argument_predicat:b
{:/*
RESULT.setLocations(axleft, bxright);*/ :}
//;

:}


#### crisis on pointer in expr or not
liste_argument_predicat   ::=  list_pointers_predicat COMMA liste_expressions
;


list_pointers_predicat ::=  pointer_predicat
|                          list_pointers_predicat  COMMA pointer_predicat
;

|                   pointer_predicat:a
{:      RESULT = a;
RESULT.setLocations(axleft, axright); :}
