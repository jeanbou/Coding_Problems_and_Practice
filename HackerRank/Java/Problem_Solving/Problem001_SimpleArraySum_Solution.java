package hackerRank_JavaProblemSolving;

import java.util.*;

public class Problem001_SimpleArraySum_Solution {

    static int simpleArraySum(int n, int[] ar) {
        
        if (n <= 0) {
            return -1;
        }
        
        if (n == 1) {
            return ar[0];
        }
        
        long sum = ar[0];
        for (int i = 1; i < n; i++) {
            sum += ar[i];
        }
        
        return ((int) sum);
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = simpleArraySum(n, ar);
        System.out.println(result);
    }
}
