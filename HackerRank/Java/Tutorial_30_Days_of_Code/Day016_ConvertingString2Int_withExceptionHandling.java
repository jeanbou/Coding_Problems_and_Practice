package hackerRank_Java30DaysOfCode;

import java.util.*;

public class Day016_ConvertingString2Int_withExceptionHandling {

	public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        String S = in.next();
        try {
            // Converting s to Integer
            int aConverted = Integer.parseInt(S);
            System.out.print(aConverted);
        }
        catch(NumberFormatException e) {
            //e.printStackTrace();
            System.out.println("Bad String");
        }
    }
}
