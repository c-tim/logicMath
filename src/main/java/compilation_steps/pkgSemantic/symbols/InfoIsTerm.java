package compilation_steps.pkgSemantic.symbols;


//Added this special info because the variable defined with is are appart of other and oonly works with this word
public class InfoIsTerm extends Info{


    private final String name;

    private Scope scope;


    public InfoIsTerm(final String _name) {
        this.name = _name;
        this.scope = null;
    }


    public String getName() {
        return this.name;
    }


    public Scope getScope() {
        return this.scope;
    }

    public void setScope(final Scope sc) {
        this.scope = sc;
    }

    @Override
    public String toString() {

        return "(isType)"+name;


    }

}
