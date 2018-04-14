package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem089_LuckBalance {

    // IDEA : Poorly worded
    // CREDITS : https://www.hackerrank.com/tao_zhang?hr_r=1
    static int luckBalance(int k, int[][] contests, int n) {
        List<Integer> importantContests = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += contests[i][0];
            if ( contests[i][1] == 1 ) {
                importantContests.add(contests[i][0]);
            }
        }
        Collections.sort(importantContests);
        int luckToFlip = 0;
        int mustWinImprCount = importantContests.size() - k;
        for (int i=0; i<mustWinImprCount; i++) {
            luckToFlip += importantContests.get(i);
        }
        return (sum-2*luckToFlip);
    } // luckBalance

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests,n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
