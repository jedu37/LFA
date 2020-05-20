package bloco1.ex6;
import java.util.*;
import java.io.*;

public class prog {
    
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException{
        System.out.println(String.format("%s %s", args[0],args[1]));
        Map<String,String> tradDic = dictInit(args[0]);

        File fileIn = new File(args[1]);
        Scanner fIn = new Scanner(fileIn);

        String translated = "";

        while(fIn.hasNextLine()){
            String line = fIn.nextLine();
            translated = translate(line,tradDic);
            System.out.print(translated);
        }
        fIn.close();
    }

    private static Map<String,String> dictInit(String fname) throws FileNotFoundException{
        Map<String,String> tempDic = new HashMap<String,String>();
        
        File fileIn = new File(fname);
        Scanner fIn = new Scanner(fileIn);

        while(fIn.hasNextLine()){
            String line = fIn.nextLine();
            String[] s = line.split("\\s+");
            tempDic.put(s[0], arrayToString(subArray(s, 1, s.length)));
        }

        fIn.close();

        return tempDic;
    }

    private static String arrayToString(String[]s){
        String n = "";

        for(int i = 0; i < s.length; i++){
            n = String.format("%s %s", n, s[i]);
        }

        n = n.trim();

        return n;
    }

    private static String translate(String l, Map<String,String> map){
        String translated = "";
        while(true){
            String[] s = l.split("\\s+");
            for(int i = 0; i < s.length; i++){
                if(isKnownWord(s[i], map)){
                    translated = String.format("%s %s", translated, map.get(s[i]));
                }
                else{
                    translated = String.format("%s %s", translated, s[i]);
                }
            }

            translated = String.format("%s\n", translated.trim());
            if(!(needTranslation(translated, map))){
                break;
            }

            l = translated;
            translated = "";

        }
        
        return translated;
    }

    private static boolean isKnownWord(String s, Map<String,String> map){
        Set<String> keys = map.keySet();
        Object[] keyList = keys.toArray(); 

        for(int i = 0; i < keyList.length; i++){
            if(s.equalsIgnoreCase(String.valueOf(keyList[i]))){
                return true;
            }
        }

        return false;
    }

    private static boolean needTranslation(String s, Map<String,String> map){
        int kwords = 0;

        String[] l = s.split("\\s+");

        for(int i = 0; i < l.length; i++){
            if(isKnownWord(l[i], map)){
                kwords++;
            }
        }

        if(kwords == 0){
            return false;
        }
        else{
            return true;
        }
    }

    public static<T> T[] subArray(T[] array, int beg, int end) {
		return Arrays.copyOfRange(array, beg, end);
	}
}