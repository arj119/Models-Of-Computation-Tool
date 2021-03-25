// Generated from ./BasicParser.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BasicParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BasicParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BasicParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(BasicParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#register}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegister(BasicParser.RegisterContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(BasicParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code haltInstr}
	 * labeled alternative in {@link BasicParser#instr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHaltInstr(BasicParser.HaltInstrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seqInstr}
	 * labeled alternative in {@link BasicParser#instr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqInstr(BasicParser.SeqInstrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusInstr}
	 * labeled alternative in {@link BasicParser#instr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusInstr(BasicParser.MinusInstrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusInstr}
	 * labeled alternative in {@link BasicParser#instr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusInstr(BasicParser.PlusInstrContext ctx);
}