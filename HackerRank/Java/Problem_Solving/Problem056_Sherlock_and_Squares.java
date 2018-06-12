package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem056_Sherlock_and_Squares {

    static int minNumSquareForA(int aNum) {
        if (aNum < 0) {
            return 0;
        }        
        int root_floor = (int) Math.sqrt(aNum);
        if (root_floor*root_floor == aNum) {
            return root_floor;
        }
        else {
            return (root_floor+1);
        }
    }
    
    static int squares(int a, int b) {
        int counter = 0;
        int min = minNumSquareForA(a);
        int sqr_min = min*min;
        while (sqr_min <= b) {
            counter++;
            min++;
            sqr_min = min*min;
        }
        return counter;
    } // squares

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
