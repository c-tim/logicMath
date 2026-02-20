package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

public class ExprVariable extends Expression{

    public String getIdentName() {
        return ident.getName();
    }

    Ident ident;

    public void addLinkedPointerArgs(ArgExpression p){
        linked_pointer_args.add(p.expr);
    }

    public ASTList<Expression> getLinked_pointer_args() {
        return linked_pointer_args;
    }

    public Ident getIdent() {
        return ident;
    }

    ASTList<Expression> linked_pointer_args;


    public ExprVariable(Ident _ident){
        super(ExprVariable.class.toString());
        ident= _ident;
        linked_pointer_args = new ASTList<>();
        addChild(ident);

    }

    /*public void refactorList(){
        linked_pointer_args.putElementsInParents(this);
    }*/
    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }
    public static ExprVariable create(Ident _ident){
        return new ExprVariable(_ident);
    }
}
