package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem071_AlternatingCharacters_CoutningSimilarCharacter_inString {

    // HINT: Count identical character in sequences
    static int alternatingCharacters(String s) {
        int count = 0;
        for (int i = 0 ; i < s.trim().length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt(); // TO IGNORE DUE TO THE BUG OF INITIAL CODE
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                
        while(scanner.hasNextLine()) {
			bufferedWriter.write(String.valueOf(alternatingCharacters(scanner.next().toString())));
            bufferedWriter.newLine();
		}

        bufferedWriter.close();

        scanner.close();
    }
}
