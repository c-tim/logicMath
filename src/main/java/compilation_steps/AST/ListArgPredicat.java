package compilation_steps.AST;

import compilation.Printer;

import java.util.ArrayList;
import java.util.List;

public class ListArgPredicat extends Expression{


    ASTList<ArgExpression> list_expression_pointers;
    ASTList<ArgVar> list_object_pointers;


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

        Printer.printError("cast type of ArgPointer");
    }

    }


    public ListArgPredicat(ArgPredicat e){
        super(ListArgPredicat.class.toString());
        list_expression_pointers = new ASTList<>();
        list_object_pointers = new ASTList<>();

        addExpressionToList(e);

    }

    public void refactorList(){
        list_object_pointers.putElementsInParents(this);
        list_expression_pointers.putElementsInParents(this);
    }


    public static ListArgPredicat create(ArgPredicat e){
        return new ListArgPredicat(e);
    }


}
