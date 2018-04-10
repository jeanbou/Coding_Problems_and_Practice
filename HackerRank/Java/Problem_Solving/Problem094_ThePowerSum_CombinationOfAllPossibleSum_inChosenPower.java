package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem094_ThePowerSum_CombinationOfAllPossibleSum_inChosenPower {
    
    
    // CREDITS: http://www.growingwiththeweb.com/2013/06/algorithm-all-combinations-of-set.html
    // The most adapted algorithms
    public static ArrayList<Integer> getSumPowNCombinations(int max_range_from_1, int power) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int i = 1; i <= max_range_from_1; i++) {
            int resultsLength = results.size();
            int pow_res =((int) Math.pow(i,power));
            for (int j = 0; j < resultsLength; j++) {
                results.add(pow_res + results.get(j));
            }
            results.add(pow_res);
        }
        return results;
    }
    
    // Modification of the algorithms above
    public static int getCountSumPowNCombinations(int max_range_from_1, int power, int X) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        int num = 0;
        for (int i = 1; i <= max_range_from_1; i++) {
            int resultsLength = results.size();
            int pow_res =((int) Math.pow(i,power));
            for (int j = 0; j < resultsLength; j++) {
                int sum = pow_res + results.get(j);
                if (sum < X) { // Critical check to pass test case 800
                    results.add(sum);
                }
                else if (sum == X) {
                    num++;
                }
            }            
            if (pow_res == X) {
                num++;
            }
            results.add(pow_res); // no need to check guaranted by given correct initial param            
        }
        return num;
    }

    // For old idea
    static int powerSumDebugMode(int X, int N) {
        int k = ((int) Math.pow(X,1.0/N));
        ArrayList<Integer> res = getSumPowNCombinations(k+1,N);
        int counter = 0;
        for (Integer a : res) {
            if (a == X) {
                counter++;
            }
        }
        return counter;
    }
    
    
    static int powerSum(int X, int N) { // Optimal solution
        return getCountSumPowNCombinations((int) Math.pow(X,1.0/N),N,X);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        // TEST CASE 3
        // 800
        // 2
        // EXPECTED: 561
        //int result = powerSum(800, 2);
        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
