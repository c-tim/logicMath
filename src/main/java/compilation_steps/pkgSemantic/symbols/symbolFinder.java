package compilation_steps.pkgSemantic.symbols;


import java.util.Collection;

//class used to avoid redundancy of table lookup and insert method
public class symbolFinder<R extends Info>  {

    Scope linked_scope;

    private final SymbolTable<String, R> table;

    public symbolFinder(Scope _linked_scope) {
        table = new SimpleSymbolTable<R>(-1);
        linked_scope = _linked_scope;
    }


    public R lookup(final String name) {
        R m = null;
        /*for (Scope s = linked_scope; s != null; s = s.getParent()) {
            m = s.liste_table.get((String)R).lookup(name);
        }
        return m;*/
        return table.lookup(name);
    }

    //Return the object if it is rejected
    public R insert(final R p) {
        if (linked_scope.isNameAlreadyTakenInCurrentScope(p.getName())){
            return table.insert(p.getName(), p);
        }
        return null;
    }


    public Collection<R> getInfosTable() {
        return table.getInfos();
    }



}
