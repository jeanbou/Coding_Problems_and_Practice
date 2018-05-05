package hackerRank_JavaProblemSolving;

import java.io.*;
import java.util.*;

public class Problem016_AngryProfessor {

    static String angryProfessor(int k, int[] a) {
        int arrivedOnTimeStudentCounter = 0;
        for ( int arivalDeltaTimeStudent : a ) {
            if ( arivalDeltaTimeStudent <= 0) { // Searching for quota: the number of students who has to arrive on time in order that angry professor does not cancel the class
                arrivedOnTimeStudentCounter++;
                if (arrivedOnTimeStudentCounter >= k) {
                    return "NO";
                }
            }
        }
        return "YES";
    } // the end of method

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            String result = angryProfessor(k, a);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
