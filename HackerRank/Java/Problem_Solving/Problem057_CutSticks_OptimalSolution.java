package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem057_CutSticks_OptimalSolution {

    static int findTheMinimalStick(int[] ar) {
        int minVal = Integer.MAX_VALUE;
        for (int elm : ar) {
            minVal = Math.min(elm,minVal);
        }
        return minVal;
    } // findTheMinimalStick
   

    static int findIndexMinimalOnZeroValInSortedArray(int[] ar) {
        int n = ar.length;
        for (int i = 0; i < n-1; i++) {
            if (ar[i] > 0) {
                return i;
            }            
        }
        return n-1;
    } // findIndexMinimalOnZeroValInSortedArray

    
    static int[] cutTheSticks(int[] arr) { // O (n*n/2) solution using pre-sorted array
        Arrays.sort(arr);
        int n = arr.length;
        int counterOfZeroValue = findIndexMinimalOnZeroValInSortedArray(arr); 
        int toCut = arr[counterOfZeroValue];
        int newValToCut = toCut;
        boolean nextValueToCutNotFound = true;        
        List<Integer> list = new ArrayList<>();
        do {
            int cutedForOneIt = 0;
            for (int i = counterOfZeroValue; i < n; i++) {
                cutedForOneIt++;                    
                int newValue = arr[i] - toCut;
                if (newValue > 0 && nextValueToCutNotFound) {
                    newValToCut = newValue;
                    nextValueToCutNotFound = false;
                }
                else if (newValue == 0) {
                    counterOfZeroValue++;    
                }
                arr[i] = newValue;
            } // for
            nextValueToCutNotFound = true;
            toCut = newValToCut;
            list.add(cutedForOneIt);
        } while (counterOfZeroValue < n);
        // CONVERT LIST TO ARRAY
        return (list.stream().mapToInt(i -> i).toArray());
    } // cutTheSticks
    
    
    static int[] cutTheSticksOn2Solution(int[] arr) { // O(n*n) algorithmic complexity                                           
        int toCut = findTheMinimalStick(arr);
        int n = arr.length;
        int counterOfZeroValue = 0;
        int newValToCut = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        do {
            int cutedForOneIt = 0;
            counterOfZeroValue = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] <= 0) {
                    counterOfZeroValue++;
                }
                else {
                    cutedForOneIt++;
                    int newValue = arr[i] - toCut;
                    if (newValue > 0) {
                        newValToCut = Math.min(newValue,newValToCut);
                    }
                    arr[i] = newValue;                    
                }
            } // for
            toCut = newValToCut;
            newValToCut = Integer.MAX_VALUE;
            list.add(cutedForOneIt);
        } while (counterOfZeroValue < n);
        // REMOVE LAST VALUE
        list.remove(list.size()-1);
        // CONVERT LIST TO ARRAY
        return (list.stream().mapToInt(i -> i).toArray());
    } // cutTheSticks
    

    private static final Scanner scanner = new Scanner(System.in);

    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        // BUG TEST CASE 0
        //int [] ar = {1,13,3,8,14,9,4,4};
        // EXPECTED : 8 7 6 4 3 2 1
        //int[] result = cutTheSticks(ar);
        int[] result = cutTheSticks(arr);
        
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
}
