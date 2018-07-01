package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem072_BeautifulBinaryString {

    static int beautifulBinaryString(String s) { // The code explains itself
        int count = 0;
        for (int i = 0 ; i < s.trim().length()-2; i++) {
            if (s.charAt(i) == '0' && s.charAt(i+1) == '1' && s.charAt(i+2) == '0' ) {
                count++;
                i += 2;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        @SuppressWarnings("unused")
		int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
