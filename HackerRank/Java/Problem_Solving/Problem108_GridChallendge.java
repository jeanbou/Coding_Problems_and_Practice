package hackerRank_JavaProblemSolving;

import java.io.*;
import java.util.*;

public class Problem108_GridChallendge {

    static String gridChallenge(String[] grid) {
        
        int n = grid.length;
        int m = grid[0].length();
        
        char[][] charMatrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            char tempArray[] = grid[i].toCharArray();
            Arrays.sort(tempArray);
            for (int j = 0; j < m; j++) {
                charMatrix[i][j] =  tempArray[j];
            }
        }
        
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if ( charMatrix[i-1][j] > charMatrix[i][j] ) {
                    return "NO";
                }
            }
        }
            
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}