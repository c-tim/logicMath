package compilation;

public enum compilSteps {

    LEXICAL(0), SYNTAX(1), SEMANTIC(2), MATHEMATICAL(3);

    final int level_compilation;

    compilSteps(int level) {
    level_compilation = level;
    }
}
