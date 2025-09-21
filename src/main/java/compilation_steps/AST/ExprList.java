package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

public class ExprList extends Expression{

    List<Expression> list_expressions;

    public void addExpressionToList(Expression expr){
        list_expressions.add(expr);
    }
    public void addExpressionToListToStart(Expression expr){
        list_expressions.addFirst(expr);
    }


    public ExprList(Expression e){
        super();
        list_expressions = new ArrayList<>();
        addExpressionToList(e);
}

    @Override
    public boolean isValidAssertion(){
        int assertiveExpressionCount = 0;
        for (Expression e : list_expressions) {
            if(e.isValidAssertion()){
                assertiveExpressionCount++;
            }
        }

        /*If more than one assertion, expression invalid ("forall x,y,z x=y, y=z") must be an AND*/
        return assertiveExpressionCount == 1;
    }

    /**
     * @return 
     */
    @Override
    public List<ExprVariable> getExternalVariable() {
        List<ExprVariable> l = new ArrayList<>();
        for(Expression e : list_expressions){
            List<ExprVariable> result = e.getExternalVariable();
            if (result != null){
                l.addAll(result);
            }
        }
        return l;
    }

    public static ExprList create(Expression e){
        return new ExprList(e);
    }

    

}
