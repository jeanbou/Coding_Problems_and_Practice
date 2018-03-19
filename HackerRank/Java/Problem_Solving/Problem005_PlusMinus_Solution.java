package hackerRank_JavaProblemSolving;

import java.util.Scanner;

public class Problem005_PlusMinus_Solution {
	
	static void plusMinus(int[] arr) {
        
        int N = arr.length;
        
        if (N <= 0) {
            System.out.print(""); 
        }
        else {
            double posCounter = 0; // Very important, double type, because if int :: int/int = int
            double negCounter = 0;
            double zerCounter = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > 0 ) {
                    posCounter++;
                }
                else if (arr[i] < 0 ) {
                    negCounter++;
                }
                else {
                    zerCounter++;
                }
            } // end of main cycle
            
            System.out.print(String.format("%.6g%n", posCounter/N));
            System.out.print(String.format("%.6g%n", negCounter/N));
            System.out.print(String.format("%.6g%n", zerCounter/N));
        } // end of main else        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}
