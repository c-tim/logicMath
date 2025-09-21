package compilation_steps.pkgSemantic;

import compilation.Printer;
import compilation_steps.AST.*;

public class DisplayClass extends AstDefaultVisitor {

    //Display the depths in the Printer
    final String charSeparator = "--";

    // Count the depths of the node to display it with
    int depthLine = 0;

    // for code lisibility, call PIEDisplayClass with separator Depth (PIE : Print If Enabled = see configPrint)
    private void PIEClassWithDepth(String text){
        Printer.PIEDisplayClass(withSeparator(text));
    }

    public String withSeparator(String text){
       String returnedText = "";
        for (int i = 0; i < depthLine; i++) {
            returnedText+=charSeparator;
        }
        return returnedText + text;
    }

    public DisplayClass(SemanticTree tree){
        tree.getStartNode().accept(this);
    }

    @Override
    public void visit(ASTStartNode node) {
        Printer.PIEDisplayClass("Start Displaying AST Class :\n");
        defaultVisit(node);
    }
    @Override
    public void visit(ASTList node) {
        defaultVisit(node);
    }
    @Override
    public void visit(Proposition node) {
        Printer.PIEDisplayClass(node.toString()+"\n");
        defaultVisit(node);
    }
    @Override
    public void visit(Theory node) {
        PIEClassWithDepth(node.toString() + " {\n");
        depthLine++;
        defaultVisit(node);
        depthLine--;
        PIEClassWithDepth(" }\n");
    }
    @Override
    public void visit(Expression node) {
        PIEClassWithDepth(node.toString());
        defaultVisit(node);
    }
    @Override
    public void visit(Definition node) {
        PIEClassWithDepth(node.toString() + " {\n");
        depthLine++;
        defaultVisit(node);
        depthLine--;
        PIEClassWithDepth(" }\n");
    }
    @Override
    public void visit(Property node) {
        defaultVisit(node);
    }
    @Override
    public void visit(objectType node) {
        defaultVisit(node);
    }
    @Override
    public void visit(Ident node){
        defaultVisit(node);
    }
    @Override
    public void visit(TheoryBody node){
        defaultVisit(node);
    }
}
