package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem063_BinarySearchInSortedAlgorithm_OptimalGeekForGeekSolution {
    
    // Geeks for Geeks, CREDITS : https://www.geeksforgeeks.org/binary-search/
    // Because the array is already sorted
    
    // A iterative binary search function. It returns
    // location of x in given array arr[l..r] if present,
    // otherwise -1
    static int binarySearch(int arr[], int l, int r, int x) {
        while (l <= r) {
            int m = l + (r-l)/2;
 
            // Check if x is present at mid
            if (arr[m] == x) {
                return m;
            }
 
            // If x greater, ignore left half
            if (arr[m] < x) {
                l = m + 1;
            }
            else { // If x is smaller, ignore right half
                r = m - 1;
            }
        }
 
        // if we reach here, then element was
        // not present
        return -1;
        
    } // binary search
    
    static int introTutorial(int V, int[] arr) {
        return binarySearch(arr, 0, arr.length-1, V);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int V = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = introTutorial(V, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}