package compilation_steps.AST;

import java.util.ArrayList;
import java.util.List;

public class TheoryBody extends ASTNode{

    List<Proposition> list_proposition;
    List<Definition> list_definition;

    /**
     * @param visitor
     */
    @Override
    public void accept(AstDefaultVisitor visitor) {
        visitor.visit(this);
    }

    public TheoryBody(){
        super(TheoryBody.class.getName());
        list_proposition = new ArrayList<>();
        list_definition = new ArrayList<>();
    }


    public void addProposition(final Proposition proposition){
        list_proposition.add(proposition);
    }

    public void addDefinition(final Definition definition){
        list_definition.add(definition);
    }

    public static TheoryBody create(){
        return new TheoryBody();
    }
}
