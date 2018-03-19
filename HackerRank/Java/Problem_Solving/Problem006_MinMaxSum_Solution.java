package hackerRank_JavaProblemSolving;

import java.util.Scanner;

public class Problem006_MinMaxSum_Solution {
	
	static void miniMaxSum(int[] arr) {
    
	    int N = arr.length;
	    
	    if (N != 5 ) {
			throw new IllegalArgumentException(" Check Arguments");
		}        
	    else {
	        long sum = arr[0];
	        int min = arr[0];
	        int max = arr[0];
	        for (int i = 1; i < N; i++) {
	            sum += arr[i];
	            min = Math.min(min,arr[i]);
	            max = Math.max(max,arr[i]);
	        }
	        
	        System.out.println((sum-max)+" "+(sum-min));            
	    }     
	}

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int[] arr = new int[5];
	    for(int arr_i = 0; arr_i < 5; arr_i++){
	        arr[arr_i] = in.nextInt();
	    }
	    miniMaxSum(arr);
	    in.close();
	}

}
