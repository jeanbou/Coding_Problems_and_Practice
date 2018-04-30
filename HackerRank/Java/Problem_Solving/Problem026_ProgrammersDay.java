package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem026_ProgrammersDay {
    
    static boolean isLeapYear(int year) {
        
        // Why are years such as 1700, 1800, 1900 not leap years, even though they are divisible by 4, but 1600 and 2000 are?
        // https://www.quora.com/Why-are-years-such-as-1700-1800-1900-not-leap-years-even-though-they-are-divisible-by-4-but-1600-and-2000-are
        // Compensatory quick solution
        if ( year == 1700 || year == 1800 || year == 1900 ) {
            return true;
        }        
    
        return ((year%4==0)&&(year%100!=0)||(year%400==0));
    } 
    
    static String solve(int year) {
        int sumForNonLeapYear = 31+28+31+30+31+30+31+31;
        int programmerDateOfSeptemberMonth = 256 - sumForNonLeapYear;
        if ( year == 1918)  { // Specific case of Russian calendar update
            programmerDateOfSeptemberMonth = 26;
        }
        else if ( isLeapYear(year) ) {
            programmerDateOfSeptemberMonth--;
        }
        
        return (programmerDateOfSeptemberMonth+".09."+year);

    }

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (year <= 0 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(year)+" !\nOut of specified range");
		}
        else {
            String result = solve(year);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

        scanner.close();
    }
}
