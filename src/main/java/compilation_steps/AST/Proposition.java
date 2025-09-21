package compilation_steps.AST;

public class Proposition extends ASTNode {

    boolean isAxiom;

    Ident propositionId;

    Expression linkedStatement;

    public Proposition(boolean _isAxiom, Ident _propositionId) {
        super(Proposition.class.getName());
        isAxiom = _isAxiom;
        propositionId = _propositionId;
    }

    @Override
    public String toString() {
        String label;
       if(isAxiom){
           label = "Axiom";
       }else{
           label = "Proposition";
       }
       return label; // leave to add info if needed later
    }

    public Proposition(final boolean _isAxiom, Ident _propositionId,Expression _linked_Statement) {
        super(Proposition.class.getName());
        isAxiom = _isAxiom;
        propositionId = _propositionId;
        linkedStatement = _linked_Statement;
    }

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public static Proposition create(boolean _isAxiom, Ident _propositionId){
        return new Proposition(_isAxiom, _propositionId);
    }

    public static Proposition create(final boolean _isAxiom, Ident _propositionId,Expression _linked_Statement){
        return new Proposition(_isAxiom, _propositionId, _linked_Statement);
    }

}
