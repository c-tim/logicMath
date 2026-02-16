package compilation_steps.pkgSemantic.symbols;


//add a lot of hierarchy but usefull to redundant code
public class InfoWithScope extends Info{


    Scope scope;




    public Scope getScope() {
        return this.scope;
    }

    public void setScope(final Scope sc) {
        this.scope = sc;
    }


    public InfoWithScope(String name, Scope scope) {
        super(name);
        this.scope = scope;
    }
}
