package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem064_ServiceLine__FindMinimalValueInArrayBetweenTwoIndexes {

    // The signature of method changed completely in order to resolve in efficient way
    // HINT: Optimal solution is to find the minimal value in width array between two given data indexes
    // Indexes must be kept so there is no need to use O(nlogn) sorting before searching
    // Complexity is O(n)
    static int[] serviceLane(int t, int[][] cases, int[] width) {
        int [] res = new int [t];
        for (int i = 0; i < t; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int j = cases[i][0]; j <= cases[i][1]; j++) {
                minValue = Math.min(minValue,width[j]);
            }
            res[i] = minValue;
        }
        return res;
    } // serviceLane

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nt = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nt[0]);

        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }

        int[][] cases = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        int[] result = serviceLane(t, cases, width);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}