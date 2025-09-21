package compilation_steps.AST;

import java.util.List;
import java.util.Objects;

public class ExprPointer extends ExprQuantificateur{


    Ident set;
    //List<ExprVariable> liste_variables;


    public ExprPointer(ListVariables list, Ident _set){
        super();
        set=_set;
        //Collecting the ExprVariables stored in the ListVariables
        if(list.liste_variables != null){
            liste_variable.addAll(list.liste_variables);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExprPointer that = (ExprPointer) o;
        return Objects.equals(liste_variable, that.liste_variable);
    }

    
    
    
    public static ExprPointer create(ListVariables list_var, Ident set){
        return new ExprPointer(list_var, set);
    }

    /**
     * @return 
     */
    @Override
    public List<ExprVariable> getExternalVariable() {
        return liste_variable;
    }
}
