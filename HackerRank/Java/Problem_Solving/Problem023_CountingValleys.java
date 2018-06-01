package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem023_CountingValleys {

    static int countingValleys(int n, String s) {
        int numValleys = 0;
        int level = 0;
        int prevLevel = level;
        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == 'U') {
                level++;
            }
            else {
                level--;
            }
            if (prevLevel == -1 && level == 0) {
                numValleys++;
            }            
            prevLevel = level;
        } // end of for
        
        return numValleys;
    } // the end of method

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
         if (n <= 0 ) {
				throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
		}
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}