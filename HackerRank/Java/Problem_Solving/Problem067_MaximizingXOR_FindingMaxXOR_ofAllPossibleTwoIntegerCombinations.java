package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem067_MaximizingXOR_FindingMaxXOR_ofAllPossibleTwoIntegerCombinations {

    // CREDITS : Geeks for Geeks
    // https://www.geeksforgeeks.org/find-xor-of-two-number-without-using-xor-operator/
    // Returns XOR of x and y
    static int m_XOR(int x, int y) {
        return ((x | y) & (~x | ~y));
    }
    
    static int maximizingXor(int l, int r) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            for (int j = i; j <= r; j++) {
                maxValue = Math.max(m_XOR(i,j),maxValue);
            }
        }
        return maxValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int r = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = maximizingXor(l, r);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
