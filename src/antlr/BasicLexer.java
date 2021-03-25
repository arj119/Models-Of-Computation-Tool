// Generated from ./BasicLexer.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PLUS=2, MINUS=3, ARROW=4, HALT=5, START=6, REGISTER=7, LABEL=8, 
		COMMA=9, SEMICOLON=10, COLON=11, INTEGER=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "PLUS", "MINUS", "ARROW", "HALT", "START", "REGISTER", "LABEL", 
		"COMMA", "SEMICOLON", "COLON", "DIGIT", "INTEGER"
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


	public BasicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BasicLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16G\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\6\2\37\n\2\r\2\16\2 \3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\6\16D\n\16\r\16\16\16"+
		"E\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\2\33\16"+
		"\3\2\3\4\2\13\f\"\"\2G\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\33\3\2\2\2\3\36\3\2\2\2\5$\3\2\2\2\7&\3\2\2\2"+
		"\t(\3\2\2\2\13+\3\2\2\2\r\60\3\2\2\2\17\66\3\2\2\2\218\3\2\2\2\23:\3\2"+
		"\2\2\25<\3\2\2\2\27>\3\2\2\2\31@\3\2\2\2\33C\3\2\2\2\35\37\t\2\2\2\36"+
		"\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\b\2\2\2#\4"+
		"\3\2\2\2$%\7-\2\2%\6\3\2\2\2&\'\7/\2\2\'\b\3\2\2\2()\7/\2\2)*\7@\2\2*"+
		"\n\3\2\2\2+,\7J\2\2,-\7C\2\2-.\7N\2\2./\7V\2\2/\f\3\2\2\2\60\61\7U\2\2"+
		"\61\62\7V\2\2\62\63\7C\2\2\63\64\7T\2\2\64\65\7V\2\2\65\16\3\2\2\2\66"+
		"\67\7T\2\2\67\20\3\2\2\289\7N\2\29\22\3\2\2\2:;\7.\2\2;\24\3\2\2\2<=\7"+
		"=\2\2=\26\3\2\2\2>?\7<\2\2?\30\3\2\2\2@A\4\62;\2A\32\3\2\2\2BD\5\31\r"+
		"\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\34\3\2\2\2\5\2 E\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}