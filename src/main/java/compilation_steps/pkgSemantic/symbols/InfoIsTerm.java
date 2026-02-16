package compilation_steps.pkgSemantic.symbols;


//Added this special info because the variable defined with is are appart of other and oonly works with this word
public class InfoIsTerm extends Info{



    public InfoIsTerm(final String _name) {
        super(_name);
    }


    @Override
    public String toString() {

        return "(isType)"+name;


    }

}
