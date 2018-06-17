package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem051_designPDF_ASCII_CodePlay {

    static final int ALPH_LEN = 26;
    static final int LOW_A_ASCII_CODE = 97;
    
    // int [] h contains of the height of alphabet's 26 character (accordingly to the given two example it's not a constant)
    // So complexity of algorithm is O(n=26), the size of alphabet
    static int designerPdfViewer(int[] h, String word) {
        int len = word.length(); 
        word = word.toLowerCase();
        int maxH = 0;
        //int occurH = 0;
        for (int i = 0; i < ALPH_LEN; i++ ) { // it should 26 starting from a
            int asciiCodeOfLetter = LOW_A_ASCII_CODE+i;
            if (h[i] > maxH && word.contains(Character.toString((char) asciiCodeOfLetter))) {
                maxH = h[i];                
            }
        } // for
        return (len*maxH);
    } // designerPdfViewer

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[ALPH_LEN];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < ALPH_LEN; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();
        // TEST CASE
        // zbkkfhwplj EXPECTED : 70
        //int [] h1 = {6, 5, 7, 3, 6, 7, 3, 4, 4, 2, 3, 7, 1, 3, 7, 4, 6, 1, 2, 4, 3, 3, 1, 1, 3, 5};
        //int result = designerPdfViewer(h1, "zbkkfhwplj");
        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
