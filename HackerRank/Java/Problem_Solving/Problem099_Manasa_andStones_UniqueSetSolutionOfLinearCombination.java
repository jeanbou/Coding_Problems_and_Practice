package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem099_Manasa_andStones_UniqueSetSolutionOfLinearCombination {

    static int[] stones(int n, int a, int b) {
        Set<Integer> uniqueCombination = new HashSet<Integer>(); // Unique combination of linear sum that contains of all possible results 
        for ( int i = 0; i < n; i++) {
            uniqueCombination.add(b*i+a*(n-i-1)); // TODO: Because the array must be in sorted order, the optimal solution will be to keep array sorted at the begining and then do sorted like insertion
        }
        int[] res = uniqueCombination.stream().mapToInt(Number::intValue).toArray();
        Arrays.sort(res);
        return res;        
    } // stones

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
