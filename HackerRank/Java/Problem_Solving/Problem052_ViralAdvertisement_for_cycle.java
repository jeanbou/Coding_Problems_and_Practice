package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem052_ViralAdvertisement_for_cycle {
    
    static final int initial_friends = 5; 
    
    static int viralAdvertising(int n) {
        int friends_involved = initial_friends;
        int likes_sum = 0;
        for (int i = 1; i <= n-1; i++) {
            int liked = friends_involved/2;
            likes_sum += liked;
            friends_involved = liked*3;            
        }
        likes_sum += (friends_involved/2);        
        return likes_sum;
    } // viralAdvertising

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
