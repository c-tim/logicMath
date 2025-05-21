package compilation_steps.AST;

import java_cup.runtime.ComplexSymbolFactory.Location;

import java.util.ArrayList;
import java.util.List;

public abstract class ASTNode {

    private List<ASTNode> children;

    public abstract void accept(AstDefaultVisitor visitor);

    String labelClass;

    public String getLabelClass() {
        return labelClass;
    }


    private Location start, stop;

    public void addChild(ASTNode node) {
        children.add(node);
    }

    public List<ASTNode> getChildren() {
        return children;
    }

    void addChildren(final ASTNode... _children) {
        for (ASTNode e : _children) {
            children.add(e);
        }
    }

    public void setLocations(final Location left, final Location right) {
        start = left;
        stop = right;
    }

    @Override
    public String toString() {
        return labelClass;
    }

    public ASTNode(final String name) {
        labelClass = name;
        this.children = new ArrayList<ASTNode>();
    }

    public ASTNode(final String name, List<ASTNode> children) {
        labelClass = name;
        this.children = children;
    }
}
