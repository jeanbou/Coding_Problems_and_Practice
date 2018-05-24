package hackerRank_Java30DaysOfCode;

import java.util.*;

public class Day007_Arrays {

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // Protective part of code
        if (n <= 0 ) {
				throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
		}
        
        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem; // Original line
        }

        scanner.close();
        
        // Solution
        for (int i = n-1; i >= 0; i--) {
            System.out.print(arr[i]+" ");
        }
    }

}
