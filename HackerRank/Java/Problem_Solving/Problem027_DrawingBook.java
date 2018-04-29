package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem027_DrawingBook {

    static int pageCount(int n, int p) {
    	
        int pageFrom = (n-p)/2;
        int pageTo = p/2;
        if ( p%2==1 && n%2==0 ) {
            pageFrom++;
        }
        
        return Math.min(pageFrom,pageTo);
    } // end of pageCount 

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        
        if (n <= 0 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
        }
        else if (p <= 0 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input : p = "+Integer.toString(p)+" !\nOut of specified range");
        }
        else {        
        	int result = pageCount(n, p);
                
        	bufferedWriter.write(String.valueOf(result));
        	bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}