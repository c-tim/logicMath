package compilation_steps.AST;

public class Theory extends ASTNode {

    Ident theoryId;

    //TODO : change TheoryBody with the expressions it contains
    TheoryBody body;

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public Theory(final Ident _theoryId, TheoryBody _body){
        super(Theory.class.getName());
        theoryId = _theoryId;
        body = _body;

        //Adding the nodes of TheoryBody as children of Theory for Ast Visitors
        for(Proposition prop : body.list_proposition){
            addChild(prop);
        }

        for(Definition def : body.list_definition){
            addChild(def);
        }
    }

    public String toString(){
        return "Theory "+theoryId.getName();
    }

    public static Theory create(final Ident _theoryId, TheoryBody _body){
        return new Theory(_theoryId, _body);
    }
}
