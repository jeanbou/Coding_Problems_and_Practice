package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Problem096_Anagram_FrequenciesBasedSolution {

    static final int NO_OF_CHARS = 27;
    
    static HashMap<Character, Integer> hmShead = new HashMap<Character, Integer>(NO_OF_CHARS);
    static HashMap<Character, Integer> hmStail = new HashMap<Character, Integer>(NO_OF_CHARS);   
    
    // Using the same approach as other for other anagram problems: frequencies' based in the given string
    static int anagram(String s) {
        int len_s = s.length();
        if (len_s % 2 == 1) {
            return -1;
        }
        s = s.toLowerCase(); // SAFE-check, just in case
        len_s = (int) len_s/2;
        
        // initFrequencies
        for (Character ch = 'a'; ch <= 'z';  ch++) { // initialization
            hmShead.put(ch,0);
            hmStail.put(ch,0);
        }
        
        // Count the frequencies
        for (int i = 0; i < len_s;  i++) { // counting the frequencies
            Character chHead = s.charAt(i);            
            Character chTail = s.charAt(s.length()-1-i);
            hmShead.put(chHead,hmShead.get(chHead)+1);
            hmStail.put(chTail,hmStail.get(chTail)+1);
        }
        
        int countingDiff = 0;
        for (Character ch = 'a'; ch <= 'z';  ch++) { // initialization
            countingDiff += Math.abs(hmShead.get(ch)-hmStail.get(ch));;
        }
        
        return (int) countingDiff/2;
        
    } // anagram


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
