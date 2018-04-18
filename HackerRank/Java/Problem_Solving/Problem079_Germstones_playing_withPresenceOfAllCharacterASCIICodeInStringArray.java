package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem079_Germstones_playing_withPresenceOfAllCharacterASCIICodeInStringArray {

    static int gemstones(String[] arr) {
        int countOfUniqueCharactersOfAlphabet = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            countOfUniqueCharactersOfAlphabet++;
            for (String s : arr) {
                if ( s.toLowerCase().indexOf(ch) < 0 ) {
                    countOfUniqueCharactersOfAlphabet--;
                    break;
                }
            }
        }
        return countOfUniqueCharactersOfAlphabet;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
