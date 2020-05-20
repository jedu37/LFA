package bloco1.ex7;
import java.util.*;

public class prog {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ExpressionTree tree = new ExpressionTree();

        while(true){
            String l = in.nextLine();
            tree.addData(l);
            System.out.print(String.format("%s = %d\n\n", tree.Infix(),tree.eval()));
            tree.clear();
        }
    }
}