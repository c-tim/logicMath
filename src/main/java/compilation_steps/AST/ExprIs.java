package compilation_steps.AST;

public class ExprIs extends Expression{

    public Ident getIsType() {
        return isType;
    }

    public Ident getVar() {
        return var;
    }

    Ident var, isType;

    public ExprIs(Ident _var, Ident _type) {
        super(ExprIs.class.toString());

        this.var = _var;
        this.isType = _type;
        addChild(var);
        addChild(isType);
    }


    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public static ExprIs create(Ident var, Ident type){
        return new ExprIs(var, type);
    }

    @Override
    public String toString(){
        /*return var.toString() + "is" + isType.toString();*/
        return "Is_expr";
    }
}
