package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem087_HackerRank_in_a_String__RepectingTheOrder {

    static final String hackerRankStr = "hackerrank";
    static final String YES = "YES";
    static final String NO = "NO";
    
    static String hackerrankInString(String s) {
        int counter = 0;
        int size = hackerRankStr.length();
        int index = 0;
        for ( int i = 0; i < size; i++) {
            for ( int j = index; j < s.length(); j++) {
                if ( hackerRankStr.charAt(i) == s.charAt(j) ) { // order must be kept
                    counter++;
                    index = j+1;
                    break; // check another letter from given string
                }
            }
        }
        if (counter == size) {
            return YES;
        }
        return NO;
    } // hackerrankInString

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {             
            bufferedWriter.write(hackerrankInString(scanner.nextLine()));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

