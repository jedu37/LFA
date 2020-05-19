package bloco1.ex5;
import java.util.*;

public class prog {
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        Map<String,Double> varMap = new HashMap<String,Double>();

        while(true){
            String l = in.nextLine();
            String[] s = l.split("\\s+");

            if(isKnownVar(s[0], varMap) || !(isNumeric(s[0]))){
                if(s[1].equalsIgnoreCase("=")){

                    double result = 0;

                    if(s.length == 3){
                        if(isKnownVar(s[2], varMap)){
                            result = varMap.get(s[2]);
                        }
                        else if(isNumeric(s[2])){
                            result = Double.parseDouble(s[2]);
                        }
                    }
                    else if (s.length > 3 && s.length%2 != 0){
                        result = operation(subArray(s, 2, s.length), varMap);
                    }

                    varMap.put(s[0],result);
                }
                else{
                    double result = operation(s, varMap);
                    System.out.print(String.format("%s = %4.2f\n", l,result));

                }
            }
            else{
                double result = operation(s, varMap);
                System.out.print(String.format("%s = %4.2f\n", l,result));
            }

        }
    }

    private static double operation(String[] s, Map<String,Double> map) {
        double x = 0;
        double y = 0;
        double result = 0;
        String op;

        if(isKnownVar(s[0], map)){
            x = map.get(s[0]);
        }
        else if(isNumeric(s[0])){
            x = Double.parseDouble(s[0]);
        }

        op = s[1];

        if(s.length == 3){
            if(isKnownVar(s[2], map)){
                y = map.get(s[2]);
            }
            else if(isNumeric(s[2])){
                y = Double.parseDouble(s[2]);
            }

        }
        else if(s.length >3 && s.length%2!=0){
            y = operation(subArray(s, 2, s.length), map);

        }
        else{
            return 0;
        }

		switch(op){
            case "+":
                    result = x + y;
					break;
			case "-": result = x - y;
					break;
			case "*": result = x * y;
					break;
			case "/": result = x / y;
					break;
			default:
				break;
        }
        
        return result;
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

    private static boolean isKnownVar(String s, Map<String,Double> map){
        Set<String> keys = map.keySet();
        Object[] keyList = keys.toArray(); 

        for(int i = 0; i < keyList.length; i++){
            if(s.equalsIgnoreCase(String.valueOf(keyList[i]))){
                return true;
            }
        }

        return false;
    }

    public static<T> T[] subArray(T[] array, int beg, int end) {
		return Arrays.copyOfRange(array, beg, end);
	}

}