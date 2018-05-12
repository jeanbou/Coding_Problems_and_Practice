package hackerRank_Java30DaysOfCode;

import java.util.*;

interface AdvancedArithmetic{
   int divisorSum(int n);
}

class ArithmeticCalculator implements AdvancedArithmetic {
    
    public int divisorSum(int n) {
        
        int sumOfDivisors = 1;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                sumOfDivisors += i;
            }
        }
        
        return sumOfDivisors;
        
    } // the end of divisorSum
    
} // advance arithmetic calculator (via interface implementation)

public class Day019_Calculator_ArithmeticInterface {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new ArithmeticCalculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}