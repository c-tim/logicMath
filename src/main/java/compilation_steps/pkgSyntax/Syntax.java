package compilation_steps.pkgSyntax;

import compilation.error.CompilerException;
import compilation_steps.AST.ASTNode;
import compilation_steps.AST.ASTStartNode;
import compilation_steps.cupParser;

public class Syntax {


    public ASTStartNode execute() throws CompilerException{
        final Object cupResult = new cupParser().execute();
		if (cupResult == null) {
			throw new CompilerException("Lexical or syntactic error");
		}
		if (!(cupResult instanceof ASTNode ast)) {
			throw new CompilerException("axiom is not an AstNode");
		}
		/*if (Debug.TREE) {
			Debug.log("= AST");
			Debug.log(ast.toPrint());
		}*/
		if (!(ast instanceof ASTStartNode axiom)) {
			throw new CompilerException("axiom is not an Axiom");
		}
		/*if (Debug.PRETTY) {
			Debug.log("= Pretty Print");
			Debug.log(new PrettyPrint(axiom).execute());
		}*/ 
		return axiom;
    }
}
