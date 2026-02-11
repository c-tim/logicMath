package compilation_steps.pkgSemantic;

import compilation.Printer;
import compilation_steps.AST.*;
import compilation_steps.pkgSemantic.symbols.*;

public class BuildSymbolTable extends AstDefaultVisitor {

    protected static final String OBJECT = "Object";

    protected final SemanticTree semanticTree;

    protected Scope currentScope;

    protected InfoTheory currentTheory;

    protected int errors;

    private String errorDuplicationMessage = "Ident already defined in scope ";
    private String errorIdentIndefined = "Ident indefined or defined in another type";


    public BuildSymbolTable(final SemanticTree semanticTree) {
        this.errors = 0;
        this.semanticTree = semanticTree;
        this.currentScope = semanticTree.getRootScope();
        this.currentTheory = null;
    }

    public int execute() {
        addTheory();
        semanticTree.getStartNode().accept(this);
        Printer.PIEDisplaySymbolTab(semanticTree);
        return errors;
    }

    protected void addTheory() {
        Scope sc = semanticTree.getRootScope();
        final InfoTheory th = new InfoTheory(OBJECT, null);
        sc = newTheoryScope(sc, th);
        //final InfoProposition m = new InfoProposition("boolean", "equals", new InfoVar("this", OBJECT), new InfoVar("o", OBJECT));
        //newMethodScope(sc, m);
    }

/* Getter/Setters */
    
    protected void setTheory(final ASTNode n, final InfoTheory theory) {
        semanticTree.getAttributesTheory().set(n, theory);
    }

    protected InfoTheory getTheory(final ASTNode n) {
        return semanticTree.getAttributesTheory().get(n);
    }


    protected void setScope(final ASTNode n, final Scope sc) {
        semanticTree.getAttributesScope().set(n, sc);
    }


    protected Scope getScope(final ASTNode n) {
        return semanticTree.getAttributesScope().get(n);
    }


    /* Create Scopes */
    protected Scope newTheoryScope(final Scope sc, final InfoTheory th) {
        ErrorIfNotNull(sc.insertTheory(th), errorDuplicationMessage);
        final Scope scope_child = new Scope(sc, th.getName());
        th.setScope(scope_child);
        return scope_child;
    }

    protected Scope newDefinitionScope(final Scope sc, final InfoDefinition e) {
        ErrorIfNotNull(sc.insertDefinition(e), errorDuplicationMessage);
        final Scope enfants = new Scope(sc, e.getName() + "_args");
        for (InfoObject v :e.getArgs()) {
            ErrorIfNotNull(enfants.insertObject(v), errorDuplicationMessage);
        }
        final Scope pf = new Scope(enfants, e.getName());
        e.setScope(pf);
        return pf;
    }

    protected Scope newPropositionScope(final Scope sc, final InfoProposition m) {
        ErrorIfNotNull(sc.insertProposition(m), errorDuplicationMessage);
        final Scope enfants = new Scope(sc, m.getName() + "_args");
        for (InfoObject v : m.getArgs()) {
            ErrorIfNotNull(enfants.insertObject(v), errorDuplicationMessage);
        }
        final Scope pf = new Scope(enfants, m.getName());
        m.setScope(pf);
        return pf;
    }

    protected Scope newExpressionScope(final Scope sc, final InfoExpression e) {
        ErrorIfNotNull(sc.insertExpression(e), errorDuplicationMessage);
        final Scope enfants = new Scope(sc, e.getName() + "_args");
        for (InfoObject v : e.getArgs()) {
            ErrorIfNotNull(enfants.insertObject(v), errorDuplicationMessage);
        }
        final Scope pf = new Scope(enfants, e.getName());
        e.setScope(pf);
        return pf;
    }


    //Add an error to the counter if info is not null, error_verification_type indique si cest une erreur de redefinition, var non defini
    protected boolean ErrorIfNotNull(final Info info, String error_verification_type) {
        if (info == null) {
            return false;
        }
        Printer.PIEShowsSymbolsEroors("BuildSymtab : "+error_verification_type+" : "  + info+"\n");
        errors++;
        return true;
    }


    @Override
    public void defaultVisit(final ASTNode n) {
        setTheory(n, currentTheory);
        setScope(n, currentScope);
        for (ASTNode f : n.getChildren()) {
            f.accept(this);
        }
        currentTheory = getTheory(n);
        currentScope = getScope(n);
    }

    /*@Override
    public void visit(final Theory n) {
        //setScope(n, currentScope);
        this.currentScope = newTheoryScope(getScope(n), getTheory(n));
        n.getTheoryId().accept(this);
        currentTheory = getTheory(n);
        currentScope = getScope(n);
    }*/

    @Override
    public void visit(final Theory n) {
        setTheory(n, currentTheory);
        setScope(n, currentScope);
        currentTheory = new InfoTheory(n.getTheoryId().getName(),"Root_theory");
        this.currentScope = newTheoryScope(currentScope, currentTheory);
        n.getTheoryId().accept(this);
        //n.parentId().accept(this);

        for (ASTNode f : n.getChildren()) {
            f.accept(this);
        }
        currentTheory = getTheory(n);
        currentScope = getScope(n);

    }

    @Override
    public void visit(final Definition n) {
        /*setTheory(n, currentTheory);
        setScope(n, currentScope);

        newDefinitionScope()
        this.currentScope = newTheoryScope(currentScope, currentTheory);
        n.getTheoryId().accept(this);
        //n.parentId().accept(this);

        for (ASTNode f : n.getChildren()) {
            f.accept(this);
        }
        currentTheory = getTheory(n);
        currentScope = getScope(n);

*/
        setTheory((ASTNode) n, currentTheory);
        setScope((ASTNode) n, currentScope);

        int number_children = n.getList_var_in_pointers().size();
        InfoObject[] listObjectExpr = new InfoObject[number_children];
        for (int i = 0; i < number_children; i++) {
            listObjectExpr[i] = new InfoObject(n.getVar(i).getIdentName());
        }

        final InfoDefinition m = new InfoDefinition(n.getDefinitionId().getName(), listObjectExpr);
        currentScope = newDefinitionScope(currentScope, m);
        for (ASTNode f : n.getChildren()) {
            f.accept(this);
        }
        currentTheory = getTheory(n);
        currentScope = getScope(n);

    }

    @Override
    public void visit(final Proposition n) {

        setTheory((ASTNode) n, currentTheory);
        setScope((ASTNode) n, currentScope);

        int number_children = n.getList_var_in_pointers().size();
        InfoObject[] listObjectExpr = new InfoObject[number_children];
        for (int i = 0; i < number_children; i++) {
            listObjectExpr[i] = new InfoObject(n.getVar(i).getIdentName());
        }

        final InfoProposition m = new InfoProposition(n.getPropositionId().getName(), listObjectExpr);
        currentScope = newPropositionScope(currentScope, m);
        for (ASTNode f : n.getChildren()) {
            f.accept(this);
        }
        currentTheory = getTheory(n);
        currentScope = getScope(n);

    }

    @Override
    public void visit(final ExprExists n) {
        setTheory((ASTNode) n, currentTheory);
        setScope((ASTNode) n, currentScope);

        int number_children = n.getChildren().size();
        InfoObject[] listObjectExpr = new InfoObject[number_children];
        for (int i = 0; i < number_children; i++) {
            listObjectExpr[i] = new InfoObject(n.getVar(i).getIdentName());
        }

        final InfoExpression m = new InfoExpression(n.nameScope(), listObjectExpr);
        currentScope = newExpressionScope(currentScope, m);
        for (ASTNode f : n.getChildren()) {
            f.accept(this);
        }
        currentTheory = getTheory(n);
        currentScope = getScope(n);
    }

    @Override
    public void visit(final ExprForall n) {
        setTheory((ASTNode) n, currentTheory);
        setScope((ASTNode) n, currentScope);

        int number_children = n.getChildren().size();
        InfoObject[] listObjectExpr = new InfoObject[number_children];
        for (int i = 0; i < number_children; i++) {
            listObjectExpr[i] = new InfoObject(n.getVar(i).getIdentName());
        }

        final InfoExpression m = new InfoExpression(n.nameScope(), listObjectExpr);
        currentScope = newExpressionScope(currentScope, m);
        for (ASTNode f : n.getChildren()) {
            f.accept(this);
        }
        currentTheory = getTheory(n);
        currentScope = getScope(n);
    }

   /* @Override
    public void visit(final ExprIs n) {
        ErrorIfNull(currentScope.lookupExpression(n.getVar().getName()), errorIdentIndefined);
        ErrorIfNull(currentScope.lookupIsTerm(n.getIsType().getName()), errorIdentIndefined);
        defaultVisit(n);
    }*/




    // Visites Spécifiques :
    // - Création de portées : TheoryMain, Klass, Method, StmtBlock
    // - Déclarations : KlassMain, Klass, Method, Variable, Formal (in Method)

    // Visites non écrites dans le squelette de MiniJAVA

   /*@Override
   public void visit(final KlassMain n) {
       //setScope(n, currentScope);
       this.currentScope = newTheoryScope(getScope(n), getKlass(n));
       n.klassId().accept(this);
       currentTheory = getKlass(n);
       currentScope = getScope(n);
   }*/
/*
    @Override
    public void visit(final Theory n) {
        setTheory(n, currentTheory);
        setScope(n, currentScope);
        currentTheory = new InfoTheory(n.klassId().getName(), n.parentId().getName());
        this.currentScope = newTheoryScope(currentScope, currentTheory);
        n.klassId().accept(this);
        n.parentId().accept(this);
        n.vars().accept(this);
        n.methods().accept(this);
        currentTheory = getTheory(n);
        currentScope = getScope(n);

    }



    @Override
    public void visit(final Variable n) {
        setTheory(n, currentTheory);
        setScope(n, currentScope);
        final InfoObject v = new InfoObject(n.varId().getName(), n.typeId().getName());
        checkRedef(getScope(n).insertVariable(v));
        currentTheory = getTheory(n);
        currentScope = getScope(n);
    }

    @Override
    public void visit(final StmtBlock n) {
        setTheory(n, currentTheory);
        setScope(n, currentScope);
        currentScope = new Scope(currentScope);
        n.vars().accept(this);
        n.stmts().accept(this);
        currentTheory = getTheory(n);
        currentScope = getScope(n);
    }*/
}
