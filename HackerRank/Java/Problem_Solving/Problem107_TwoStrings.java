package hackerRank_JavaProblemSolving;

import java.io.*;
import java.util.*;

public class Problem107_TwoStrings {

	static String twoStrings(String s1, String s2) {
	        // IDEA as long as there is a one character of ASCII in both string the condition is true, 65 is a capital A and 122 is a small z
	        for(int i = 65; i <= 122; i++) {
	            if (s1.contains(Character.toString((char) i)) && s2.contains(Character.toString((char) i))) {
	                return "YES";
	            }
	        }
	        return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int q = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int qItr = 0; qItr < q; qItr++) {
	            String s1 = scanner.nextLine();

	            String s2 = scanner.nextLine();

	            String result = twoStrings(s1, s2);

	            bufferedWriter.write(result);
	            bufferedWriter.newLine();
	        }

	        bufferedWriter.close();

	        scanner.close();
    }
}
