package compilation_steps.AST;

public class ExprNull extends Expression{

    /**
     * @param visitor
     */
    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public ExprNull() {
        super();
    }

    public static ExprNull create(){
        return new ExprNull();
    }

    @Override
    public String toString(){
    return "Null";
    }
}
