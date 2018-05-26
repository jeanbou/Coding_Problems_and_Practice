package hackerRank_JavaProblemSolving;

import java.io.*;
import java.util.*;

public class Problem013_CircularArray {


	// Smart Solution for this task
	// No need  to turn in and out array and simulate circular buffer (smart term for this data type)
	// The most optimal solution is to calculate the correct index and don't move at all the array

	private static final Scanner scanner = new Scanner(System.in);

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String[] nkq = scanner.nextLine().split(" ");

	        int n = Integer.parseInt(nkq[0]);
	        
	        // Protective part of code
		    if (n <= 0 ) {
					throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
			}

	        int k = Integer.parseInt(nkq[1]);

	        int q = Integer.parseInt(nkq[2]);
	        if (q <= 0 ) {
					throw new IllegalArgumentException(" Check Arguments Exception : Input : q = "+Integer.toString(q)+" !\nOut of specified range");
			}
	        
	        int[] a = new int[n];

	        String[] aItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int aItem = Integer.parseInt(aItems[i]);
	            a[i] = aItem;
	        }

	        int[] m = new int[q];

	        for (int i = 0; i < q; i++) {
	            int mItem = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	            m[i] = mItem;
	        }

	        for (int i = 0; i < q; i++ ) {
	        	
	            int c = n + ( m[i] - k ) % n; // Shift that simulate circular buffer move and start from the beginning
	            if ( c > n - 1 ) { // Correction
	                c = c - n;
	            }
	            
	            bufferedWriter.write(a[c]+"\n");
	   
	        }

	        bufferedWriter.close();

	        scanner.close();
	        
	    } // the end of main
	    
} // the end of class
