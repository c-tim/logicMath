package compilation_steps.pkgSemantic.symbols;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SimpleSymbolTable<R extends Info> extends SymbolTable<String, R> {


    private Map<String, R> symbols;

    public int a= 0;
    public SimpleSymbolTable(int _a) {
        a=_a;
        this.symbols = new HashMap<>();
    }

    @Override
    public R lookup(final String name) {
        return this.symbols.get(name);
    }

    @Override
    public R insert(final String name, final R info) {
        return this.symbols.put(name, info);
    }

    @Override
    public Collection<R> getInfos() {
        return this.symbols.values();
    }

    @Override
    public String toString() {
        return "SimpleTable [" + this.symbols + "]";
    }
}
