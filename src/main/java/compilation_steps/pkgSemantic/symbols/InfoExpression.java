package compilation_steps.pkgSemantic.symbols;

public class InfoExpression extends Info{


    private final String name;

    private final InfoObject[] vars;

    private Scope scope;


    public InfoExpression(final String _name, final InfoObject... args) {
        this.name = _name;
        this.vars = args;
        this.scope = null;
    }


    public String getName() {
        return this.name;
    }


    public InfoObject[] getArgs() {
        return this.vars;
    }


    public Scope getScope() {
        return this.scope;
    }

    public void setScope(final Scope sc) {
        this.scope = sc;
    }

    @Override
    public String toString() {

        String extended_vars = "";

        for (InfoObject obj : vars){
            extended_vars += obj.toString();
        }


        return name +"["+extended_vars+"]";


    }

}
