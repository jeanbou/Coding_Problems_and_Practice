package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem106_PryankaContenerization {

	// TEST CASE 01
    // 1 2 3 4 5 7 8 9 10 11
    //Expected output
    // 2

    // TEST CASE 02
    // 1 2 3 7 21 8 21 11 25
    // Expected output
    // 3

	static int shift = 4;
    
    static int toys(int[] w) {
        int n = w.length;
        Arrays.sort(w);
        int containerCouner = 0;
        int nextThreshold = w[0] + shift;
        for (int i = 1; i < n; i++) {
            if (w[i] > nextThreshold) {
                containerCouner++;
                nextThreshold = w[i] + shift;
            }
        }
        return (containerCouner+1);   

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] w = new int[n];

        String[] wItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int wItem = Integer.parseInt(wItems[i]);
            w[i] = wItem;
        }

        int result = toys(w);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}