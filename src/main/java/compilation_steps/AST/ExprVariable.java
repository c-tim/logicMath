package compilation_steps.AST;

public class ExprVariable extends Expression{

    Ident ident;


    public ExprVariable(Ident _ident){
        super();
        ident= _ident;
    }

    public static ExprVariable create(Ident _ident){
        return new ExprVariable(_ident);
    }
}
