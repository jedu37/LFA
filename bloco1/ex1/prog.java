package bloco1.ex1;
import java.util.*;

public class prog{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Operation (number op number):");
        double x = 0;
        try {
            x = in.nextDouble();
        }catch(Exception e) {
            System.out.print("\nERROR:Read Number Failure");
            System.exit(0);
        }
        String op = in.next();
        double y = 0;
        try {
            y = in.nextDouble();
        }catch(Exception e) {
            System.out.print("\nERROR:Read Number Failure");
            System.exit(0);
        }
        
        double result = operation(op,x,y);
        
        System.out.print(String.format("%.4f %s %.4f = %.4f\n", x,op,y,result));
        
        System.exit(0);
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