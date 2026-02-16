package compilation_steps.pkgSemantic.symbols;

import compilation.Printer;

import java.util.*;

public class Scope {

    public Scope getParent() {
        return parent;
    }

    private Scope parent;
    private final List<Scope> children_scopes;

    private symbolTableManager table_manager;

    private final SimpleSymbolTable<InfoObject> table_objects;


    private final SimpleSymbolTable<InfoProposition> table_propositions;
    private final SimpleSymbolTable<InfoDefinition> table_definitions;

    private final SimpleSymbolTable<InfoExpression> table_expressions;

    private final SimpleSymbolTable<InfoIsTerm> table_isTerm;
    private final SimpleSymbolTable<InfoTheory> table_theory;






    SimpleSymbolTable<?>[] list_tables;
    private final String scopeName;




    public Scope(final Scope parent, final String name) {
        this.scopeName = name;
        this.parent = parent;
        this.table_objects = new SimpleSymbolTable<>(5);
        this.table_propositions = new SimpleSymbolTable<>(1);
        this.table_definitions = new SimpleSymbolTable<>(2);
        this.table_expressions = new SimpleSymbolTable<>(3);
        this.table_isTerm = new SimpleSymbolTable<>(4);
        this.table_theory = new SimpleSymbolTable<>(0);

        table_manager = new symbolTableManager(table_objects,table_propositions, table_definitions, table_expressions, table_isTerm, table_theory);

        this.children_scopes = new ArrayList<>();
        if (parent != null) {
            parent.children_scopes.add(this);
        }
    }

    public Info VerifyAndInsertElement(Info e) {

        if (!isNameAlreadyTakenInCurrentScope(e.getName())){
            return table_manager.insertElementIntoLinkedTable(e);
        }

        return e;
    }

    public boolean isNameAlreadyTakenInCurrentScope(final String name){
        return lookupElement(name)!=null;
    }

    //return null if not found in all the table
    public Info lookupElement(final String name){
        //Theory
        for (Scope s = this; s != null; s = s.parent) {

            for (int i = 0; i < s.table_manager.getNumber_tables(); i++) {
                Info e = s.table_manager.getTable(i).lookup(name);
                if (e != null) {
                    return e;
                }
            }
        }
        return null;

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
        Printer.PIEDisplayClass("Scope " + this.scopeName+"\n", ident);
        ident++;

        for (int i = 0; i < table_manager.getNumber_tables() ; i++) {
            for (Info e : table_manager.getTable(i).getInfos()) {
                Printer.PIEDisplayClass(e+"\n", ident);
            }
        }



        for (Scope s : this.children_scopes) {
            s.toPrint(ident);
        }
        ident--;

    }

}
/*

   /*public final symbolFinder<InfoObject> sf_objects;


    public final symbolFinder<InfoProposition> sf_propositions;
    public final symbolFinder<InfoDefinition> sf_definitions;

    public final symbolFinder<InfoExpression> sf_expressions;

    public final symbolFinder<InfoIsTerm> sf_isTerm;
    public final symbolFinder<InfoTheory> sf_theory;*/



//list_tables = new SimpleSymbolTable<?>[]{table_objects, table_propositions, table_definitions, table_expressions, table_isTerm, table_theory};

       /* sf_objects = new symbolFinder<>(this);


        sf_propositions = new symbolFinder<>(this);
        sf_definitions = new symbolFinder<>(this);

        sf_expressions = new symbolFinder<>(this);

        sf_isTerm = new symbolFinder<>(this);
        sf_theory = new symbolFinder<>(this);*/

//TODO fix this monster
        /*symbolFinder[] list_sf = new symbolFinder[]{sf_objects, sf_propositions, sf_definitions, sf_expressions, sf_isTerm, sf_theory};
        String[] list_sf_string = {sf_objects.getClass().toString(),sf_propositions.getClass().toString(),sf_definitions.getClass().toString(),sf_expressions.getClass().toString(),sf_isTerm.getClass().toString(),sf_theory.getClass().toString() };
        liste_table = new HashMap<>();
        for (int i = 0; i < list_sf.length; i++) {
            liste_table.put(list_sf_string[i], list_sf[i]);
        }
*/


    /*public InfoObject lookupObject(final String name) {
        InfoObject v = null;
        for (Scope s = this; s != null && v == null; s = s.parent) {
            v = s.table_objects.lookup(name);
        }
        return v;
    }

    public SimpleSymbolTable<> test(){
        return table_isTerm;
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


    public InfoTheory insertElement(final InfoTheory th) {

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
*/


        /*Info e = table_theory.lookup(name);
        if (e != null){
            return e;
        }
        //propositions
        e = table_propositions.lookup(name);
        if (e != null){
            return e;
        }
        //definition
        e = table_definitions.lookup(name);
        if (e != null){
            return e;
        }
        //expression defined by is
        e = table_isTerm.lookup(name);
        if (e != null){
            return e;
        }
        //returning e if its null or found in object
        e = table_objects.lookup(name);
        return e;*/
    /*for (Info i : table_theory.getInfos()) {
            Printer.PIEDisplayClass(i+"\n");
        }
        for (Info i : table_propositions.getInfos()) {
            Printer.PIEDisplayClass(i+"\n");
        }
        for (Info i : table_objects.getInfos()) {
            Printer.PIEDisplayClass(i+"\n");
        }
        for (Info i : table_expressions.getInfos()) {
            Printer.PIEDisplayClass(i+"\n");
        }

        for (Info i : table_isTerm.getInfos()) {
            Printer.PIEDisplayClass(i+"\n");
        }

        for (Info i : table_definitions.getInfos()) {
            Printer.PIEDisplayClass(i+"\n");
        }*/


     /*for (SymbolTable sf : new SymbolTable[]{table_theory}){
            if (sf!=null){
            Info e = sf.lookup(name);
            if(e!=null){
                return e;
            }}
        }

        return null;*/