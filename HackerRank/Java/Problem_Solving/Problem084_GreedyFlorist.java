package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem084_GreedyFlorist {

    // IDEAS : Poorly worded explanation, no discussion about sorting or sorted cost array
    // CREDITS : Reno Lu from Forum Discussion https://www.hackerrank.com/renolu?hr_r=1
    static int getMinimumCost(int k, int[] c, int size) {
        Arrays.sort(c);
        int totalCost = 0;
        if ( k == size) { // Simple case , no need to O(n*k) , purely O(n)
            for ( int cost : c) {
                totalCost += cost;
            }
            return totalCost;
        }
        else {
            int i = size-1;
            int bought = 0;
            // Start backwards from the most expensive flower, stop when there is no more flowers left
            while (i >= 0) {
                //Calculate total 
                //increment bought by 1 when everyone in the group has bought equal number of flowers
                for(int j=0; j<k && i >= 0; j++){
                    totalCost+=(1+bought)*c[i];
                    i--;
                }
                bought++;
            }
        }        
        return totalCost; // For complex case
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c, n);
        
        // TEST CASE 1 , input 50 3 and
        // int[] tc1 = {390225,426456,688267,800389,990107,439248,240638,15991,874479,568754,729927,980985,132244,488186,5037,721765,251885,28458,23710,281490,30935,897665,768945,337228,533277,959855,927447,941485,24242,684459,312855,716170,512600,608266,779912,950103,211756,665028,642996,262173,789020,932421,390745,433434,350262,463568,668809,305781,815771,550800};
        // int minimumCost = getMinimumCost(3, tc1, 50);
        
        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
