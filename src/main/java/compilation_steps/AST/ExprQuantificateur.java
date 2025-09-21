package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ExprQuantificateur extends Expression{

    //liste des variables créé dans exists, mustBeUnique est commun a tous
    List<ExprVariable> liste_variable;

    public ExprQuantificateur(){
        super();
        liste_variable = new ArrayList<>();
    }

    public void addListe_variable(ExprVariable variable) {
        liste_variable.add(variable);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(liste_variable);
    }
}
