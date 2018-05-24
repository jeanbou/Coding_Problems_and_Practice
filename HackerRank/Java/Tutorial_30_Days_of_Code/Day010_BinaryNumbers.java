package hackerRank_Java30DaysOfCode;

import java.util.*;

public class Day010_BinaryNumbers {

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        
	        // Protective part of code
	        if (n <= 0 ) {
					throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
			}
	        else {
	            int maxConseq = 0;
	            int counterConseq = 0;
	            while(n > 0) {
	                int remainder = n % 2;
	                n =  n / 2;
	                if (remainder == 1) {
	                    counterConseq++;
	                    maxConseq = Math.max(maxConseq,counterConseq);
	                }
	                else {
	                    counterConseq = 0;
	                }
	            } // end of while from tutorial example         
	            System.out.println(maxConseq);
	            
	        } // end of protective if-else
	        
	        scanner.close();
	 } // the end of main

} // end of class