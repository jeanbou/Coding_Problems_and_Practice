package hackerRank_JavaProblemSolving;

import java.util.*;

public class Problem105_StringsXOR_Debug_PlusPlus {

	// More efficient proposal
	public static String stringsXOREfficientSolution(String s, String t) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString().trim();        
    } // stringsXOREfficientSolution
	
	// Debugged and submitted
	public static String stringsXOR(String s, String t) {
        String res = new String("");
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(i))
                res += "0";
            else
                res += "1";
        }

        return res;
    }

    public static void main(String[] args) {

        String s, t;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        t = in.nextLine();
        System.out.println(stringsXOR(s, t));

    }

}
