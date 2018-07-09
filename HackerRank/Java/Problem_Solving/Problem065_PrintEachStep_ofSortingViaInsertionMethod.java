package hackerRank_JavaProblemSolving;

import java.util.Scanner;

public class Problem065_PrintEachStep_ofSortingViaInsertionMethod {

    // HINTS: Using the already resolved problem with insertionSort I come to conclusion that what the task is aiming to print out each step of sorting by insertion, so the old algorithm is adopted and that's it 
    static void insertionSort2(int n, int[] A) {
        for(int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value) { // CORECTED j >= 0 and not j > 0
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = value;
            printArray(A);
        }        
    }
    
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort2(n, arr);

        scanner.close();
    }
}
