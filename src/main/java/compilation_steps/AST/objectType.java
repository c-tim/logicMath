package compilation_steps.AST;

public class objectType extends ASTNode {

    public objectType(String name) {
        super(objectType.class.getName());
    }

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

}
