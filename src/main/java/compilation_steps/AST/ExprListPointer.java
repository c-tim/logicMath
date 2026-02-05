package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

public class ExprListPointer extends Expression{


    List<ArgPointer> list_pointers;

    public void addExpressionToList(ArgPointer expr){
        list_pointers.add(expr);
    }
    public void addExpressionToListToStart(ArgPointer expr){
        list_pointers.addFirst(expr);
    }


    public ExprListPointer(ArgPointer e){
        super();
        list_pointers = new ArrayList<>();
        addExpressionToList(e);
    }


    public static ExprListPointer create(ArgPointer e){
        return new ExprListPointer(e);
    }

}
