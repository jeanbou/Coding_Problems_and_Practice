package hackerRank_Java30DaysOfCode;

import java.io.*;
import java.util.*;

public class Day009_Factorial__the_very_classic_recursion {

	    // Complete the factorial function below.
	    static int factorial(int n) {
	        if (n == 0) { // just in case if someone want to test zero
	            return 1;
	        }
	        else if (n == 1) {
	            return 1;            
	        }
	        else {
	            return (n*factorial(n-1));
	        }
	    }

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
	        	
	            int result = factorial(n);

	            bufferedWriter.write(String.valueOf(result));
	            bufferedWriter.newLine();
	            
	        } // end of if for which parameter n is OK
	        
	        bufferedWriter.close();

	        scanner.close();
	        
	    } // the end of main

} // the end of class
