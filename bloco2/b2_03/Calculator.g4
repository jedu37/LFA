grammar Calculator;
program: stat* EOF;
stat: expr? NEWLINE;

expr:   '-'expr                                  #ExprNegative
        | '+'expr                                #ExprPositive  
        |first=expr op=('*'|'/'|'%') second=expr #ExprMultDivMod
        | first=expr op=('+'|'-') second=expr    #ExprAddSub
        | Integer                                #ExprInteger
        | '(' expr ')'                           #ExprParent
        | '-'expr                                #ExprNegative
        ;

Integer: [0-9]+; // implement with 
NEWLINE: '\r' ? '\n' ;
WS: [ \t]+ -> skip ;
COMMENT: '#' .*? '\n' ->skip;