package compilation_steps.AST;

import java.util.List;

public class Ident extends ASTNode {

    public String getName() {
        return name;
    }

    String name;


    // TODO maybe horrible practice, i put variables into an Ident,
    // I dont have any ideas tho keeping it till it become a mess
    ListVariables args;

    /**
     * @param visitor
     */
    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public Ident(final String _name, final ListVariables _args) {
        super(Ident.class.getName());
        name = _name;
        args = _args;
    }

    public static Ident create(final String name){
        return new Ident(name, null);
    }
    public static Ident create(final String name, final ListVariables args){
        return new Ident(name, args);
    }
}
