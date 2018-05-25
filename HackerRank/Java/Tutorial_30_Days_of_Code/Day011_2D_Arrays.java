package hackerRank_Java30DaysOfCode;


import java.util.*;


public class Day011_2D_Arrays {

	    private static final Scanner scanner = new Scanner(System.in);

	    private static int extractSumOfHourglassesFromMatrix3x3(int i0, int j0, int[][] arr) {
	        return (arr[i0][j0]+arr[i0][j0+1]+arr[i0][j0+2]+
	                +arr[i0+1][j0+1]
	                +arr[i0+2][j0]+arr[i0+2][j0+1]+arr[i0+2][j0+2]);
	    }
	    
	    public static void main(String[] args) {
	        
	        int[][] arr = new int[6][6];

	        for (int i = 0; i < 6; i++) {
	            String[] arrRowItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int j = 0; j < 6; j++) {
	                int arrItem = Integer.parseInt(arrRowItems[j]);
	                arr[i][j] = arrItem;
	            }            
	        }
	        
	        scanner.close();
	        
	        int maxHourglassesSum = Integer.MIN_VALUE;
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                maxHourglassesSum = Math.max(maxHourglassesSum,extractSumOfHourglassesFromMatrix3x3(i,j,arr));                
	            }
	        }
	        
	        System.out.print(maxHourglassesSum);        
	    }

} // The end of class