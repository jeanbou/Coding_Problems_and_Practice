package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem082_FairRations {

    static int fairRations(int[] B, int n) {
        int counterAnOddNum = 0;
        int result = 0;
        for (int b : B) {
            if (b % 2 == 1) {
                counterAnOddNum++;
            }
        }
        if (counterAnOddNum == 0) {  // Testcase 20, all are even
            return 0;
        }        
        else if ( counterAnOddNum % 2 == 1) {
            return -1;
        }
        else {
            int k = 0;
            while (k < n-1) { 
                if ( B[k] % 2 == 1) { // Increment 2 values
                    B[k]++;
                    B[k+1]++;
                    result += 2;
                    k++;                        
                }
                else {
                    if ( B[k+1] % 2 == 1) { // Skiped previous but next one must be incremented and next after next
                        k++;
                    }
                    else { // Both are OKay no need to increment
                       k+=2;
                    }
                }              
            } // while            
        }
        
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B,N);

        if ( result < 0) { // Signaling of wrong result
            bufferedWriter.write("NO");
        }
        else {
            bufferedWriter.write(String.valueOf(result));     
        }
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
