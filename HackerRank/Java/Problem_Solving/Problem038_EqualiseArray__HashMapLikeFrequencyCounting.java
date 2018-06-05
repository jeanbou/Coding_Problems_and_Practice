package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Problem038_EqualiseArray__HashMapLikeFrequencyCounting {

    static HashMap <Integer, Integer> hm = new HashMap<Integer, Integer>();
    
    // CREDITS: https://www.geeksforgeeks.org/find-frequency-number-array/
    // The idea is using the classical solution of frequency counting inside unsorted array by the mean of hash map, calculate the max frequency, then the answer is trivial.
    // Targeted complexity O(n), disadvantages : HashMap usage and maintenance.
    // Given array is unsorted
    static int equalizeArray(int[] arr) {
        // Insert elements and handling frequencies via hash map
        int maxFreqAmongAllElm = 1;
        for (int a : arr) {
            if (hm.containsKey(a)) {
                int newFreqIncrementedUpdate = hm.get(a)+1;
                maxFreqAmongAllElm = Math.max(maxFreqAmongAllElm,newFreqIncrementedUpdate);
                hm.put(a,newFreqIncrementedUpdate);
            }
            else {
                hm.put(a,1);
            }
        }
        return (arr.length-maxFreqAmongAllElm);
    } // the end of equalize

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
        if (n <= 0 ) {
			     throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
	   }
        else {
            
            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            // DEBUGING, Test case 7, all values are different
            //int [] brr = {37,32,97,35,76,62}; // Expected out put 5
            //int result = equalizeArray(brr);
            int result = equalizeArray(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        
        bufferedWriter.close();
        scanner.close();
        
    } // the end of main
    
} // the end of class