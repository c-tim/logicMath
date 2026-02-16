package compilation_steps.pkgSemantic.symbols;

import java.util.Collection;

public class InfoTheory extends Info{


   // private final String parent;

    private Scope scope;


    //TODO add scope handle (=> import theory, much much later if everything works)
    public InfoTheory(final String _name) {
        super(_name);
      // this.parent = _parent;
        this.scope = null;
    }


   /* public String getParent() {
        return this.parent;
    }*/

    public Scope getScope() {
        return this.scope;
    }

    public void setScope(final Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "theory " + this.name;
    }
}
