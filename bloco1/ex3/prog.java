package bloco1.ex3;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class prog{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException{
        Map<String,Integer> numbDic = new HashMap<String,Integer>();

        File fileIn = new File("bloco1/ex3/numbers.txt");
        Scanner fIn = new Scanner(fileIn);

        while(fIn.hasNextLine()){
            String line = fIn.nextLine();
            String[] s = line.split(" - ");
            numbDic.put(s[1], Integer.parseInt(s[0]));
        }

        fIn.close();

        Stack<Integer> numbers = new Stack<Integer>();

        while(true){
            String[] s = in.nextLine().split("\\s+");

            for(int i = 0; i < s.length; i++){
                if(isKnownExtense(s[i],numbDic)){
                    numbers.add(numbDic.get(s[i]));
                }
            }

            printStack(numbers);

        }
    }

    private static boolean isKnownExtense(String s, Map<String,Integer> map){
        Set<String> keys = map.keySet();
        Object[] keyList = keys.toArray(); 

        for(int i = 0; i < keyList.length; i++){
            if(s.equalsIgnoreCase(String.valueOf(keyList[i]))){
                return true;
            }
        }

        return false;
    }

    private static void printStack(Stack<Integer> e){
        Iterator<Integer> temp1 = e.iterator();

        System.out.print("A list of numbers:");
        while(temp1.hasNext()){
            System.out.print(String.format(" %d", temp1.next()));
        }
        System.out.print("\n");

    }
}