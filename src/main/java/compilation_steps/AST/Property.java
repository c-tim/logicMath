package compilation_steps.AST;

public class Property extends ASTNode {

    public Property() {
        super(Property.class.getName());
    }

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public static Property create(){
        return new Property();
    }
}
