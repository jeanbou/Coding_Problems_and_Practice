package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem022_StockMerchant {

    static int sockMerchant(int[] ar) {
        
        Arrays.sort(ar); // Because in this case the algo-complexity will be O(n(log(n)+1))
        
        int pairCounter = 0;
        int counterOfIdenticalValue = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] == ar[i+1]) {
                counterOfIdenticalValue++;
            }
            else {
                pairCounter += ((counterOfIdenticalValue+1)/2);
                counterOfIdenticalValue = 0;
            }            
        }
        
        if (counterOfIdenticalValue > 0) {
            pairCounter += ((counterOfIdenticalValue+1)/2);
        } 
        
        return pairCounter;
        
    } // end of sockMerchant

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if (n <= 0 ) {
				throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
		}
        else {
            int[] ar = new int[n];

            String[] arItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arItem = Integer.parseInt(arItems[i]);
                ar[i] = arItem;
            }

            int result = sockMerchant(ar);
            
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
            
        } // end of else for good paragraph n       

        bufferedWriter.close();

        scanner.close();
        
    } // the end of main
    
} // the end of class