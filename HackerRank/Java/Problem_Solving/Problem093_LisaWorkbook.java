package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem093_LisaWorkbook {

	// CREDITS : https://www.hackerrank.com/jnrdn0011?hr_r=1
    static int workbook(int n, int k, int[] arr) {
        int page = 1;
        int count = 0;
        for(int a : arr) {
            for(int i = 1; i <= a; i++) {
                if ( i == page ) { // The most complex condition that is weakly explained in description
                    count++;
                }
                if ( i % k == 0 ) {
                    page++;
                }
            }
            if( a % k != 0 ) {
                page++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}