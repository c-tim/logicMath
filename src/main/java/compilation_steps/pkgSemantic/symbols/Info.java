package compilation_steps.pkgSemantic.symbols;

public abstract class Info {

    final String name;

    public String getName() {
        return this.name;
    }

    public Info(final String _name){
        name=_name;
    }
}
