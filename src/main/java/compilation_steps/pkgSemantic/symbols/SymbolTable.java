package compilation_steps.pkgSemantic.symbols;


import java.util.Collection;

//This class might not be useful, only to describe the elements of a symbolsTable, but extended with one tableSymbol
//I used it following a compiler project code I had, maybe cleaner practice
public abstract class SymbolTable<T, R extends Info>{
    abstract R lookup(T name);

    abstract R insert(T name, R info);

    abstract Collection<R> getInfos();
}
