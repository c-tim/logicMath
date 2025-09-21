package compilation_steps.AST;

import java.util.HashMap;
import java.util.List;

public class Statement extends ASTNode{

    Expression linked_expression;

    //TODO deals with the list establish and implies

    // The statement that established this statement, they are group of Statement
    List<List<Statement>> establishedBy;

    // each List of Statement establish with this statement, the Statement value of the HashMap
    HashMap<List<Statement>, Statement> implies;

    public Statement(Expression _linked_expression) {
        super(Statement.class.getName());
        linked_expression = _linked_expression;
    }

    /**
     * @param visitor
     */
    @Override
    public void accept(AstDefaultVisitor visitor) {
    visitor.visit(this);
    }

    public static Statement create(Expression _linked_expression){
        return new Statement(_linked_expression);
    }

}
