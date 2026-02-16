package compilation_steps.pkgSemantic.symbols;

import compilation_steps.AST.Statement;


import java.util.List;

public class InfoObject extends Info{


    // The definitions of the object, for example : [ "x is {Type}"; "forall y, y in x => y is {Type}"]
    private List<Statement> statements;

    public InfoObject(final String name) {
        super(name);
    }


    public List<Statement> statements() {
        return this.statements;
    }

    public String toString() {
        String extended_statements = "";
        if (statements == null){
            return name;
        }
        for(Statement s : statements){
            extended_statements += s.toString();
        }
        return this.name + ": [ "+ extended_statements+"]" ;
    }
}
