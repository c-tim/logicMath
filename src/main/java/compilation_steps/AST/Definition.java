package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

/* This is a predicat*/
public class Definition extends ASTNode {

    public Ident getDefinitionId() {
        return definitionId;
    }

    public Ident getTypeIs() {
        return typeIs;
    }

    Ident definitionId, typeIs;

    /*public List<ExprVariable> getArgs() {
        return args;
    }*/

    //List<ExprVariable> args;

    public List<ExpressionPointer> getList_expressions_linked_to_objects() {
        return list_expressions_linked_to_objects;
    }

    public List<ExprVariable> getList_var_in_pointers() {
        return list_var_in_pointers;
    }

    public ExprVariable getVar(int i){
        return list_var_in_pointers.get(i);
    }

    public Expression getExpression() {
        return expression;
    }

    List<ExpressionPointer> list_expressions_linked_to_objects;
    List<ExprVariable> list_var_in_pointers;

    Expression expression;

    public Definition(Ident _definitionId, ListExprArgPointer l, Expression _expression, Ident _typeIs) {
        super(Definition.class.getName());
        definitionId = _definitionId;
        expression = _expression;
        typeIs = _typeIs;
        list_expressions_linked_to_objects = new ArrayList<>();
        list_var_in_pointers = new ArrayList<>();
        if (l!=null) {
            list_expressions_linked_to_objects = l.list_expression_pointers;
            for (ExprVarPlaceHolder vph : l.list_object_pointers) {
                list_var_in_pointers.addAll(vph.liste_variable);

            }
        }
        /*if (vars != null){
            args=turnExprToVar(vars);

        }else {
            args = null;
        }*/
    }

    public List<ExprVariable> turnExprToVar(ListExprArgPointer e){
        return  e.getExternalVariable();
    }


    /*public Proposition turnToProposition(final boolean isAxiom){
        if(expression == null){
             return new Proposition(isAxiom, definitionId);

        }
        ExprList list = new ExprList(expression);
        list.addExpressionToListToStart(new ExprForall(args));
        Statement s = new StatementExpression(list);
        return new Proposition(isAxiom, definitionId, list);
    }*/

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public static Definition create(Ident _definitionId, ListExprArgPointer _var, Expression _expression){
        return new Definition(_definitionId, _var,_expression,null);
    }

    //variante of definition using "is" statement, example : x is prime
    public static Definition createWithIs(Ident _definitionId, ListExprArgPointer _var, Expression _expression, Ident typeIs){
        return new Definition(_definitionId, _var,_expression, typeIs);
    }

        @Override
        public String toString(){
           /* if (args == null) {
                return "Definition :"+expression.toString();

            }
*/
            String vars_s = "";
                for (ExprVariable v : list_var_in_pointers){
                    vars_s += v.toString()+",";
                }


            return "Definition (vars :"+vars_s+"):"+expression.toString();
        }

}
