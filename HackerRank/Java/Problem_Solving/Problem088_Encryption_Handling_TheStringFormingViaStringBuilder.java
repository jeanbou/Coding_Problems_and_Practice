package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem088_Encryption_Handling_TheStringFormingViaStringBuilder {

    static String encryption(String s) {
        int size = s.length();
        int col = (int) Math.ceil(Math.sqrt(size));
        StringBuilder builder = new StringBuilder(); // String builder to handle it faster
        for (int cl = 0; cl < col; cl++) {
            int rw = cl;
            while (rw < size) {
                builder.append(s.charAt(rw));
                rw += col;
            }
            if (cl+1 != col) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
