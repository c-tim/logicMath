package compilation_steps.AST;

public class ASTStartNode extends ASTNode {

    public Theory linked_Theory;

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public ASTStartNode(Theory _theory) {
        super(ASTStartNode.class.getName());
        linked_Theory = _theory;
    }

    public static ASTStartNode create(final Theory _Theory) {
        return new ASTStartNode(_Theory);
    }

}
