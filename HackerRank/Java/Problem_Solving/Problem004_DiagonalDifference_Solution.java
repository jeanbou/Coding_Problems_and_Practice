package hackerRank_JavaProblemSolving;

import java.util.*;

public class Problem004_DiagonalDifference_Solution {

    static int diagonalDifference(int[][] a) {
        int N = a.length;
        
        if (N <= 0) {
            return -1;
        }
        
        if (N == 1) {
            return 0;
        }
        
        int sumLDiag = a[0][0];
        int sumRDiag = a[0][N-1];
        for (int i = 1; i < N; i++) {
            sumLDiag += a[i][i];
            sumRDiag += a[i][N-1-i];
        }
        
        return Math.abs(sumLDiag-sumRDiag);
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}
