package hackerRank_JavaProblemSolving;

import java.util.*;

public class Problem008_Candle_Solution {

    static int birthdayCakeCandles(int n, int[] ar) {
        // Idiotic problem conditioning
        // Empirically proven useless of parameter n
        // Initial hypothesis was to use condition of ar[i] <= n - for the cases when they give you to blow the candles of not Collen age, hypothesis was proven wrong
        int N = ar.length;
        if (N <= 0 ) {
				throw new IllegalArgumentException(" Check Arguments Exception : Input array size : N = "+Integer.toString(N)+ " !\nOut of specified range");
		}
        
	    if ( N == 1 ) { // The most typical easy case
	       return 1;
	    }
        
        int maxHeight = 0;
        int counterOfMaxHeight = 0;
	    for (int i = 0; i < N; i++) { // Find max height candle first
            maxHeight = Math.max(maxHeight,ar[i]);
        }
        
        // Count candles of max height
        for (int i = 0; i < N; i++) {
            if ( ar[i] == maxHeight ) {
                counterOfMaxHeight++;
            }
        }
        
        return counterOfMaxHeight;

    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}