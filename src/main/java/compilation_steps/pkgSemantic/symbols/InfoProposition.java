package compilation_steps.pkgSemantic.symbols;

public class InfoProposition extends InfoWithScope {

    private boolean statement_prooved;

    private final InfoObject[] vars;

    public InfoProposition(final String _name, final InfoObject... args) {
        super(_name, null);
        this.vars = args;
    }

    public InfoObject[] getArgs() {
        return this.vars;
    }

    @Override
    public String toString() {

        String extended_vars = "";

        for (InfoObject obj : vars){
            extended_vars += obj.toString();
        }


        return "("+statement_prooved + ")_"+name +"["+extended_vars+"]";


    }


}
