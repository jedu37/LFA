package bloco1.ex2;
import java.util.*;

public class prog {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Stack<Double> numbers = new Stack<Double>();

        while(true){
            String dataIn = in.nextLine();

            String[] ind = dataIn.split("\\s+");

            for(int i = 0; i < ind.length ; i++){
                if(isNumeric(ind[i])){
                    numbers.add(Double.parseDouble(ind[i]));
                    printStack(numbers);
                }
                else if(isOp(ind[i])){
                    if(numbers.size()<2){
                        System.out.print(String.format("\nERROR: Not Enough Numbers"));
                        System.exit(0);
                    }
                    
                    Double y = numbers.pop();
                    Double x = numbers.pop();
                    numbers.add(operation(ind[i], x, y));
                    printStack(numbers);     
                }
                else{
                    System.out.print(String.format("\nERROR: Invalid Input"));
                    System.exit(0);
                }
                
            }
        }
        
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isOp(String op){
        if (op == null) {
            return false;
        }
        else if(op.equalsIgnoreCase("*")){
            return true;
        }
        else if(op.equalsIgnoreCase("+")){
            return true;
        }
        else if(op.equalsIgnoreCase("-")){
            return true;
        }
        else if(op.equalsIgnoreCase("/")){
            return true;
        }
        return false;
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
    
    private static void printStack(Stack<Double> e){
        Iterator<Double> temp1 = e.iterator();

        System.out.print("Stack:");
        while(temp1.hasNext()){
            System.out.print(String.format("[%4.2f]", temp1.next()));
        }
        System.out.print("\n");

    }
}