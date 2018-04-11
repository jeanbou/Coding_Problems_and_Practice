package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem092_CavityMap_FindingMaxInStringOfNeighboursValueUsingSpecialCondition {

    // CREDITS : https://www.hackerrank.com/challenges/cavity-map/forum
    // CREDITS ON CONDITIONS https://www.hackerrank.com/maximshen?hr_r=1
    static String[] cavityMap(String[] grid) {
        int size = grid.length;
        for (int i = 1; i < size-1; i++) {
            int len_s = grid[i].length();
            @SuppressWarnings("unused")
			int max = 0;
            for (int j = 1; j < len_s-1; j++) {
                int left = Character.getNumericValue(grid[i].charAt(j-1));
                int right = Character.getNumericValue(grid[i].charAt(j+1));
                int up = Character.getNumericValue(grid[i-1].charAt(j));
                int down = Character.getNumericValue(grid[i+1].charAt(j));
                int middle = Character.getNumericValue(grid[i].charAt(j));
                @SuppressWarnings("unused")
				char mid = grid[i].charAt(j);
                if(left<middle && up<middle && right<middle && down<middle) {
                    StringBuilder sb = new StringBuilder(grid[i]);
                    sb.setCharAt(j, 'X');
                    grid[i] = sb.toString();
                }
            } // for
        }
        return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
