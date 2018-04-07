package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem097_MaximumPerimeterTriangle__FindingTheTriangleUsingHeronsFormula {
     
    // IN SEARCH OF FORMULA
    // https://www.mathopenref.com/heronsformula.html
    static int[] maximumPerimeterTriangle(int[] sticks, int n) {
        Arrays.sort(sticks); // The input is not sorted, so the best solution to sort and follow the trick
        int [] besttriangle = {0, 0, 0};  // BEST TRIANGLE INIT
        int [] bydeafaultNoSolution = {-1};
        for (int i = n-1; i >= 2; i--) { // Tricks, the bigest area will be constructed from the longests sticks
            int a = sticks[i];
            int b = sticks[i-1];
            int c = sticks[i-2];
            // Heron's Formula
            double p = (a+b+c)/2.0;
            double area_sq = p*(p-a)*(p-b)*(p-c);
            
            if (area_sq > 0) {
                besttriangle[0] = c;
                besttriangle[1] = b;
                besttriangle[2] = a;
                return besttriangle;
            }
        }
        return bydeafaultNoSolution;
    } // maximumPerimeterTriangle

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sticks = new int[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        int[] result = maximumPerimeterTriangle(sticks, n);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
