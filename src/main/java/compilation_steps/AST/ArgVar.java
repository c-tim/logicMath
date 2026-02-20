package compilation_steps.AST;

import java.util.List;
import java.util.Objects;

public class ArgVar extends ExprQuantificateur implements ArgPredicat {


    Ident set;
    //List<ExprVariable> liste_variables;


    public ArgVar(ListVariables list, Ident _set){
        super(ArgVar.class.toString());
        set=_set;
        //Collecting the ExprVariables stored in the ListVariables
        if(list.liste_variables != null){
            liste_variable.addAll(list.liste_variables);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ArgVar that = (ArgVar) o;
        return Objects.equals(liste_variable, that.liste_variable);
    }

    
    
    
    public static ArgVar create(ListVariables list_var, Ident set){
        return new ArgVar(list_var, set);
    }

    /**
     * @return
     */
    @Override
    public ASTList<ExprVariable> getExternalVariable() {
        return liste_variable;
    }

    @Override
    public String toString(){

        String s = "";

        for (ExprVariable v:liste_variable){
            s+=v.toString();
        }

        return "VarArg["+s+"]";
    }

}
