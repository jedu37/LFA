package bloco1.ex3;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class prog{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        Map<String,Integer> numbDic = new HashMap<String,Integer>();
        try {
            numbDic = dicInit(args[1]);
        } catch (Exception e) {
            System.out.print(String.format("\nERROR: Invalid File"));
            System.exit(0);
        }

        while(true){
            
        }
    }

    private static Map<String,Integer> dicInit(String fname) throws FileNotFoundException{
        Map<String,Integer> tempDic =new HashMap<String,Integer>();
        
        File fIn = new File(fname);
        Scanner data = new Scanner(fIn);

        while(data.hasNextLine()){
            String[] s = in.nextLine().split("\t");
            tempDic.put(s[1],Integer.parseInt(s[0]));
        }
        return tempDic;
    }
}