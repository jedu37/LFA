import org.antlr.v4.runtime.*;

public class Interpreter extends CalculatorBaseVisitor<String> {

   @Override public String visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitStat(CalculatorParser.StatContext ctx) {
      String result = visit(ctx.expr());
	   System.out.print(String.format("result: %d\n", Integer.parseInt(result)));
	   return null;
   }

   @Override public String visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      String op = ctx.op.getText();
      int x = Integer.parseInt(visit(ctx.first));
      int y = Integer.parseInt(visit(ctx.second));
      return String.format("%d",operation(op, x, y));
   }

   @Override public String visitExprPositive(CalculatorParser.ExprPositiveContext ctx) {
      int num = Integer.parseInt(visit(ctx.expr()));
      return String.format("%d", num);
   }

   @Override public String visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public String visitExprNegative(CalculatorParser.ExprNegativeContext ctx) {
      int num = Integer.parseInt(visit(ctx.expr()));
      return String.format("-%d", num);
   }

   @Override public String visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return ctx.getText();
   }

   @Override public String visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      String op = ctx.op.getText();
      int x = Integer.parseInt(visit(ctx.first));
      int y = Integer.parseInt(visit(ctx.second));
      return String.format("%d",operation(op, x, y));
   }

   private static int operation(String op, int x, int y) {
		int result = 0;
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
