package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

public class ListVariables extends ASTNode{


    ASTList<ExprVariable> liste_variables;

    public ListVariables(Ident var) {
        super(ListVariables.class.getName());
        liste_variables = new ASTList<>();
        addVariableToList(var);
        //refactorList();
    }

    public void addVariableToList(Ident identVar){
        liste_variables.add(ExprVariable.create(identVar));
    }

    public void refactorList(){
        //liste_variables.putElementsInParents(this);
        for (ExprVariable evar: liste_variables){
            addChild(evar.ident);
        }
    }

    /**
     * @param visitor
     */
    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public static ListVariables create(Ident var){
        return new ListVariables(var);
    }
}
