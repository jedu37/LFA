import org.antlr.v4.runtime.*;
import java.util.*;

public class Execute extends SuffixCalculatorBaseVisitor<String> {

   @Override public String visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitStat(SuffixCalculatorParser.StatContext ctx) {
	  String result = visit(ctx.expr());
	  System.out.print(String.format("result: %4.2f", Double.parseDouble(result)));
	  return null;
   }

   @Override public String visitNumber(SuffixCalculatorParser.NumberContext ctx) {
	String number = ctx.getText();
	return number;
   }

   @Override public String visitFullExp(SuffixCalculatorParser.FullExpContext ctx) {
	  String op = ctx.op.getText();
	  Double x = Double.parseDouble(visit(ctx.first));
	  Double y = Double.parseDouble(visit(ctx.second));
	  String result = String.format("%s", operation(op, x, y));
	  return result;
   }

   private static double operation(String op, double x, double y) {
		double result = 0;
		switch(op){
			case "+": result = x + y;
					break;
			case "-": result = x - y;
					break;
			case "*": result = x * y;
					break;
			case "/": result = x / y;
					break;
			default:
				System.out.print(String.format("\nERROR: Invalid Operator: '%s'", op));
				System.exit(0);
				break;
		}
		
		return result;
	}
}
