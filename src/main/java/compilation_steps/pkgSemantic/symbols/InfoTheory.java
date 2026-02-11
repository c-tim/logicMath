package compilation_steps.pkgSemantic.symbols;

import java.util.Collection;

public class InfoTheory extends Info{

    private final String name;

    private final String parent;

    private Scope scope;


    //TODO add scope handle (=> import theory, much much later if everything works)
    public InfoTheory(final String _name, final String _parent) {
        this.name = _name;
        this.parent = _parent;
        this.scope = null;
    }

    public String getName() {
        return this.name;
    }

    public String getParent() {
        return this.parent;
    }

    public Scope getScope() {
        return this.scope;
    }

    public void setScope(final Scope scope) {
        this.scope = scope;
    }

    public Collection<InfoProposition> getPropositions() {
        return this.scope.getPropositions();
    }

    public Collection<InfoObject    > getFields() {
        return this.scope.getObjects();
    }

    @Override
    public String toString() {
        return "class " + this.name + " extends " + this.parent;
    }
}
