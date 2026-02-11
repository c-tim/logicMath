package compilation_steps.pkgSemantic;

import compilation_steps.AST.ASTNode;
import java.util.Map;
import java.util.HashMap;

public class SemanticAttribute<R> {

    private final Map<ASTNode, R> attribut;

    public SemanticAttribute() {
        this.attribut = new HashMap<>();
    }

    public R get(final ASTNode n) {
        return this.attribut.get(n);
    }

    public void set(final ASTNode n, final R attr) {
        this.attribut.put(n, attr);
    }
}
