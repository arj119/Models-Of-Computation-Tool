parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

prog: (instr)+ EOF;

register: REGISTER registerNum=INTEGER;
label: LABEL labelNum=INTEGER;

instr: id=label COLON HALT #haltInstr
| id=label COLON reg=register PLUS ARROW next=label  #plusInstr
| id=label COLON reg=register MINUS ARROW ifNotZJump=label COMMA ifZeroJump=label #minusInstr
| fst=instr SEMICOLON snd=instr #seqInstr
;
