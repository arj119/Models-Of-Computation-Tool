lexer grammar BasicLexer;

WS: [ \t\n]+ -> skip ;

//operators
PLUS: '+' ;
MINUS: '-' ;
ARROW: '->';
HALT: 'HALT';
START: 'START';
REGISTER: 'R';
LABEL: 'L';

//Separators
COMMA: ',';
SEMICOLON: ';';
COLON: ':';

//numbers
fragment DIGIT: '0'..'9' ; 

INTEGER: DIGIT+ ;





