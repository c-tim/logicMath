package compilation_steps.pkgSemantic;

import compilation.Printer;
import compilation.configPrint;
import compilation_steps.AST.*;

public class DisplayAstChildren extends  AstDefaultVisitor{



    // Count the depths of the node to display it with
    int depthLine = 0;

    configPrint p;

    // for code lisibility, call PIEDisplayClass with separator Depth (PIE : Print If Enabled = see configPrint)
    private void PIEClassWithDepth(String text) {
        Printer.PrintIfEnabled(text, Printer.currentConfig.printAstTreeChildren,depthLine);
    }


    public DisplayAstChildren(SemanticTree tree) {

        tree.getStartNode().accept(this);
    }


    private String simpleClassName (ASTNode n) {
        return n.getLabelClass().substring(n.getLabelClass().lastIndexOf('.') + 1);}

    @Override
    public void visit(ASTStartNode node) {
        Printer.PIEDisplayClass("Start Displaying AST Children Tree :\n");
        defaultVisit(node);
    }

    @Override
    public void defaultVisit(ASTNode n){
        PIEClassWithDepth(simpleClassName(n)+"\n");
        depthLine++;
        for(ASTNode child : n.getChildren()){
            defaultVisit(child);
        }
        depthLine--;
    }

    @Override
    public void visit(ASTList n){
        PIEClassWithDepth(simpleClassName(n)+"\n");



        depthLine++;
        for(ASTNode child : n.getChildren()){
            defaultVisit(child);
        }
        depthLine--;
    }

}
