// Generated from ./BasicParser.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PLUS=2, MINUS=3, ARROW=4, HALT=5, START=6, REGISTER=7, LABEL=8, 
		COMMA=9, SEMICOLON=10, COLON=11, INTEGER=12;
	public static final int
		RULE_prog = 0, RULE_register = 1, RULE_label = 2, RULE_instr = 3;
	public static final String[] ruleNames = {
		"prog", "register", "label", "instr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'+'", "'-'", "'->'", "'HALT'", "'START'", "'R'", "'L'", "','", 
		"';'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "PLUS", "MINUS", "ARROW", "HALT", "START", "REGISTER", "LABEL", 
		"COMMA", "SEMICOLON", "COLON", "INTEGER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "BasicParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
		public List<InstrContext> instr() {
			return getRuleContexts(InstrContext.class);
		}
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8);
				instr(0);
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LABEL );
			setState(13);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegisterContext extends ParserRuleContext {
		public Token registerNum;
		public TerminalNode REGISTER() { return getToken(BasicParser.REGISTER, 0); }
		public TerminalNode INTEGER() { return getToken(BasicParser.INTEGER, 0); }
		public RegisterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitRegister(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegisterContext register() throws RecognitionException {
		RegisterContext _localctx = new RegisterContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			match(REGISTER);
			setState(16);
			((RegisterContext)_localctx).registerNum = match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public Token labelNum;
		public TerminalNode LABEL() { return getToken(BasicParser.LABEL, 0); }
		public TerminalNode INTEGER() { return getToken(BasicParser.INTEGER, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(LABEL);
			setState(19);
			((LabelContext)_localctx).labelNum = match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstrContext extends ParserRuleContext {
		public InstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr; }
	 
		public InstrContext() { }
		public void copyFrom(InstrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HaltInstrContext extends InstrContext {
		public LabelContext id;
		public TerminalNode COLON() { return getToken(BasicParser.COLON, 0); }
		public TerminalNode HALT() { return getToken(BasicParser.HALT, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public HaltInstrContext(InstrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitHaltInstr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SeqInstrContext extends InstrContext {
		public InstrContext fst;
		public InstrContext snd;
		public TerminalNode SEMICOLON() { return getToken(BasicParser.SEMICOLON, 0); }
		public List<InstrContext> instr() {
			return getRuleContexts(InstrContext.class);
		}
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
		}
		public SeqInstrContext(InstrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSeqInstr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusInstrContext extends InstrContext {
		public LabelContext id;
		public RegisterContext reg;
		public LabelContext ifNotZJump;
		public LabelContext ifZeroJump;
		public TerminalNode COLON() { return getToken(BasicParser.COLON, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode ARROW() { return getToken(BasicParser.ARROW, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public MinusInstrContext(InstrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitMinusInstr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusInstrContext extends InstrContext {
		public LabelContext id;
		public RegisterContext reg;
		public LabelContext next;
		public TerminalNode COLON() { return getToken(BasicParser.COLON, 0); }
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public TerminalNode ARROW() { return getToken(BasicParser.ARROW, 0); }
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public PlusInstrContext(InstrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPlusInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrContext instr() throws RecognitionException {
		return instr(0);
	}

	private InstrContext instr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InstrContext _localctx = new InstrContext(_ctx, _parentState);
		InstrContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_instr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new HaltInstrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(22);
				((HaltInstrContext)_localctx).id = label();
				setState(23);
				match(COLON);
				setState(24);
				match(HALT);
				}
				break;
			case 2:
				{
				_localctx = new PlusInstrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				((PlusInstrContext)_localctx).id = label();
				setState(27);
				match(COLON);
				setState(28);
				((PlusInstrContext)_localctx).reg = register();
				setState(29);
				match(PLUS);
				setState(30);
				match(ARROW);
				setState(31);
				((PlusInstrContext)_localctx).next = label();
				}
				break;
			case 3:
				{
				_localctx = new MinusInstrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				((MinusInstrContext)_localctx).id = label();
				setState(34);
				match(COLON);
				setState(35);
				((MinusInstrContext)_localctx).reg = register();
				setState(36);
				match(MINUS);
				setState(37);
				match(ARROW);
				setState(38);
				((MinusInstrContext)_localctx).ifNotZJump = label();
				setState(39);
				match(COMMA);
				setState(40);
				((MinusInstrContext)_localctx).ifZeroJump = label();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SeqInstrContext(new InstrContext(_parentctx, _parentState));
					((SeqInstrContext)_localctx).fst = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_instr);
					setState(44);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(45);
					match(SEMICOLON);
					setState(46);
					((SeqInstrContext)_localctx).snd = instr(2);
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return instr_sempred((InstrContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean instr_sempred(InstrContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16\67\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\6\2\f\n\2\r\2\16\2\r\3\2\3\2\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5-\n\5\3\5\3\5\3\5\7\5\62\n\5\f\5\16\5\65\13"+
		"\5\3\5\2\3\b\6\2\4\6\b\2\2\2\66\2\13\3\2\2\2\4\21\3\2\2\2\6\24\3\2\2\2"+
		"\b,\3\2\2\2\n\f\5\b\5\2\13\n\3\2\2\2\f\r\3\2\2\2\r\13\3\2\2\2\r\16\3\2"+
		"\2\2\16\17\3\2\2\2\17\20\7\2\2\3\20\3\3\2\2\2\21\22\7\t\2\2\22\23\7\16"+
		"\2\2\23\5\3\2\2\2\24\25\7\n\2\2\25\26\7\16\2\2\26\7\3\2\2\2\27\30\b\5"+
		"\1\2\30\31\5\6\4\2\31\32\7\r\2\2\32\33\7\7\2\2\33-\3\2\2\2\34\35\5\6\4"+
		"\2\35\36\7\r\2\2\36\37\5\4\3\2\37 \7\4\2\2 !\7\6\2\2!\"\5\6\4\2\"-\3\2"+
		"\2\2#$\5\6\4\2$%\7\r\2\2%&\5\4\3\2&\'\7\5\2\2\'(\7\6\2\2()\5\6\4\2)*\7"+
		"\13\2\2*+\5\6\4\2+-\3\2\2\2,\27\3\2\2\2,\34\3\2\2\2,#\3\2\2\2-\63\3\2"+
		"\2\2./\f\3\2\2/\60\7\f\2\2\60\62\5\b\5\4\61.\3\2\2\2\62\65\3\2\2\2\63"+
		"\61\3\2\2\2\63\64\3\2\2\2\64\t\3\2\2\2\65\63\3\2\2\2\5\r,\63";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}