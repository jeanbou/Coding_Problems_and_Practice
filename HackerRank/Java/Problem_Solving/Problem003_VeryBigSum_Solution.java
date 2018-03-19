package hackerRank_JavaProblemSolving;

import java.util.*;
import java.math.*;

public class Problem003_VeryBigSum_Solution {

	    static long aVeryBigSum(int n, long[] ar) {
	        
	        if (n <= 0) {
	            return -1;
	        }
	        
	        if (n == 1) {
	            return ar[0];
	        }
	        
	        BigInteger sum = BigInteger.valueOf(ar[0]); 
	        for (int i = 1; i < n; i++) {
	            sum = sum.add(BigInteger.valueOf(ar[i]));
	        }
	        
	        return sum.longValueExact();
	    }

	    public static void main(String[] args) {
	        @SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        long[] ar = new long[n];
	        for(int ar_i = 0; ar_i < n; ar_i++){
	            ar[ar_i] = in.nextLong();
	        }
	        long result = aVeryBigSum(n, ar);
	        System.out.println(result);
	    }
}

