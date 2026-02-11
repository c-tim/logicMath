package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

public class ListExprArgPointer extends Expression{


    List<ExpressionPointer> list_expression_pointers;
    List<ExprVarPlaceHolder> list_object_pointers;


    private void addExpressionPointerToList(ExpressionPointer expr){
        list_expression_pointers.add(expr);
    }
    private void addVarPlaceHolderToList(ExprVarPlaceHolder expr){
        list_object_pointers.add(expr);
    }

    public void addExpressionToList(ArgPointer expr){
    if (expr.getClass() == ExprVarPlaceHolder.class){
         addVarPlaceHolderToList((ExprVarPlaceHolder) expr);
    } else if (expr.getClass() == ExpressionPointer.class){
            addExpressionPointerToList((ExpressionPointer) expr);
    } else{

        System.out.println("ERROR on cast type of ArgPointer");
    }

    }


    public ListExprArgPointer(ArgPointer e){
        super();
        list_expression_pointers = new ArrayList<>();
        list_object_pointers = new ArrayList<>();

        addExpressionToList(e);
    }


    public static ListExprArgPointer create(ArgPointer e){
        return new ListExprArgPointer(e);
    }


}
