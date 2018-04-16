package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem081_3DSurfaceArea__ComplexCubicalForm {

    // CREDITS : https://www.hackerrank.com/subash_kotha2?hr_r=1
    static private int surfaceArea(int[][] a, int h, int w) {
        int sum=0;
        for(int i = 0 ; i < h; ++i) {
            for(int j = 0; j < w; ++j) {
                if (i == 0) {
                    sum += a[i][j];
                }
                if (i == h-1) {
                    sum += a[i][j];
                }
                if (j == 0) {
                    sum += a[i][j];
                }
                if (j == w-1) {
                    sum += a[i][j];
                }
            }
        }
        
        for(int i=0; i<h; ++i) {
            for(int j=0;j<w-1;++j) {
                if (a[i][j] < a[i][j+1]) {
                    sum+=(a[i][j+1]-a[i][j]);
                }
                if (a[i][w-j-1] < a[i][w-j-2]) {
                    sum+=(a[i][w-j-2]-a[i][w-j-1]);
                }
            }
        }
        
        for(int i=0; i<h-1; ++i) {
            for(int j=0; j<w; ++j) {
                if (a[i][j]<a[i+1][j]) {
                    sum+=(a[i+1][j]-a[i][j]);
                }
                if(a[h-i-1][j]<a[h-i-2][j]) {
                    sum+=(a[h-i-2][j]-a[h-i-1][j]);
                }
            }
        }
        return (sum+(2*h*w));
    } // surfaceArea

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A,H,W);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
