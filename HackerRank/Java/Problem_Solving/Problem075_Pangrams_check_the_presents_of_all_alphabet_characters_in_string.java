package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem075_Pangrams_check_the_presents_of_all_alphabet_characters_in_string {

    static String pangrams(String s) {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if ( s.toUpperCase().indexOf(ch) < 0 ) {
                return "not pangram";
            }     
        }
        return "pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}