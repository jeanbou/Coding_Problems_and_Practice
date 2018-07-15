package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem069_CountingSort1_HashMapSolution {

    static final int size_n = 100;
    
    // HINT: Using HashMap Data structure and Java 8 works with stream
    // COMPLEXITY : O(100)+O(n)
    static int[] countingSort(int[] arr) {
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>(size_n);
        for (int i = 0; i < size_n; i++) { // Initialization of HashMap of counters
            hm.put(i,0);
        }
        for (int j = 0; j < arr.length; j++ ) {
            hm.put(arr[j],hm.get(arr[j])+1);
        }        
        return hm.values().stream().mapToInt(i -> i).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = countingSort(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
