package compilation_steps.AST;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ASTList<R extends ASTNode> extends ASTNode implements Iterable<R>{


    public List<R> getList_elements() {
        return list_elements;
    }

    /**
     * @param visitor
     */

    List<R> list_elements;

    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public ASTList() {
        super(ASTList.class.getName());
        list_elements=new ArrayList<>();

    }

    public void add(R n){
        list_elements.add(n);
        //addChild(n);
    }

    public void putElementsInParents(ASTNode parent){
        for (R element : list_elements){
            parent.addChild(element);
        }
        parent.getChildren().remove(this);
    }


    public void addAll(ASTList<R> l){
        list_elements.addAll(l.list_elements);
        /*for(R e : l){
            addChild(e);
        }*/
    }

    public R get(int i){
        return list_elements.get(i);
    }

    public int size(){
        return list_elements.size();
    }

    @Override
    public @NotNull Iterator<R> iterator() {
        return list_elements.iterator();
    }

    @Override
    public String toString() {
        return "ASTList";
    }
}
