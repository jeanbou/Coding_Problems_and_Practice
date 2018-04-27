package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem030_camelCase_WordCounting {

    static int camelcase(String s) {
        int counter = 0;
        for (int i = 0; i<s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                counter++;
            }
        }        
        return ++counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();
        if (s == null || s.isEmpty() ) {
			throw new IllegalArgumentException(" Check Arguments Exception : s string is empty");
        }
        else {

	        int result = camelcase(s);
	
	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();
        }  
	        bufferedWriter.close();
	
	        scanner.close();
        
    } // the end of main
    
} // the end of class
