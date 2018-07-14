package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem060_ACMICPC_ORonArrayOfStrings {

    public static int getSizeOf1BitAfterORon2Strs(String a, String b, int size) {
        int sumBit = 0;
        for (int i = 0; i < size; i++) { // assumption that two string has the same size
            if (a.charAt(i) == '1' || b.charAt(i) == '1') {
                sumBit++;
            }
        }
        return sumBit;
    } // getSizeOf1BitAfterORon2Strs
    
    static int[] acmTeam(String[] topic) {
        int size = topic[0].length(); // a one string size
        int len_arr = topic.length;
        int maxSizeOf1BitInORSumStr = 0;
        int counterOfSuchStrs = 0;
        for (int i = 0; i < len_arr-1; i++ ) {
            for (int j = i+1; j < len_arr; j++ ) {
                int twoStrsRes = getSizeOf1BitAfterORon2Strs(topic[i],topic[j],size);
                if ( twoStrsRes > maxSizeOf1BitInORSumStr) { // new record
                    maxSizeOf1BitInORSumStr = twoStrsRes;
                    counterOfSuchStrs = 1;
                }
                else if (twoStrsRes == maxSizeOf1BitInORSumStr) {
                    counterOfSuchStrs++;
                }
            } // for pairs' forming            
        }
        int [] res = {maxSizeOf1BitInORSumStr, counterOfSuchStrs};
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
    
} // Problem060_ACMICPC_ORonArrayOfStrings