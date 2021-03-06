package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem014_BreakingRecordsTask {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] score) {
        int initialScore = score[0];
        int nextBestScore = initialScore;
        int bestScoreBreakingCounter = 0;
        int nextWorthScore = initialScore;
        int worthScoreBreakingCounter = 0;
        for (int i = 1; i < score.length; i++) {
            if (nextBestScore < score[i]) {
                nextBestScore = score[i];
                bestScoreBreakingCounter++;
            }
            if (nextWorthScore > score[i]) {
                nextWorthScore = score[i];
                worthScoreBreakingCounter++;
            }
        }
        int[] result = {bestScoreBreakingCounter, worthScoreBreakingCounter};
        
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] score = new int[n];

        String[] scoreItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoreItem = Integer.parseInt(scoreItems[i]);
            score[i] = scoreItem;
        }

        int[] result = breakingRecords(score);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
