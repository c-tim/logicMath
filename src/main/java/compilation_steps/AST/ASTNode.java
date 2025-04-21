package compilation_steps.AST;

import java.util.List;

public abstract class ASTNode {

    private List<ASTNode> children;

    public abstract void accept(AstDefaultVisitor visitor);

    public void addChild(ASTNode node) {
        children.add(node);
    }

    public List<ASTNode> getChildren() {
        return children;
    }
}
