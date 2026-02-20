package compilation_steps.AST;


//This is a leftover of the old system I used to catch expression and leave for the moment un artefact hardcoded to get its ident
public class ExprCallPredicat extends Expression{

    Ident identCallPredicat;
    ASTList<ExprVariable> list_variables_args;

    public ExprCallPredicat(Ident _predicat, ListVariables l) {
        super(ExprCallPredicat.class.toString());

        this.identCallPredicat = _predicat;

        if(l != null){
            list_variables_args.addAll(l.liste_variables);
        }
        addChild(identCallPredicat);
    }


    //To fix the problem of the old system, for the moment I add to give parent in argument
    // so it can give its ident while removing itself from the tree
    // TODO : fix this case
    //TODO maybe for the moment we can only do one depth of predicat call : big issue
    @Override
    public void refactorList(ASTNode n){
        for (ExprVariable evar : list_variables_args){
            addChild(evar.ident);
        }
    }


    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }
    public static ExprCallPredicat create(Ident a, ListVariables l){
        return new ExprCallPredicat(a,l);
    }


}
