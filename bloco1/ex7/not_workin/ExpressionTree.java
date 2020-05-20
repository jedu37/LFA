package bloco1.ex7;
import java.util.*;

public class ExpressionTree {
    private Node root;
    private String input;

    public ExpressionTree(){
        root = null;
        input = null;
    }

    public void clear(){
        root = null;
    }

    public void addData(String l){
        this.input = l;

        String[] s = l.split("\\s+");

        if(isNumeric(s[0])){
            this.root = new Node(s[0], type.NUM);
        }
        else if(isOp(s[0])){
            SAPNR temp = addLeave(s, root);
            
            this.root = temp.n;


        }
    }

    public int eval(){
        int result;
        if(isNumeric(root.value())){
            result = Integer.parseInt(root.value());
        }
        else{
            result = calculate(root);
        }
        return result;
    }

    private int calculate(Node n){
        int result;

        if(n.left().hasLeaves() && n.right().hasLeaves()){
            result = operation(n.value(), calculate(n.right()), calculate(n.left()));
        }
        else if (n.left().hasLeaves()){
            int x = Integer.parseInt(n.right().value());
            result = operation(n.value(), x, calculate(n.left()));
        }
        else if (n.right().hasLeaves()){
            int y = Integer.parseInt(n.left().value());
            result = operation(n.value(), calculate(n.right()), y);
        }
        else{
            int x = Integer.parseInt(n.right().value());
            int y = Integer.parseInt(n.left().value());

            result = operation(n.value(), x,y);
        }

        return result;
    }

    private static SAPNR addLeave(String[] s, Node n){
        if(isNumeric(s[0])){
            n = new Node(s[0], type.NUM);
            return new SAPNR(subArray(s, 1, s.length),n);
        }
        else if(isOp(s[0])){
            n = new Node(s[0], type.OP);

            SAPNR temp = addLeave(subArray(s, 1, s.length), n.right());

            n.setRight(temp.n.value(), temp.n.tipo());

            temp = addLeave(temp.s, n.left());

            n.setLeft(temp.n.value(), temp.n.tipo());

            return new SAPNR(temp.s,n);
        }
        else{
            System.out.print("Invalid data Result is null");
            n = new Node(null, type.OP);
            return null;
        }
    }

    public void printInfix(){
        System.out.print(root.toString());
    }

    public String Infix(){
        return String.format("%s",root.toString());
    }

    private static boolean isOp(String s){
        if(s.equalsIgnoreCase("*") || s.equalsIgnoreCase("/") || s.equalsIgnoreCase("-") || s.equalsIgnoreCase("+") ){
            return true;
        }
        return false;
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

    public static<T> T[] subArray(T[] array, int beg, int end) {
		return Arrays.copyOfRange(array, beg, end);
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

    /*public createPrefix(s){
        if(in.hasNextDouble()){
        
        }
        else
        {
        
        }
    }*/

}