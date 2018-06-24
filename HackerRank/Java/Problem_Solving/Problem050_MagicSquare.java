package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem050_MagicSquare {

    // CREDITS (Theory on magic square) https://en.wikipedia.org/wiki/Magic_square
    // Trick 1: We know accordingly to the source code that the magic square has constant order 3
    // Trick 2: Output is a absolute difference between magic constant of each row sum
    // NB: Failed for 2 cases, so the magic square it does not keep the condition described in WikiPedia
    private static final int CONST_OF_MAGIC_SQ_ORDER3 = 15;
    
    // BUGGY read NB: Trick 1 & Trick 2 does not work
    static int formingMagicSquare(int[][] s, int magSquareOrder) {
        int res = 0;
        for (int i = 0; i < magSquareOrder; i++) {
            int sumOfRow = 0;
            for (int j = 0; j < magSquareOrder; j++) {
                sumOfRow += s[i][j];
            }
            res += Math.abs(sumOfRow-CONST_OF_MAGIC_SQ_ORDER3);
        }
        //int compesatory = Math.abs(s[0][2]+s[1][1]+s[2][0]-CONST_OF_MAGIC_SQ_ORDER3);
        return (res);
    } // formingMagicSquare
    
    
    // CREDITS based on the discussion in Forum https://www.hackerrank.com/adityangt?hr_r=1
    // https://www.hackerrank.com/challenges/magic-square-forming/forum (3 week ago from 26-JUN)
    // MORE CREDITS : https://medium.com/@adityangt
    static int formingMagicSquareBy_adityangt(int[][] s) {
        int cost = Integer.MAX_VALUE;
        int t[][] = 
                    {
                        {4,9,2,3,5,7,8,1,6},
                        {4,3,8,9,5,1,2,7,6},
                        {2,9,4,7,5,3,6,1,8},
                        {2,7,6,9,5,1,4,3,8},
                        {8,1,6,3,5,7,4,9,2},
                        {8,3,4,1,5,9,6,7,2},
                        {6,7,2,1,5,9,8,3,4},
                        {6,1,8,7,5,3,2,9,4},
                    };
        int temp = 0;
        for(int i=0;i<8;i++){
            temp = Math.abs(s[0][0]-t[i][0]) + Math.abs(s[0][1]-t[i][1]) +Math.abs(s[0][2]-t[i][2]) +Math.abs(s[1][0]-t[i][3]) + Math.abs(s[1][1]-t[i][4]) + Math.abs(s[1][2]-t[i][5])+ Math.abs(s[2][0]-t[i][6]) + Math.abs(s[2][1]-t[i][7]) + Math.abs(s[2][2]-t[i][8]);
            cost = temp<cost?temp:cost;
        }
        return cost;
    } // formingMagicSquareBy_adityangt

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }
        
        /* Test case 1
        4 5 8 = 17 2 Expected 14
        2 4 1 = 7  8
        1 9 7 = 17 2
        
        Test case 2
        2 9 8 = 19 4 Expected 21
        4 2 7 = 13 2
        5 6 7 = 18 3
        */
        // int result = formingMagicSquare(s,3)
        int result = formingMagicSquareBy_adityangt(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
