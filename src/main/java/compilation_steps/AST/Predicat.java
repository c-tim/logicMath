package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.forName;

// Definition and Proposition, and maybe others later
public class Predicat extends Expression{


    Ident Predicatid;
    List<ArgExpression> list_expressions_linked_to_objects;
    List<ExprVariable> list_var_in_pointers;
    Expression expression;

    /*Getters*/
    public List<ArgExpression> getList_expressions_linked_to_objects() {
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

    public Ident getPredicatid() {
        return Predicatid;
    }





    public Predicat(Ident _predicatId, ListArgPredicat l, Expression _expression)  {
        Predicatid = _predicatId;
        expression = _expression;
        list_expressions_linked_to_objects = new ArrayList<>();
        list_var_in_pointers = new ArrayList<>();
        if (l!=null) {
            list_expressions_linked_to_objects = l.list_expression_pointers;
            for (ArgVar vph : l.list_object_pointers) {
                list_var_in_pointers.addAll(vph.liste_variable);

            }
        }

    }

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }
}
