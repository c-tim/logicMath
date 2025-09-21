package compilation_steps.AST;

public class Ident extends ASTNode {

    public String getName() {
        return name;
    }

    String name;


    /**
     * @param visitor
     */
    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public Ident(final String _name) {
        super(Ident.class.getName());
        name = _name;
    }

    public static Ident create(final String name){
        return new Ident(name);
    }
}
