grammar SuffixCalculator;
program: stat* EOF;
stat: expr? NEWLINE;

expr  : first=expr second=expr op=('*'|'/'|'+'|'-') #fullExp
      | Number #Number
      ;

Number: [0-9]+('.'[0-9]+)?;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;