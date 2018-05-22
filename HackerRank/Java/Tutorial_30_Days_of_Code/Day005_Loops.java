package hackerRank_Java30DaysOfCode;


import java.util.*;


public class Day005_Loops {

    private static final Scanner scanner = new Scanner(System.in);

    private final static int MULT = 10;
    
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                
        for (int i = 1; i <= MULT; i++) {
            int output = i * n;
            System.out.println(n+" x "+i+" = "+output);
        }

        scanner.close();
    }


}
