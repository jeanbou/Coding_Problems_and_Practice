package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem035_JumpingOverTheCloud {

    static int jumpingOnClouds(int[] c) {
        int n = c.length;
        int minimalJumps = 0;
        int ind = 0;
        while ( ind < n ) {
            if (ind+2 >= n) { // we have reached the end of array
                if (ind+1 == n-1) { // two sub-cases on what index points
                    return (minimalJumps+1);
                }
                return minimalJumps;
            }
            else if (c[ind+2] == 0) { // yes we can jump over the cloud                
                ind = ind+2;
                minimalJumps++;                
            }
            else { // we cannot jump over 1 cloud
                ind++;
                minimalJumps++;                
            }
        } // end of while
        return minimalJumps;
    } // end of test

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
            int[] c = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            int result = jumpingOnClouds(c);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
       }
        
        bufferedWriter.close();
        scanner.close();
    }
} // the end of class
