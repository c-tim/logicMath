package compilation_steps.AST;

public class ASTList<R extends ASTNode> extends ASTNode{
    /**
     * @param visitor
     */
    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public ASTList() {
        super(ASTList.class.getName());
    }

}
