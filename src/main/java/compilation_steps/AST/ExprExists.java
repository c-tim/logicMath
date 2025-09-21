package compilation_steps.AST;

import java.util.List;
import java.util.Objects;

public class ExprExists extends ExprQuantificateur {

    //si vrai equivalent a "il existe un unique.."
    public boolean mustBeUnique;

    public ExprExists(ListVariables list){
        super();
        if(list.liste_variables != null){
            liste_variable.addAll(list.liste_variables);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExprExists that = (ExprExists) o;

        return (mustBeUnique == that.mustBeUnique) && Objects.equals(liste_variable, that.liste_variable);
    }

    public static ExprExists create(ListVariables list_var){
        return new ExprExists(list_var);
    }



}
