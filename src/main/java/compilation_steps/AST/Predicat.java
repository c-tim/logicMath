package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.forName;

// Definition and Proposition, and maybe others later
public class Predicat extends Expression{


    Ident Predicatid;
    ASTList<ArgExpression> list_expressions_linked_to_objects;
    ASTList<ExprVariable> list_var_in_pointers;
    Expression expression;

    /*Getters*/
    public ASTList<ArgExpression> getList_expressions_linked_to_objects() {
        return list_expressions_linked_to_objects;
    }

    public ASTList<ExprVariable> getList_var_in_pointers() {
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





    public Predicat(String className,Ident _predicatId, ListArgPredicat l, Expression _expression)  {
        super(className);
        Predicatid = _predicatId;
        expression = _expression;
        list_expressions_linked_to_objects = new ASTList<>();
        list_var_in_pointers = new ASTList<>();
        if (l!=null) {
            list_expressions_linked_to_objects = l.list_expression_pointers;

            for (int i = 0; i < l.list_object_pointers.size(); i++) {
                list_var_in_pointers.addAll(l.list_object_pointers.get(i).liste_variable);
            }
        }
        addChild(Predicatid);
        addChild(expression);
        expression.refactorList(expression);

        /*addChild(list_var_in_pointers);
        addChild(list_expressions_linked_to_objects);*/
    }

    public void refactorList(){
        //list_var_in_pointers.putElementsInParents(this);
        for (ExprVariable evar:list_var_in_pointers){
            addChild(evar.ident);
        }
        list_expressions_linked_to_objects.putElementsInParents((this));
    }

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }
}
