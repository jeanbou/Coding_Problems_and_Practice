package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem046_CaesarCipher_DecodingStringPlayingWithASCIITable {

    static final int ALPH_LEN = 26;
    static final int DIFF_BETWEEN_UP_AND_LOW = 32;
    static final int LOW_A_ASCII_CODE = 97;
    static final int LOW_Z_ASCII_CODE = 122;
        
    static String caesarCipher(String s, int k) {
        // Pre-process k
        int new_k = k/ALPH_LEN;
        new_k = k-new_k*ALPH_LEN;
        String newStr = "";
        String origS = s;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            int code = (int) s.charAt(i);
            if ( code >= LOW_A_ASCII_CODE && code <= LOW_Z_ASCII_CODE ) {
                int shiftedCode = code+new_k;
                if ( shiftedCode > LOW_Z_ASCII_CODE) {
                    shiftedCode = shiftedCode - ALPH_LEN;
                }
                // one has to keep the upper or lower case of char, but decoding should be respected
                if ( ( (int) origS.charAt(i)) < LOW_A_ASCII_CODE ) {
                    shiftedCode -= DIFF_BETWEEN_UP_AND_LOW;
                }
                newStr += ((char) shiftedCode);                
            }
            else {
                newStr += s.charAt(i);
            }
        } // for
        return newStr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
