package hackerRank_JavaProblemSolving;

import java.io.*;
import java.util.*;

public class Problem102_FlatlandSpaceStations {

    // TEST CASE 19
    //99998 5
    //28000 58701 43043 24909 28572
    //Expected output
    //41296

    // TEST CASE 17
    //99989 4
    //75453 36129 64502 46817
    //Expected output
    //36129

    static int flatlandSpaceStations(int n, int[] c) {
        int m = c.length;
        if (n == m) {
            return 0;
        }
        if (n == m-1) {
            return 1;
        }
        Arrays.sort(c);
        int max = n-c[m-1]-1;
        max = Math.max(c[0],max);
        for (int i = 1; i < m; i++) {
            max = Math.max((c[i]-c[i-1])/2,max);
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
