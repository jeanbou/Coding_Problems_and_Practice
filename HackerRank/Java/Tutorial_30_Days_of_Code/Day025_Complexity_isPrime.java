package hackerRank_Java30DaysOfCode;

import java.util.*;

public class Day025_Complexity_isPrime {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    // CREDITS: https://stackoverflow.com/questions/36253398/what-is-an-efficient-algorithm-in-java-to-verify-an-prime-number-with-more-than
    private static boolean isPrime(long a) {
        if (a == 1) {
            return false;
        }
        if (a % 2 == 0 || a % 3 == 0 || a % 5 == 0) {
            return a <= 3 || a == 5;
        }
        for (int i = 6, max = (int) Math.sqrt(a); i <= max; i = i + 6) {
            if (a % (i + 1) == 0 | a % (i + 5) == 0) {
                return false;
            }
        }
        return true;
    } // the end of isLongPrime

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // Protective part of code
        if (n <= 0 ) {
				throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
		}
        
        for (int i = 0; i < n; i++) {
            long aItem = scanner.nextInt();
            if ( isPrime(aItem) ) {
                System.out.println("Prime");
            }
            else {
                System.out.println("Not prime");
            }        
        }
    }
}