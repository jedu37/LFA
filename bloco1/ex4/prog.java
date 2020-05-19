package bloco1.ex4;
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
            String l = in.nextLine();
            String[] s = l.split("\\s+");

            for(int i = 0; i < s.length; i++){
                if(isKnownExtense(s[i],numbDic)){
                    if(s[i].equalsIgnoreCase("hundred") || s[i].equalsIgnoreCase("thousand") || s[i].equalsIgnoreCase("million")){
                        int n = numbers.pop();
                        int m = numbDic.get(s[i]);
                        int newVal = n*m;
                        numbers.add(newVal);
                    }
                    else{
                        numbers.add(numbDic.get(s[i]));
                    }
                }
                
                String[] c = s[i].split("-");

                if(c.length == 2){
                    if(isKnownExtense(c[0],numbDic) && isKnownExtense(c[1], numbDic)){
                        int n = numbDic.get(c[0]);
                        int m = numbDic.get(c[1]);
                        int newVal = n+m;
                        numbers.add(newVal);
                    }
                }
            }

            printValue(numbers, l);
            numbers.clear();

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

    private static void printValue(Stack<Integer> e, String s){
        Iterator<Integer> temp1 = e.iterator();
        int val = 0;
        
        while(temp1.hasNext()){
            val = val + temp1.next();
        }
        
        System.out.print(String.format("\"%s\"--> %d\n", s,val));
    }
}