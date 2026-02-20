package compilation_steps.AST;

import java.util.List;

/* This is a predicat*/
public class Definition extends Predicat {



    Ident typeIs;
    public Ident getTypeIs() {
        return typeIs;
    }

    public Definition(Ident _definitionId, ListArgPredicat l, Expression _expression, Ident _typeIs) {
        super(Definition.class.toString(),_definitionId,  l,  _expression);

        typeIs = _typeIs;
        if(typeIs!=null){
        addChild(typeIs);}
    }

    /*public ASTList<ExprVariable> turnExprToVar(ListArgPredicat e){
        return  e.getExternalVariable();
    }*/

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public static Definition create(Ident _definitionId, ListArgPredicat _var, Expression _expression){
        return new Definition(_definitionId, _var,_expression,null);
    }

    //variante of definition using "is" statement, example : x is prime
    public static Definition createWithIs(Ident _definitionId, ListArgPredicat _var, Expression _expression, Ident typeIs){
        return new Definition(_definitionId, _var,_expression, typeIs);
    }

        @Override
        public String toString(){
           /* if (args == null) {
                return "Definition :"+expression.toString();

            }
*/
         /*   String vars_s = "";
            for (int i = 0; i < list_var_in_pointers.size(); i++) {
                vars_s += list_var_in_pointers.get(i).toString()+",";
            }


            return "Definition (vars :"+vars_s+"):"+expression.toString();*/
            if (typeIs != null){
                return "Is_Definition";
            }
            return "Definition "+ getPredicatid();
        }

}
