package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem033_FindDigits {

    static int findDigits(int n) {
        int restOfDvisionInt = n; 
        int count = 0;
        do {
            int lastDigitAfterDivision = restOfDvisionInt % 10; // it does not matter in which order we extract the digits of the given int number and check how it divides
            if (lastDigitAfterDivision != 0 && n % lastDigitAfterDivision == 0) {
                count++;    
            }
            restOfDvisionInt = (int) restOfDvisionInt/10; // explicit convertion to int of division
        } while (restOfDvisionInt > 0);
            
        return count;
    } // the end of findDigits

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        @SuppressWarnings("resource")
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            if (n <= 0 ) {
			     throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
            }
            else {
                int result = findDigits(n);
                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.close();
        scanner.close();
    } // the end of main
} // the end of class
