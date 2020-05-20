// Generated from SuffixCalculator.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SuffixCalculatorParser}.
 */
public interface SuffixCalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SuffixCalculatorParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SuffixCalculatorParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SuffixCalculatorParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SuffixCalculatorParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SuffixCalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(SuffixCalculatorParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SuffixCalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(SuffixCalculatorParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link SuffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(SuffixCalculatorParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link SuffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(SuffixCalculatorParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullExp}
	 * labeled alternative in {@link SuffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFullExp(SuffixCalculatorParser.FullExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullExp}
	 * labeled alternative in {@link SuffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFullExp(SuffixCalculatorParser.FullExpContext ctx);
}