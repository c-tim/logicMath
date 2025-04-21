package compilation_steps.AST;

public class ASTStartNode extends ASTNode {

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }
}
