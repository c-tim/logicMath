package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

public class ExprListPointer extends Expression{


    List<ExprPointer> list_pointers;

    public void addExpressionToList(ExprPointer expr){
        list_pointers.add(expr);
    }
    public void addExpressionToListToStart(ExprPointer expr){
        list_pointers.addFirst(expr);
    }


    public ExprListPointer(ExprPointer e){
        super();
        list_pointers = new ArrayList<>();
        addExpressionToList(e);
    }


    public static ExprListPointer create(ExprPointer e){
        return new ExprListPointer(e);
    }

}
