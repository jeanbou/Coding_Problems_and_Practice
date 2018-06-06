package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem039_MarsExploration_CountingTheCharacterInstringToReplace {

    static int marsExploration(String s) {
        int n = s.length();
        if (n < 3) {
            return 0;
        }
        int counterOfSymbolsToReplace = 0;
        for (int i = 0; i < n; i++) {
            if ( ((i+1) % 3 == 1 || (i+1) % 3 == 0) && s.charAt(i) != 'S' ) {
                counterOfSymbolsToReplace++;
            }
            else if ( (i+1) % 3 == 2 && s.charAt(i) != 'O' ) {
                    counterOfSymbolsToReplace++;
            }
        } // end of for

        return counterOfSymbolsToReplace;
    }

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();
        int n = s.length();
        if (n < 0 || n % 3 != 0  ) {
			     throw new IllegalArgumentException(" Check Arguments Exception : Input String Length : n = "+Integer.toString(n)+" !\nOut of specified range");
	   }
        else {
            int result = marsExploration(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        
        bufferedWriter.close();
        scanner.close();
    }
}