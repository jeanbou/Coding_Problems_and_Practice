package hackerRank_Java30DaysOfCode;

import java.util.*;

public class Day026_Checking_Condition_Finding_the_lib_fine {

    private static final Scanner scanner = new Scanner(System.in);
    
    private static int calculateFine(int dY, int dM, int dD) {
        
        if (dY < 0 && ( dM > 0 || dD > 0)) { // specific Year change case
            return 0;
        }
        if ( dY > 0) {
                return 10000;
        }
        if (dM > 0) {
            return 500*dM;
        }
        if (dD > 0) {
            return 15*dD;
        }
        return 0;
    } // the end of calculation
    
    public static void main(String[] args) {
        // Actual
        int Da = scanner.nextInt();
        int Ma = scanner.nextInt();
        int Ya = scanner.nextInt();
        // Expected
        int De = scanner.nextInt();
        int Me = scanner.nextInt();
        int Ye = scanner.nextInt();
        
        System.out.print(calculateFine(Ya-Ye,Ma-Me,Da-De));
    }
}