package hackerRank_Java30DaysOfCode;

import java.util.Scanner;

class Calculator {
    
    public int power(int n, int p) throws IllegalArgumentException {
        if (n < 0 || p < 0) {
            throw new IllegalArgumentException("n and p should be non-negative");
        }
        else if (n == 0 && p == 0) {
            throw new IllegalArgumentException("Both n and p are zero. power(0,0) is underfined");
        }
                    
        return ((int) Math.pow(n,p));
    }
} // the end of Calculator class


public class Day017_Calculator__ExceptionPropagation {

    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
        
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
    
} // Main body