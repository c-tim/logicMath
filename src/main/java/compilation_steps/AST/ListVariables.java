package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

public class ListVariables extends ASTNode{


    List<ExprVariable> liste_variables;

    public ListVariables(Ident var) {
        super(ListVariables.class.getName());
        liste_variables = new ArrayList<>();
        addVariableToList(var);
    }

    public void addVariableToList(Ident identVar){
        liste_variables.add(ExprVariable.create(identVar));
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
