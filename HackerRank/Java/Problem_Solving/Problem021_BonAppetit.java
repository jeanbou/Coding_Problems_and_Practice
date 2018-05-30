package hackerRank_JavaProblemSolving;

import java.util.*;

public class Problem021_BonAppetit {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String args[] ) throws Exception {
        
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);
        
        if (n <= 0 ) {
				throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
		}
        else {
            String[] arItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int arItem = Integer.parseInt(arItems[i]);
                if (k != i) {
                    sum += arItem;
                }
            }

            int b = Integer.parseInt(scanner.nextLine());
            int delta = b-sum/2;

            if ( delta == 0 ) {
                System.out.println("Bon Appetit");
            }
            else {
                System.out.println(delta);
            }
        } // the end of correct part of code for tricky parameter n
        
        scanner.close();
        
    } // the end of main
}