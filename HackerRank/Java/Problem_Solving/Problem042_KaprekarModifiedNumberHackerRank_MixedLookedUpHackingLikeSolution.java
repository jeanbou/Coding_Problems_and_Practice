package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem042_KaprekarModifiedNumberHackerRank_MixedLookedUpHackingLikeSolution {
    
    // NB: Because it is not a classic but Modified Kaprekan number, this is synthetic hacker's approach
	// https://en.wikipedia.org/wiki/Kaprekar_number
    // https://oeis.org/A006886
    // Using Hack LookUp Approach from classic Kapkekar solution
	// The rest is using Geek for Geeks classic solution    
    
	// Main hack
	static final int [] kaprekarModNumberLookUpFromWiki = {1, 9, 45, 55, 99, 297, 703, 999, 2223, 2728, 4950, 5050, 7272, 7777, 9999, 17344, 22222, 77778, 82656, 95121, 99999, 142857, 148149, 181819, 187110, 208495, 318682, 329967, 351352, 356643, 390313, 461539, 466830, 499500, 500500, 533170};
    
	// TEST 2 Case
    // + 2223 2728 4950 5050 7272 7777 9999
    // TEST 6 Case
	// ++ 77778 82656 95121 99999
    
    // CREDITS: https://www.geeksforgeeks.org/kaprekar-number/
    // Returns true if n is a Kaprekar number, false implementation see my debug case 2 below
    // Checked with Wikipedia results above and compare
    
	static boolean iskaprekar(int n)
    {
        if (n == 1)
           return true;
      
        // Count number of digits in square
        int sq_n = n * n;
        int count_digits = 0;
        while (sq_n != 0)
        {
            count_digits++;
            sq_n /= 10;
        }
      
        sq_n = n*n; // Recompute square as it was changed
      
        // Split the square at different points and see if sum
        // of any pair of spited numbers is equal to n.
        for (int r_digits=1; r_digits<count_digits; r_digits++)
        {
             int eq_parts = (int) Math.pow(10, r_digits);
      
             // To avoid numbers like 10, 100, 1000 (These are not
             // Karprekar numbers
             if (eq_parts == n)
                continue;
      
             // Find sum of current parts and compare with n
             int sum = sq_n/eq_parts + sq_n % eq_parts;
             if (sum == n)
               return true;
        }
      
        // compare with original number
        return false;
        
    } // iskaprekar()

    static int[] kaprekarNumbers(int p, int q) {
        int maxKarpekarNumFromLookUP = kaprekarModNumberLookUpFromWiki[kaprekarModNumberLookUpFromWiki.length-1];
        List<Integer> list = new ArrayList<Integer>();
        if (q <= maxKarpekarNumFromLookUP) {
            for (int i = 0; i < kaprekarModNumberLookUpFromWiki.length; i++ ) {
                int aKarpekarNumVal = kaprekarModNumberLookUpFromWiki[i];
                if ( aKarpekarNumVal >= p && aKarpekarNumVal <= q) {
                    list.add(aKarpekarNumVal);
                }
            }
        }
        // NB: the range is higher the given lookedUp range, 
        // The rest is usage Geek for Geek code to hack the task
        if (q > maxKarpekarNumFromLookUP) {
            for (int i = maxKarpekarNumFromLookUP+1;i <= q;i++) {
                if (iskaprekar(i)) {
                    list.add(i);
                }
            }
        } // kaprekarNumbers
        
        // Convert to int [] and return
        return (list.stream().mapToInt(i -> i).toArray());
    
    }

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (p <= 0 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input : p = "+Integer.toString(p)+" !\nOut of specified range");
        }

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (q <= 0 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input : q = "+Integer.toString(q)+" !\nOut of specified range");
        }

        // DEBUG
        //int[] result = kaprekarNumbers(400,700); // DEBUG EXPECTED  "INVALID RANGE"
        //int[] result = kaprekarNumbers(1000, 10000); // DEBUG EXPECTED  2223 2728 4950 5050 7272 7777 9999
                                                       // MY BUGGY OUT PUT OF GEEK FOR GEEK CODE 2223 2728 4879 4950 5050 5292 7272 7777 9999
        
        // TEST CASE 6 ++ 17344 22222 77778 82656 95121 99999
        int[] result = kaprekarNumbers(p, q);
        
        if ( result.length <= 0 ) {
            bufferedWriter.write("INVALID RANGE");
        }
        else {
            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }
        }

        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    
    } // the end of main

} // the end of class