package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem074_FlippingBits_ofLong_ForFixedMaxLengthString {
    
    static final int max_size_of_string_for_bit_convertion = 32;

    static long flippingBits(long n) {
        String strLong64SymbolsLong = Long.toBinaryString(~n);
        return Long.parseLong(strLong64SymbolsLong.substring(max_size_of_string_for_bit_convertion, 2*max_size_of_string_for_bit_convertion),2);
    } // flippingBits

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            bufferedWriter.write(String.valueOf(flippingBits(scanner.nextLong())));
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
