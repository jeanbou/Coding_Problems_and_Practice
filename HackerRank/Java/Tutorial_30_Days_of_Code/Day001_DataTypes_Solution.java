package hackerRank_Java30DaysOfCode;

import java.util.Scanner;

public class Day001_DataTypes_Solution {
	
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);
        /* Declare second integer, double, and String variables. */
        int secondInt = 0;
        double secondDouble = 0.0;
        String strVal = s;

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
		secondInt = scan.nextInt();
        secondDouble = scan.nextDouble();
        while ( scan.hasNext() ) {
            strVal += (scan.next().toString()+" ");
        } 
        /* Print the sum of both integer variables on a new line. */
        System.out.println(i+secondInt);
        /* Print the sum of the double variables on a new line. */
		System.out.println(d+secondDouble);
        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
        System.out.println(strVal.trim());
        scan.close();
        
    }
}
