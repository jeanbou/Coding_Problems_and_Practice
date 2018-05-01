package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem025_MigratoryBird {

    static int migratoryBirds(int[] ar) {
        Arrays.sort(ar); // O(nlogn+n)
        
        int seqOfIdenticalValue = 1;
        int maxCount = 0;
        int typeValue = ar[0];
        for (int i = 0; i < ar.length-1; i++) {
            
            if (ar[i] == ar[i+1]) {
                seqOfIdenticalValue++;
            }
            else {
                seqOfIdenticalValue = 1;
            }
            
            if ( maxCount < seqOfIdenticalValue) {
                maxCount = seqOfIdenticalValue;
                typeValue = ar[i];
            }
        }
        
        return typeValue;
    } // the end of method

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = migratoryBirds(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
