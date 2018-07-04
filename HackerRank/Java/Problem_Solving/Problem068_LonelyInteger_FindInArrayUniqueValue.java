package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem068_LonelyInteger_FindInArrayUniqueValue {
	
	// Finds the unique integer inside the given array
    static int lonelyinteger(int[] a) {
        Arrays.sort(a); // O(nlogn)
        int n_minus_1 = a.length-1;
        for (int i = n_minus_1; i >= 1 ; i--) {
            if (a[i] != a[i-1] ) {
                if (i+1 > n_minus_1) { 	// Because we need to check what it was before in sorted array we need to control out of index case
                    return a[i];		// that's why we can also check a terminal case, the highest value in array is unique 
                }
                else if (i+1 <= n_minus_1 && a[i+1] == a[i]) { // go next
                    continue;
                }
                else { // Definitely unique
                    return a[i];
                }
            }
        }
        return a[0]; // 1 value array
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
