package hackerRank_JavaProblemSolving;

import java.util.*;

public class Problem007_Stairs_Solution {

	    static void staircase(int n) {
	        if (n <= 0 ) {
				throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
			}
	        else if ( n == 1) {
	            System.out.println("#");
	        }
	        else {
	            StringBuffer outputStrBuffer = new StringBuffer();
	            for (int i = 1; i <= n; i++) {
	                char[] charArraySpaces = new char[n-i];
	                Arrays.fill(charArraySpaces, ' ');
	                char[] charArrayDies = new char[i];
	                Arrays.fill(charArrayDies, '#');
	                outputStrBuffer.append(charArraySpaces);
	                outputStrBuffer.append(charArrayDies);
	                outputStrBuffer.append("\n");                
	            }
	            System.out.print(outputStrBuffer.toString());
	        }
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        staircase(n);
	        in.close();
	    }
}
