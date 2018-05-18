package hackerRank_Java30DaysOfCode;

import java.util.Scanner;

public class Day014_Scope_Difference {
	private int[] elements;
  	public int maximumDifference;
  	
  	Day014_Scope_Difference (int[] arr) {
        elements = arr;
    } // Constructor


    public void computeDifference() {
        int maxElm = Integer.MIN_VALUE;
        int minElm = Integer.MAX_VALUE;
        for (int i = 0; i < elements.length; i++) {
            maxElm = Math.max(maxElm,elements[i]);
            minElm = Math.min(minElm,elements[i]);
        }
        this.maximumDifference = Math.abs(minElm-maxElm);
    } // computeDifference


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Day014_Scope_Difference difference = new Day014_Scope_Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
    
} // End of Difference class
