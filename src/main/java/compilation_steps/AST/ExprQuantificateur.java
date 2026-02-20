package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ExprQuantificateur extends Expression{

    public ASTList<ExprVariable> getListe_variable() {
        return liste_variable;
    }

    public ExprVariable getVar(int i) {
        return liste_variable.get(i);
    }



    //liste des variables créé dans exists, mustBeUnique est commun a tous
    ASTList<ExprVariable> liste_variable;

    public ExprQuantificateur(String className){
       super(className);
        liste_variable = new ASTList<>();
//        addChild(liste_variable);
    }

    @Override
    public void refactorList(ASTNode n ){
        for (ExprVariable evar : liste_variable){
            addChild(evar.ident);
        }
    }


    public void addListe_variable(ExprVariable variable) {
        liste_variable.add(variable);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(liste_variable);
    }


    public String nameScope(){
        String name_scope_var = "";
        for(ExprVariable var : liste_variable){
            name_scope_var+=var.toString()+"_";
        }

        return "Exp"+getLabelClass() + name_scope_var;
    }
}
