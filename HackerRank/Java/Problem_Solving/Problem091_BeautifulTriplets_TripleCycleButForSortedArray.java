package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem091_BeautifulTriplets_TripleCycleButForSortedArray {

	// IDEA 1 : The given array is sorted
	// IDEA 2 : Playing with indexes and break to quit array indexing and shift for another one
    static int beautifulTriplets(int d, int[] a, int size) {
        Arrays.sort(a);
        int counter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if ( a[j] - a[i] > d ) {
                    break;
                }
                else if ( a[j] - a[i] == d ) {
                    for (int k = j+1; k < size; k++) {
                        if ( a[k] - a[j] > d ) {
                            break;
                        }
                        else if ( a[k] - a[j] == d ) {
                            counter++;
                            break;
                        }
                    }
                }
            }
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
