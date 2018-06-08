package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem077_FunnyString_CheckingTheASCIICodeDifferencesInString {

    static String funnyString(String s) {
        s = s.toLowerCase(); // Double check
        int str_len = s.length()-1; 
        int end = str_len;
        int beg = 0;        
        while ( end > beg ) {
            if ( end - 1 >= 0 && beg + 1 <= str_len ) {
                if (Math.abs(s.charAt(beg+1)-s.charAt(beg)) != Math.abs(s.charAt(end)-s.charAt(end-1))) {
                    return "Not Funny";
                }
            }
            end--;
            beg++;
        }    
        return "Funny";
    } // funnyString

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
