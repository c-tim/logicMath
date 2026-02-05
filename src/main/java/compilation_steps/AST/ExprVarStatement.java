package compilation_steps.AST;

public class ExprVarStatement extends Expression{

    Ident var;

    public ExprVarStatement(Ident var) {
        this.var = var;
    }

    public static ExprVarStatement create(Ident a){
        return new ExprVarStatement(a);
    }

}
