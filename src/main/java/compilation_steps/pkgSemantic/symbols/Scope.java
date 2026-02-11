package compilation_steps.pkgSemantic.symbols;

import compilation.Printer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Scope {

    private Scope parent;
    private final List<Scope> children_scopes;

    private final SymbolTable<String, InfoObject> table_objects;


    private final SymbolTable<String, InfoProposition> table_propositions;
    private final SymbolTable<String, InfoDefinition> table_definitions;

    private final SymbolTable<String, InfoExpression> table_expressions;

    private final SymbolTable<String, InfoIsTerm> table_isTerm;
    private final SymbolTable<String, InfoTheory> table_theory;

    private final String scopeName;




    public Scope(final Scope parent, final String name) {
        this.scopeName = name;
        this.parent = parent;
        this.table_objects = new SimpleSymbolTable<>();
        this.table_propositions = new SimpleSymbolTable<>();
        this.table_definitions = new SimpleSymbolTable<>();
        this.table_expressions = new SimpleSymbolTable<>();
        this.table_isTerm = new SimpleSymbolTable<>();
        this.table_theory = new SimpleSymbolTable<>();
        this.children_scopes = new ArrayList<>();
        if (parent != null) {
            parent.children_scopes.add(this);
        }
    }

    public InfoObject lookupObject(final String name) {
        InfoObject v = null;
        for (Scope s = this; s != null && v == null; s = s.parent) {
            v = s.table_objects.lookup(name);
        }
        return v;
    }

    public InfoObject insertObject(final InfoObject o) {
        if (isNameAlreadyTakenInCurrentScope(o.getName())){
            return this.table_objects.insert(o.getName(), o);
        }
        return null;
    }


    public Collection<InfoObject > getObjects() {
        return this.table_objects.getInfos();
    }

    public Collection<InfoObject > getAllObjects() {
        final List<InfoObject > res = new ArrayList<>();
        res.addAll(this.table_objects.getInfos());
        for (Scope s : this.children_scopes) {
            res.addAll(s.getAllObjects());
        }
        return res;
    }


    public InfoProposition lookupProposition(final String name) {
        InfoProposition m = null;
        for (Scope s = this; s != null && m == null; s = s.parent) {
            m = s.table_propositions.lookup(name);
            // TODO a supprimer une fois testé
            // Debug.log("tested "+s.toString() + " looking for "+getName);

        }
        return m;
    }

    //Return the object if it is rejected
    public InfoProposition insertProposition(final InfoProposition p) {
        if (isNameAlreadyTakenInCurrentScope(p.getName())){
            return this.table_propositions.insert(p.getName(), p);
        }
        return null;
    }


    public Collection<InfoProposition> getPropositions() {
        return this.table_propositions.getInfos();
    }


    public InfoDefinition lookupInfoDefinition(final String name) {
        InfoDefinition m = null;
        for (Scope s = this; s != null && m == null; s = s.parent) {
            m = s.table_definitions.lookup(name);
            // TODO a supprimer une fois testé
            // Debug.log("tested "+s.toString() + " looking for "+getName);

        }
        return m;
    }


    public InfoDefinition insertDefinition(final InfoDefinition d) {
        if (isNameAlreadyTakenInCurrentScope(d.getName())){
            return this.table_definitions.insert(d.getName(), d);
        }
        return null;
    }


    public Collection<InfoDefinition>InfoDefinitions() {
        return this.table_definitions.getInfos();
    }



    public InfoTheory lookupTheory(final String name) {
        InfoTheory th = null;
        for (Scope s = this; s != null && th == null; s = s.parent) {
            th = s.table_theory.lookup(name);
            // TODO a supprimer une fois fini
            // Debug.log("tested "+s.toString() + " looking for "+getName);
        }
        return th;
    }


    public InfoTheory insertTheory(final InfoTheory th) {

        if (isNameAlreadyTakenInCurrentScope(th.getName())){
            return this.table_theory.insert(th.getName(), th);
        }

        return null;
    }


    public Collection<InfoTheory> getTheories() {
        return this.table_theory.getInfos();
    }


    public InfoExpression lookupExpression(final String name) {
        InfoExpression e = null;
        for (Scope s = this; s != null && e == null; s = s.parent) {
            e = s.table_expressions.lookup(name);
            // TODO a supprimer une fois fini
            // Debug.log("tested "+s.toString() + " looking for "+getName);
        }
        return e;
    }


    public InfoExpression insertExpression(final InfoExpression e) {
        if (isNameAlreadyTakenInCurrentScope(e.getName())){
             return this.table_expressions.insert(e.getName(), e);
        }
        return null;
    }


    public Collection<InfoExpression> getExpressions() {
        return this.table_expressions.getInfos();
    }



    public InfoIsTerm lookupIsTerm(final String name) {
        InfoIsTerm e = null;
        for (Scope s = this; s != null && e == null; s = s.parent) {
            e = s.table_isTerm.lookup(name);
            // TODO a supprimer une fois fini
            // Debug.log("tested "+s.toString() + " looking for "+getName);
        }
        return e;
    }


    public InfoIsTerm insertIsTerm(final InfoIsTerm e) {
        if (isNameAlreadyTakenInCurrentScope(e.getName())){
            return this.table_isTerm.insert(e.getName(), e);
        }
        return null;
    }


    public Collection<InfoIsTerm> getEIsTerm() {
        return this.table_isTerm.getInfos();
    }


    public boolean isNameAlreadyTakenInCurrentScope(final String name){
        return lookupElement(name)!=null;
    }

    public Info lookupElement(final String name){
        Info e = lookupTheory(name);
        if (e != null){
            return e;
        }
        //looking in propositions
        e = lookupProposition(name);
        if (e != null){
            return e;
        }

        //looking in definition
        e = lookupInfoDefinition(name);
        if (e != null){
            return e;
        }

        e = lookupExpression(name);
        if (e != null){
            return e;
        }

        //returning e if its null or found in object
        e = lookupObject(name);
        return e;
    }

    public boolean addInheritance(final Scope oldParent, final Scope newParent) {
        // mutation uniquement à la racine
        if (this.parent == null || this.parent.parent != null) {
            return false;
        }
        // pas de mutation vers la racine
        if (newParent == null) {
            return false;
        }
        // pas de mutation depuis un parent inconnu
        if (this.parent != oldParent) {
            return false;
        }
        // OK
        this.parent = newParent;
        this.parent.children_scopes.add(this);
        oldParent.children_scopes.remove(this);
        return true;
    }


    @Override
    public String toString() {
        return "Scope " + this.scopeName;
    }


    public String toPrintUp() {
        return this.scopeName + " -> " + this.parent.toPrintUp();
    }


    public void toPrint(){
        toPrint(0);
    }

    public void toPrint(int ident) {
        Printer.PIEDisplayClass("Scope " + this.scopeName+"\n");
        int local_indent =ident + 1;
        for (Info i : getTheories()) {
            Printer.PIEDisplayClass(i+"\n");
        }
        for (Info i : getPropositions()) {
            Printer.PIEDisplayClass(i+"\n");
        }
        for (Info i : getObjects()) {
            Printer.PIEDisplayClass(i+"\n");
        }
        for (Scope s : this.children_scopes) {
            s.toPrint(local_indent);
        }
    }

}
