package compilation_steps.AST;

import java.util.List;
import java.util.Objects;

public class ExprVarPlaceHolder extends ExprQuantificateur implements ArgPointer {


    Ident set;
    //List<ExprVariable> liste_variables;


    public ExprVarPlaceHolder(ListVariables list, Ident _set){
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
        ExprVarPlaceHolder that = (ExprVarPlaceHolder) o;
        return Objects.equals(liste_variable, that.liste_variable);
    }

    
    
    
    public static ExprVarPlaceHolder create(ListVariables list_var, Ident set){
        return new ExprVarPlaceHolder(list_var, set);
    }

    /**
     * @return 
     */
    @Override
    public List<ExprVariable> getExternalVariable() {
        return liste_variable;
    }

    @Override
    public String toString(){
      return "Pointer";
    }

}
