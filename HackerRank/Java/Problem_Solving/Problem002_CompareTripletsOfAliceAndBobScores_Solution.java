package hackerRank_JavaProblemSolving;

import java.util.*;


	public class Problem002_CompareTripletsOfAliceAndBobScores_Solution {

	    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
	        int bobScore = 0;
	        int aliceScore = 0;
	        if (a0 > b0) {
	            aliceScore++;
	        }
	        else if (a0 < b0) {
	            bobScore++;
	        }
	        
	        if (a1 > b1) {
	            aliceScore++;
	        }
	        else if (a1 < b1) {
	            bobScore++;
	        } 
	        
	        if (a2 > b2) {
	            aliceScore++;
	        }
	        else if (a2 < b2) {
	            bobScore++;
	        }
	        
	        int[] res_array = {aliceScore, bobScore}; 
	        return res_array;
	    }

	    public static void main(String[] args) {
	        @SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
	        int a0 = in.nextInt();
	        int a1 = in.nextInt();
	        int a2 = in.nextInt();
	        int b0 = in.nextInt();
	        int b1 = in.nextInt();
	        int b2 = in.nextInt();
	        int[] result = solve(a0, a1, a2, b0, b1, b2);
	        for (int i = 0; i < result.length; i++) {
	            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
	        }
	        System.out.println("");
	        

	    }

}
