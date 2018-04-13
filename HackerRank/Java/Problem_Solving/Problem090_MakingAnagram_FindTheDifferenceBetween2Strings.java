package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Problem090_MakingAnagram_FindTheDifferenceBetween2Strings {
    
    static final int NO_OF_CHARS = 27;

    static HashMap<Character, Integer> hmS1 = new HashMap<Character, Integer>(NO_OF_CHARS);
    static HashMap<Character, Integer> hmS2 = new HashMap<Character, Integer>(NO_OF_CHARS);
     
    private static void initFrequencies(String S1, String S2) {
        for (Character ch = 'a'; ch <= 'z';  ch++) { // initialization
            hmS1.put(ch,0);
            hmS2.put(ch,0);
        }
        for (int i = 0; i < S1.length();  i++) { // counting
            Character ch = S1.charAt(i);
            hmS1.put(ch,hmS1.get(ch)+1);
         }
        for (int i = 0; i < S2.length();  i++) { // counting
            Character ch = S2.charAt(i);
            hmS2.put(ch,hmS2.get(ch)+1);
        }
    } // initFrequencies

    static int makingAnagrams(String s1, String s2) {
        initFrequencies(s1,s2);
        int sum = 0;
        for (Character ch = 'a'; ch <= 'z';  ch++) { // initialization
            sum += Math.abs(hmS1.get(ch)-hmS2.get(ch));
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
