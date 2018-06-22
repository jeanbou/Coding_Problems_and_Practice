package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem043_UtopianTree_RecursiveSolution {
    
    // This is elegant recursive solution, however
    // Remark 1: Use f(n) solution similar to Fibonacci O(1) golden ration based numbers
    // Remark 2: Use BigInteger cycle based Fibonacci O(n) like number solution if it's required big numbers
    
	static int utopianTree(int n) {
        
        if (n == 0 ) {
            return 1;
        }
            
        if (n % 2 == 1) {
            return (2*utopianTree(n-1));
        }
        else {
            return (utopianTree(n-1)+1);
        }
        
    } // utopianTree

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
