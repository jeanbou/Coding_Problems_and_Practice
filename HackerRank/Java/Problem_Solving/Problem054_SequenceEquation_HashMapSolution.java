package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem054_SequenceEquation_HashMapSolution {

    // O(n) algorithm using HashMap data structure that is perfect for this solution
    static int[] permutationEquation(int[] p) {
        int n = p.length;
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>(n);
        for (int i = 0; i < n; i++) {
            hm.put(p[i],i+1);
        }
        int [] res = new int[n];
        for (int x = 1; x <= n; x++) {
            res[x-1] = hm.get(hm.get(x));            
        }        
        return res;
    } // permutationEquation

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }        
        
        // DEBUGGING CASES
        // TEST CASE 1
        // 1 4 2 3 5
        // EXPECTED 1 4 2 3 5 
        // TEST CASE 5
        //int[] rrr = {1,4,2,3,5};
        // 1,4,2,3,5
        // TEST CASE 6
        //int[] rr2 = {5,2,1,3,4};
        //int[] result = permutationEquation(rr2);
        // ANOTHER TEST CASE 18
        // 2 5 11 10 1 14 7 3 16 9 8 6 18 12 15 17 13 4
        
        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
