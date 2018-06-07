package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem041_MinimumDistances_forUnsortedArray_usingHashMap {

    // The principal idea is to using HashMap reaches the complexity of O(n)
    // No sorting of O(n*logn) required
    // NB: All tests are pacing well, but I think I can find such array where similar values are set in row in such way that the algorithm wont find the minimal, and in such way we will need an extra data to keep indexes of all identical a[i] and run separately search of minimal among them
    // Think to in Karl Popper's manner of your best attempt to falsify the given algorith
    
	static int minimumDistances(int[] a) {
        
        int n = a.length;
        if (n <= 1) {
            return -1;
        }
        
        int minDist = Integer.MAX_VALUE;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++) {
            if (hm.containsKey(a[i])) {
                minDist = Math.min(minDist,Math.abs(i-hm.get(a[i])));
                if (minDist == 1) { // the ultimate minimum is reached, no need to run array 
                    return 1;
                }
            }
            else {
                hm.put(a[i],i);
            }
        }
        
        if (minDist == Integer.MAX_VALUE) { // Nothing has been compared
            return -1;
        }
        
        return minDist;

    } // the end of minimumDistances

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (n <= 0 ) { // Protective if
			     throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
	   }
        else {
        	
            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }
            int result = minimumDistances(a);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        
        bufferedWriter.close();
        scanner.close();
        
    } // the end of main
    
} // the end of class