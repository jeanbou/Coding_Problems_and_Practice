package hackerRank_JavaProblemSolving;

import java.util.Scanner;

public class Problem011_Apples_and_Oranges {

	    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
	        int appleCounter = 0;
	        int orangeCounter = 0;
	        
	        for (int applCoordinate : apples ) {
	            if (a+applCoordinate >= s && a+applCoordinate <= t ) {
	                appleCounter++;
	            }
	        }
	        
	        for (int orgCoordinate : oranges ) {
	            if (b+orgCoordinate >= s && b+orgCoordinate <= t ) {
	                orangeCounter++;
	            }
	        }
	        
	        System.out.println(appleCounter+"\n"+orangeCounter);

	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        String[] st = scanner.nextLine().split(" ");

	        int s = Integer.parseInt(st[0]);

	        int t = Integer.parseInt(st[1]);

	        String[] ab = scanner.nextLine().split(" ");

	        int a = Integer.parseInt(ab[0]);

	        int b = Integer.parseInt(ab[1]);

	        String[] mn = scanner.nextLine().split(" ");

	        int m = Integer.parseInt(mn[0]);

	        int n = Integer.parseInt(mn[1]);
	        
	        // Protective part of code
		    if (n <= 0 ) {
						throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
			}
	        
	        if (m <= 0 ) {
						throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(m)+" !\nOut of specified range");
			}

	        int[] apples = new int[m];

	        String[] applesItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < m; i++) {
	            int applesItem = Integer.parseInt(applesItems[i]);
	            apples[i] = applesItem;
	        }

	        int[] oranges = new int[n];

	        String[] orangesItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int orangesItem = Integer.parseInt(orangesItems[i]);
	            oranges[i] = orangesItem;
	        }

	        countApplesAndOranges(s, t, a, b, apples, oranges);

	        scanner.close();
	    }
	}