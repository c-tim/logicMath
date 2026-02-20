package compilation_steps.AST;

public class Proposition extends Predicat {


    boolean isAxiom;


    Expression linkedStatement;

    public Proposition(boolean _isAxiom, Ident _propositionId) {
        super(Proposition.class.toString(),_propositionId, null, null);
        isAxiom = _isAxiom;
   }
    public Proposition(final boolean _isAxiom, Ident _propositionId,Expression _linked_Statement, ListArgPredicat list_pointers) {
        super(Proposition.class.toString(), _propositionId, list_pointers, _linked_Statement);
        isAxiom = _isAxiom;
        linkedStatement = _linked_Statement;
    }

    @Override
    public String toString() {
        String label;
       if(isAxiom){
           label = "Axiom";
       }else{
           label = "Proposition";
       }

        /*if (linkedStatement == null) {
            return label;

        }*/


       //return label + ":"+linkedStatement.toString(); // leave to add info if needed later
        return label;
    }


    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public static Proposition create(boolean _isAxiom, Ident _propositionId){
        return new Proposition(_isAxiom, _propositionId);
    }

    public static Proposition create(final boolean _isAxiom, Ident _propositionId,Expression _linked_Statement){
        return new Proposition(_isAxiom, _propositionId, _linked_Statement, null);
    }

    public static Proposition create(final boolean _isAxiom, Ident _propositionId,Expression _linked_Statement, ListArgPredicat _list){
        return new Proposition(_isAxiom, _propositionId, _linked_Statement, _list);
    }
    





}
