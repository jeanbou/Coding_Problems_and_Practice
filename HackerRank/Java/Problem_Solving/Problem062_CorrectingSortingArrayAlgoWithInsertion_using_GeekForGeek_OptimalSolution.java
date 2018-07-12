package hackerRank_JavaProblemSolving;

import java.util.Scanner;

public class Problem062_CorrectingSortingArrayAlgoWithInsertion_using_GeekForGeek_OptimalSolution {

    // CREDITS : https://www.geeksforgeeks.org/insertion-sort/
    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while(j >= 0 && A[j] > value) { // CORECTED j >= 0 and not j > 0
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = value;
        }

        printArray(A);
    }


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}
