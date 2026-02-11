package compilation_steps.AST;

public class ExprIs extends Expression{

    public Ident getIsType() {
        return isType;
    }

    public Ident getVar() {
        return var;
    }

    Ident var, isType;

    public ExprIs(Ident var, Ident type) {
        this.var = var;
        this.isType = type;
    }

    public static ExprIs create(Ident var, Ident type){
        return new ExprIs(var, type);
    }

    @Override
    public String toString(){
        return var.toString() + "is" + isType.toString();
    }
}
