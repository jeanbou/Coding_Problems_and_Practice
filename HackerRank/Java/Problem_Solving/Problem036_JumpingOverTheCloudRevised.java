package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem036_JumpingOverTheCloudRevised {

    static int jumpingOnClouds(int[] c, int k) {
        
        int n = c.length;
        int energy = 100;
        int i = 0;
        
        for (i = k; i < n; i += k ) {
            if (c[i] == 1 ) {
                energy -= 3;
            }
            else {
                energy -= 1;
            }
        } // the end of for
        
        // Heavy compensatory code for the end of array case
        if (i == n) { // the very end
            if (c[0] == 1) {
                energy -= 3;
            }
            else {
                energy -= 1;
            }
        } // Still there is element in array that has not been treated, space to jump over
        else if (c[i+k-n-1] == 1) {
            energy -= 3;
        }
        else {
            energy -= 1;
        }
        
        return energy;
    } // end of jumpingOnClouds

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        if (n <= 0 ) {
			     throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
	   }
	   else {

            int k = Integer.parseInt(nk[1]);

            int[] c = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }
            // DEBUG CASE 5
            // 24 3
            // int[] cc = {0,1,1,0,1,0,1,1,0,1,1,0,0,0,0,0,1,1,1,1,1,0,1,0}; // expected 86
            // DEBUG CASE 3
            // 19 19
            // 1 1 0 1 0 1 0 1 0 1 0 1 1 0 1 1 1 1 1 // expected 97
            // int result = jumpingOnClouds(cc, 3);  
            int result = jumpingOnClouds(c, k);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        
        bufferedWriter.close();
        scanner.close();
    } // the end of main
} // the end of class}
