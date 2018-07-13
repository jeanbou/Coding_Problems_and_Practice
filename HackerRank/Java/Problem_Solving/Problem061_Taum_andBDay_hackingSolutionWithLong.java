package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem061_Taum_andBDay_hackingSolutionWithLong {

    // The logic that works, but is not enough to pass the all cases because of very long long, so the main code has been hacked using commentary discussion of devs
    static long taumBday(int b, int w, int bc, int wc, int z) {
        long costconvertedFromBlackToWhite = w*(bc+z);
        long whiteOriginalCosts = w*wc;
        long costconvertedFromWhiteToBlack = b*(wc+z);
        long blackOriginalCosts = b*bc;
        if (costconvertedFromBlackToWhite < whiteOriginalCosts) {
            return (costconvertedFromBlackToWhite+blackOriginalCosts);
        }
        else if (costconvertedFromWhiteToBlack < blackOriginalCosts) {
            return (costconvertedFromWhiteToBlack+whiteOriginalCosts);
        }        
        else {
            return (whiteOriginalCosts+blackOriginalCosts);
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        // Hacked solution
        // CREDITS : https://www.hackerrank.com/rshaghoulian?hr_r=1
        // CREDITS : https://github.com/rshaghoulian
        int T = scan.nextInt();
        while (T-- > 0) {
            long B = scan.nextLong();
            long W = scan.nextLong();
            long X = scan.nextLong();
            long Y = scan.nextLong();
            long Z = scan.nextLong();
            long priceB = Math.min(X, Y + Z); // conversion price using the minimal
            long priceW = Math.min(Y, X + Z); // conversion price using the minimal
            bufferedWriter.write(String.valueOf(B * priceB + W * priceW));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scan.close();
    }
}
