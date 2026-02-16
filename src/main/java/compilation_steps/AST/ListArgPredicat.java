package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

public class ListArgPredicat extends Expression{


    List<ArgExpression> list_expression_pointers;
    List<ArgVar> list_object_pointers;


    private void addExpressionPointerToList(ArgExpression expr){
        list_expression_pointers.add(expr);
    }
    private void addVarPlaceHolderToList(ArgVar expr){
        list_object_pointers.add(expr);
    }

    public void addExpressionToList(ArgPredicat expr){
    if (expr.getClass() == ArgVar.class){
         addVarPlaceHolderToList((ArgVar) expr);
    } else if (expr.getClass() == ArgExpression.class){
            addExpressionPointerToList((ArgExpression) expr);
    } else{

        System.out.println("ERROR on cast type of ArgPointer");
    }

    }


    public ListArgPredicat(ArgPredicat e){
        super();
        list_expression_pointers = new ArrayList<>();
        list_object_pointers = new ArrayList<>();

        addExpressionToList(e);
    }


    public static ListArgPredicat create(ArgPredicat e){
        return new ListArgPredicat(e);
    }


}
