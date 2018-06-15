package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem053_SafePrisoner_PlayingWithIndex_ForumsSolution {

    // CREDITS : https://www.hackerrank.com/alextornado?hr_r=1
    // FORUM DISCUSSION : https://www.hackerrank.com/challenges/save-the-prisoner/forum 3 months ago from 24-JUN-18
    static int saveThePrisoner(int n, int m, int s) {
        int index = (s + m - 1) % n;
	    if (index == 0) {
		  return n;
        }	
        return index;
    } // saveThePrisoner

    // MY BUGGY ATTEMPS
    static int saveThePrisoner_buggy(int n, int m, int s) {
        int mod = m % n;
        mod += s;
        int index = mod % n - 1;
        if (index <= 0) {
            return (n+index);
        }
        return index;
    } // saveThePrisoner_buggy   

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);
            
            // TEST CASE 0
            // 100 NUMBER OF TEST VALUES
            // 352926151 380324688 94730870
            // 94431605 679262176 5284458
            // 208526924 756265725 150817879
            // 962975336 9... etc see the txt data file
            
            // Expected output
            // 122129406
            // 23525398
            // 72975907 
            // 405956028
            // 265162707
            // 91803604
            // 82636723
            // 9258153
            // 81152217
            // 31978708
            // 269539705
            // ... etc see the txt data file
            // int result = saveThePrisoner(352926151, 380324688, 94730870); // 122129406 OK
            // int result = saveThePrisoner(499999999,999999997,2); // ERROR Expected value 499999999 and not 0
//499999999 999999998 2
//999999999 999999999 1
            // int result = saveThePrisoner(2,739424390,2); // Expected 1 MY ERROR -1
            // TEST CASE 5
            // int result = saveThePrisoner(11,872829055,1); // Expected 10 MY ERROR 1
            //int result = saveThePrisoner(5,838370030,1);
            
            int result = saveThePrisoner(n, m, s);
            
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
