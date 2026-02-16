package compilation_steps.pkgSemantic.symbols;


import compilation.Printer;
import compilation_steps.AST.Theory;

//Attemet to clean code because of the number of tables
public class symbolTableManager {

    public int getNumber_tables() {
        return number_tables;
    }

    public enum  enumTableInfoType{
        THEORY(0,InfoTheory.class.toString() ), PROPOSITION(1,InfoProposition.class.toString()),DEFINITION(2, InfoDefinition.class.toString()), EXPRESSION(3, InfoExpression.class.toString()),ISTERM(4, InfoIsTerm.class.toString()), OBJECT(5, InfoObject.class.toString());
        final int number_element;
        final String InfoClass;
        //final SymbolTable<String, ?> linked_element;
        enumTableInfoType(int i, String info){
            number_element = i;
            InfoClass = info;
        }
    }


    private final SimpleSymbolTable< InfoObject> table_objects;
    private final SimpleSymbolTable< InfoProposition> table_propositions;
    private final SimpleSymbolTable< InfoDefinition> table_definitions;
    private final SimpleSymbolTable< InfoExpression> table_expressions;
    private final SimpleSymbolTable< InfoIsTerm> table_isTerm;
    private final SimpleSymbolTable< InfoTheory> table_theory;
    private final int number_tables = 6;
    private static enumTableInfoType[] list_enums = new enumTableInfoType[6];
    SymbolTable<String, ? extends Info>[] list_tables;
    public symbolTableManager(       SimpleSymbolTable< InfoObject> _table_objects,
                                          SimpleSymbolTable< InfoProposition> _table_propositions,
                                          SimpleSymbolTable< InfoDefinition> _table_definitions,
                                          SimpleSymbolTable< InfoExpression> _table_expressions,
                                          SimpleSymbolTable< InfoIsTerm> _table_isTerm,
                                          SimpleSymbolTable< InfoTheory> _table_theory){
          table_objects= _table_objects;
          table_propositions= _table_propositions;
          table_definitions= _table_definitions;
          table_expressions= _table_expressions;
          table_isTerm= _table_isTerm;
          table_theory= _table_theory;
        list_tables = new SimpleSymbolTable<?>[6];
        list_tables[enumTableInfoType.THEORY.number_element] = _table_theory;
        list_tables[enumTableInfoType.PROPOSITION.number_element] = _table_propositions;
        list_tables[enumTableInfoType.DEFINITION.number_element] = _table_definitions;
        list_tables[enumTableInfoType.EXPRESSION.number_element] = _table_expressions;
        list_tables[enumTableInfoType.ISTERM.number_element] = _table_isTerm;
        list_tables[enumTableInfoType.OBJECT.number_element] = _table_objects;

    for(enumTableInfoType e : enumTableInfoType.values()){
        list_enums[e.number_element] = e;
    }

    }

    public SymbolTable<String, ? extends Info> getTable(int i){
        return list_tables[i];
    }

    public SymbolTable<String, ? extends Info> getTableWithElementClass(Info e){
        for (int i = 0; i < getNumber_tables(); i++) {
            if (e.getClass().toString().equals(list_enums[i].InfoClass)){
                return list_tables[i];
            }
        }
        Printer.printError("Infotype not found for element of type "+e.getClass().toString());
        return null;

    }

    public Info insertElementIntoLinkedTable(Info e) {

            if(e instanceof InfoTheory) {
                return table_theory.insert(e.getName(),  (InfoTheory)e);
            }else if(e instanceof InfoProposition) {
                return table_propositions.insert(e.getName(),  (InfoProposition)e);
            }else if(e instanceof InfoDefinition) {
                return table_definitions.insert(e.getName(),  (InfoDefinition)e);
            }else if(e instanceof InfoExpression) {
                return table_expressions.insert(e.getName(),  (InfoExpression)e);
            }else if(e instanceof InfoIsTerm) {
                return table_isTerm.insert(e.getName(),  (InfoIsTerm)e);
            }else if(e instanceof InfoObject) {
                return table_objects.insert(e.getName(),  (InfoObject)e);
            }
            Printer.printError("Type of info not found "+e.getName().toString());
            return null;
    }


    /*public Info insertElementInItsType(Info e){
        getTableWithElementClass(e).insert(e.getName(), e);
        if (isNameAlreadyTakenInCurrentScope(e.getName())){
            return this.table_theory.insert(e.getName(), e);
        }

        return null;
    }*/




}
