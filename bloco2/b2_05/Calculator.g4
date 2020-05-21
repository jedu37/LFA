grammar Calculator;
program: stat* EOF;

stat: assignment? NEWLINE #StatAssign
     | expr? NEWLINE #StatExpr;

assignment: id=ID '=' expr;

expr:   '-'expr                                  #ExprNegative
        | '+'expr                                #ExprPositive  
        | first=expr op=('*'|'/'|'%') second=expr #ExprMultDivMod
        | first=expr op=('+'|'-') second=expr    #ExprAddSub
        | Integer                                #ExprInteger
        | ID                                     #ExprID
        | '(' expr ')'                           #ExprParent
        ;

ID: [a-zA-Z_]+;
Integer: [0-9]+; // implement with 
NEWLINE: '\r' ? '\n' ;
WS: [ \t]+ -> skip ;
COMMENT: '#' .*? '\n' ->skip;