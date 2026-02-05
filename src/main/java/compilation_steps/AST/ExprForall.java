package compilation_steps.AST;

import java.util.List;
import java.util.Objects;

public class ExprForall extends ExprQuantificateur{


    //List<ExprVariable> liste_variables;


    public ExprForall(ListVariables list){
        super();
        //Collecting the ExprVariables stored in the ListVariables
        if(list.liste_variables != null){
            liste_variable.addAll(list.liste_variables);
        }
    }

    public ExprForall(List<ExprVariable> list){
        super();
        //Collecting the ExprVariables stored in the ListVariables
        if(list != null){
            liste_variable.addAll(list);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExprForall that = (ExprForall) o;
        return Objects.equals(liste_variable, that.liste_variable);
    }

    public static ExprForall create(ListVariables list_var){
        return new ExprForall(list_var);
    }

    @Override
    public String toString(){
        return "Forall";
    }


}
