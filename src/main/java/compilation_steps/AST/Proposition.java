package compilation_steps.AST;

import java.beans.beancontext.BeanContextSupport;
import java.util.ArrayList;
import java.util.List;

public class Proposition extends ASTNode {

    private List<ExprVariable> list_var_in_pointers;
    private List<ExpressionPointer> list_expressions_linked_to_objects;
    boolean isAxiom;


    public List<ExpressionPointer> getList_expressions_linked_to_objects() {
        return list_expressions_linked_to_objects;
    }

    public List<ExprVariable> getList_var_in_pointers() {
        return list_var_in_pointers;
    }

    public ExprVariable getVar(int i){
        return list_var_in_pointers.get(i);
    }

    public Ident getPropositionId() {
        return propositionId;
    }

    Ident propositionId;

    Expression linkedStatement;

    public Proposition(boolean _isAxiom, Ident _propositionId) {
        super(Proposition.class.getName());
        isAxiom = _isAxiom;
        propositionId = _propositionId;
    }
    public Proposition(final boolean _isAxiom, Ident _propositionId,Expression _linked_Statement, ListExprArgPointer list_pointers) {
        super(Proposition.class.getName());
        isAxiom = _isAxiom;
        propositionId = _propositionId;
        linkedStatement = _linked_Statement;
        list_var_in_pointers = new ArrayList<>();
        list_expressions_linked_to_objects = new ArrayList<>();

        if(list_pointers != null){

        list_expressions_linked_to_objects = list_pointers.list_expression_pointers;
            for (ExprVarPlaceHolder vph : list_pointers.list_object_pointers) {
                list_var_in_pointers.addAll(vph.liste_variable);

            }}
    }

    @Override
    public String toString() {
        String label;
       if(isAxiom){
           label = "Axiom";
       }else{
           label = "Proposition";
       }

        if (linkedStatement == null) {
            return label;

        }


       return label + ":"+linkedStatement.toString(); // leave to add info if needed later
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

    public static Proposition create(final boolean _isAxiom, Ident _propositionId,Expression _linked_Statement, ListExprArgPointer _list){
        return new Proposition(_isAxiom, _propositionId, _linked_Statement, _list);
    }
    





}
