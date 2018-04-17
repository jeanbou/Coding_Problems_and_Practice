package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Problem080_Game_ofThrones_I__AnagramPlusPalindromeCheck__HashMap_Solution { // HashMap Solution 2*O(27) complexity

    static final int NO_OF_CHARS = 27;

    static HashMap<Character, Integer> hm = new HashMap<Character, Integer>(NO_OF_CHARS);
     
    private static void getCharCountArray(String str) {
        for (Character ch = 'a'; ch <= 'z';  ch++) { // initialization
            hm.put(ch,0);
        }
        for (int i = 0; i < str.length();  i++) { // counting
            Character ch = str.charAt(i);
            hm.put(ch,hm.get(ch)+1);
         }
    }
    
    @SuppressWarnings("unused")
	private static int getNumOfCharaterUsed() {
        int counter = 0;
        for (Character ch = 'a'; ch <= 'z';  ch++) {
            if ( hm.get(ch) > 0 ) {
                counter++;
            }
        }
        return counter;
    } // getNumOfCharaterUsed
    

    static String gameOfThrones(String s) {
        getCharCountArray(s);
        if ( s.length() % 2 == 1) {
            int counterOfODD = 0;
            for (Character ch = 'a'; ch <= 'z';  ch++) {
                if ( hm.get(ch) % 2 == 1 ) {
                    counterOfODD++;
                }
                if ( counterOfODD > 1) {
                    return "NO";
                }
            }
        }
        else {
            for (Character ch = 'a'; ch <= 'z';  ch++) {
                if ( hm.get(ch) % 2 == 1 ) {
                    return "NO";
                }
            }
        }        
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
