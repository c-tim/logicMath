package compilation_steps.pkgSemantic.symbols;


public class InfoDefinition extends InfoWithScope {

    private boolean defined;



    private final InfoObject[] vars;




    public InfoDefinition(final String _name, final InfoObject... args) {
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


        return name +"["+extended_vars+"]";


    }


}
