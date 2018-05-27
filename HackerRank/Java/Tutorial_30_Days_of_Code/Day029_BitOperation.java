package hackerRank_Java30DaysOfCode;


import java.util.*;


public class Day029_BitOperation {

	// CREDITS: https://github.com/thechampanurag/hackerrank-30-Days-of-Code/blob/master/Day-29-Bitwise-AND.java
	
    private static final Scanner scanner = new Scanner(System.in);
    
    static int solve(int N, int K) {
		int result = 0;
		for (int A = 1; A <= N; A++) {
			for (int B = A + 1; B <= N; B++) {
				int current = A & B;
				if (current > result && current < K) {
					result = current;
				}
			}
		}
		return result;
	}
    
    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            System.out.println(solve(n, k));
		}
		scanner.close();
	}
	
}