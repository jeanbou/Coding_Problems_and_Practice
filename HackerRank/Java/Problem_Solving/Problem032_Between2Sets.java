package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Problem032_Between2Sets {

    // https://www.hackerrank.com/challenges/between-two-sets/forum
    // CREDITS goes to MAYUR_2
    // Apperently, I didn't understand the requirements, but reading the code helps
    static int getTotalX(int n, int m, int[] a, int[] b)  {
        
        Vector <Integer> v1 = new Vector <Integer> ();
        
        for( int i = 1; i <= b[m-1]; i++) {
            int c = 0;
            for (int j = 0; j < m; j++) {
                if( b[j] % i == 0 ) {
                    c++;
                }
            }
            if( c == m ) {
                v1.add(i);    
            }
        }
        
        int c1 = 0;
        int c2 = 0;
        for(int k = 0; k < v1.size(); k++) {
            c1 = 0;
            int a1= v1.get(k);
            for(int i = 0; i < n; i++) {
                if( a1 % a[i] == 0) {
                    c1++;
                }
            }
            if( c1 == n) {
                c2++;
            }
        }        
        return c2;    
    } // the end of method

    private static final Scanner scan = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());
        if (n <= 0 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
        }

        int m = Integer.parseInt(nm[1].trim());
        if (m <= 0 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input : m = "+Integer.toString(m)+" !\nOut of specified range");
        }

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(n, m, a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}
