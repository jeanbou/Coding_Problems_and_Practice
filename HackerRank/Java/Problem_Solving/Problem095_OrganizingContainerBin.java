package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem095_OrganizingContainerBin {
    
    private static final String IMP = "Impossible";
    private static final String PSB = "Possible";

    // Difficult to get the condition which swap is. 2D Matrix is not enough, after readings of comments
    // CREDITS : https://www.hackerrank.com/Live_wire15?hr_r=1
    static String organizingContainers(int[][] container, int size) {
        int [] rowsum = new int[size];
        int [] colsum = new int[size];
        for(int i = 0; i<  size; i++) { // initializing in order to be sure that we sum it from 0;
            rowsum[i] = 0;
            colsum[i] = 0;
        }
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) { // Symmetrical summing
                rowsum[i]+=container[i][j];
                colsum[i]+=container[j][i];
            }
        }
        
        // Sorting is the key factor, it allows us to compare smallest with smallest
        Arrays.sort(rowsum);
        Arrays.sort(colsum);
        
        for(int i=0; i< size; i++) {
            if (rowsum[i] != colsum[i]) { // KEY FACTORS 2, checking that exchanging the smallest on smallest (key condition that is difficult to get from the description) is the good condition for impossible swap and which is not
                return IMP;
            }       
        }
        // BY default is possible
        return PSB;
    } // organizingContainers

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container,n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}