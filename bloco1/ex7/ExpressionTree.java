package bloco1.ex7;
import java.util.*;

public class ExpressionTree {
    private Node root;

    public ExpressionTree() {}

    public void clear() {
        root = null;
    }

    public void addData(String l) {

        String[] s = l.split("\\s+");

        if (isOp(s[0])) {
            this.root = addData(s);

        } else {
            System.out.println("erro");
        }

    }

    private Node addData(String[] s) {
        Node res = null;

        if (isNumeric(s[0])) {
            res = new Node(s[0], type.NUM);

        } else if (isOp(s[0])) {

            res = new Node(s[0], type.OP);

            res.left = addData( subArray(s, 1, s.length));
            res.right = addData( subArray(s, 2, s.length));

        } else {
            System.out.println("oops");
        }

        return res;
    }

    public double eval() {
        return value(root);
    }

    public String inFix(){
        return String.format("%s", root.toString());
    }

    private double value(Node n) {
        double res =0;
        if (n.tipo() == type.OP) {
            double v1 = value(n.left());
            double v2 = value(n.right());

            switch (n.value()) {
                case "+":
                    res = v1 + v2;
                    break;

                case "-":
                    res = v1 - v2;
                    break;

                case "*":
                    res = v1 * v2;
                    break;

                case "/":
                    res = v1 / v2;
                    break;
            }

        }
        else if(n.tipo() == type.NUM){
            res = Double.parseDouble(n.value());
        }

        else {
            System.out.println("oops");
        }

        return res;
    }

    private static boolean isOp(String s) {
        if(s.equals("+") | s.equals("-") | s.equals("*") | s.equals("/") ){
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

    public static <T> T[] subArray(T[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end);
    }

}