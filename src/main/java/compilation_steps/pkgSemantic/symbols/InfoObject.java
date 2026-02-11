package compilation_steps.pkgSemantic.symbols;

import compilation_steps.AST.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class InfoObject extends Info{

    private static final Logger log = LogManager.getLogger(InfoObject.class);
    private final String name;


    // The definitions of the object, for example : [ "x is {Type}"; "forall y, y in x => y is {Type}"]
    private List<Statement> statements;

    public InfoObject(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Statement> statements() {
        return this.statements;
    }

    public String toString() {
        String extended_statements = "";
        for(Statement s : statements){
            extended_statements += s.toString();
        }
        return this.name + ": [ "+ extended_statements+"]" ;
    }
}
