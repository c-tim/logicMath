package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

public class ExprList extends Expression{

    ASTList<Expression> list_expressions;

    public void addExpressionToList(Expression expr){
        list_expressions.add(expr);
    }
   /* public void addExpressionToListToStart(Expression expr){
        list_expressions.addFirst(expr);
    }*/


    public ExprList(Expression e){
        super(ExprList.class.toString());

        list_expressions = new ASTList<>();
        addExpressionToList(e);
}

@Override
public void refactorList(ASTNode n){
    list_expressions.putElementsInParents(this);
    for (Expression e :list_expressions){
        e.refactorList(this);
    }

}

    @Override
    public boolean isValidAssertion(){
        int assertiveExpressionCount = 0;
        for (Expression e : list_expressions) {
            if(e.isValidAssertion()){
                assertiveExpressionCount++;
            }
        }

        /*If more than one assertion, expression invalid ("forall x,y,z x=y, y=z") must be with an AND*/
        return assertiveExpressionCount == 1;
    }

    /**
     * @return 
     */
    @Override
    public ASTList<ExprVariable> getExternalVariable() {
        ASTList<ExprVariable> l = new ASTList<>();
        for(Expression e : list_expressions){
            ASTList<ExprVariable> result = e.getExternalVariable();
            if (result != null){
                l.addAll(result);
            }
        }
        return l;
    }

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public static ExprList create(Expression e){
        return new ExprList(e);
    }

    @Override
    public String toString(){
        /*String s = "[";
        for (Expression e : list_expressions){
            s+= e.toString()+",";
        }
        return s + "]";*/
        return "ExprList";
    }


}
