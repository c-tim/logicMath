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

    public List<Expression> getLinked_pointer_args() {
        return linked_pointer_args;
    }

    public Ident getIdent() {
        return ident;
    }

    List<Expression> linked_pointer_args;


    public ExprVariable(Ident _ident){
        super();
        ident= _ident;
        linked_pointer_args = new ArrayList<>();
    }

    public static ExprVariable create(Ident _ident){
        return new ExprVariable(_ident);
    }
}
