package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem040_BeautifulDays_CountingReverseOrderDivisorRelaterValue {

    static int findReversedDigitsNumber(int n) {
        
        int newNumber = 0;
        do {
            newNumber = 10*newNumber+(n%10);
            n = n/10;
        } while (n > 0);            
        return newNumber;
        
    } // findReversedDigitsNumber
    
    
    static int beautifulDays(int i, int j, int k) {
        int counter = 0;
        for (int index = i; index <=j; index++) {
            if ( (index-findReversedDigitsNumber(index))%k == 0) {
                counter++;
            }
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);
        int j = Integer.parseInt(ijk[1]);
        int k = Integer.parseInt(ijk[2]);
        
        if (i < 0 ) {
			     throw new IllegalArgumentException(" Check Arguments Exception : Input i : i = "+Integer.toString(i)+" !\nOut of specified range");
	   }
        else if (j < 0 ) {
			     throw new IllegalArgumentException(" Check Arguments Exception : Input j : j = "+Integer.toString(j)+" !\nOut of specified range");
	   }
        else if (k < 0 ) {
			     throw new IllegalArgumentException(" Check Arguments Exception : Input k : k = "+Integer.toString(k)+" !\nOut of specified range");
	   }
        else {
            int result = beautifulDays(i, j, k);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        
        bufferedWriter.close();
        scanner.close();
        
    } // the end of main
    
} // the end of class
