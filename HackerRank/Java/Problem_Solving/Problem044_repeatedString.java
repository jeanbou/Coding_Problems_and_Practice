package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils; // TODO: download jar or config maven

public class Problem044_repeatedString {

    // Step 1 calculates how many first character of string in the given string
    // Step 2 calculates how many such string will be repeated
    // Step 3 calculates how many character rest for the rest of symbol repeating process
    // Step 4 repeat Step 2 for the tail
    
    static final String A_SEARCHED_LETTER_STR = "a";
    static final char A_SEARCHED_LETTER = 'a';
    
    static long repeatedString(String s, long n) {
        
        if ( !s.contains(A_SEARCHED_LETTER_STR) ) { // terminal cases
            return 0;
        }
        
        long f = n/s.length();
        int rest_num_chr = (int)(n -f*s.length());
        // counting for the rest of string
        int supCounter = 0;
        if (rest_num_chr > 0) {
            for (int i = 0; i < rest_num_chr; i++) {
                if (A_SEARCHED_LETTER == s.charAt(i) ) {
                    supCounter++;
                }
            }          
        } // the end of if for the rest of string during repeating process should be used
        
        return (StringUtils.countMatches(s, A_SEARCHED_LETTER_STR)*f+supCounter);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        // TEST CASE 3
        // Expected result 0
        //ceebbcb
        //817723
        //long result = repeatedString("ceebbcb", 817723);
        long result = repeatedString(s, n);
        

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
