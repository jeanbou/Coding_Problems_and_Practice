package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Problem045_StrongPassword_CheckConfomityOfGivenString {

    // GIVEN INFO USE ONLY LAST
    //numbers = "0123456789";
    //lower_case = "abcdefghijklmnopqrstuvwxyz"
    //upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    static final int MIN_LEN = 6;
    static final String SPECIAL_CHARACTER_DEFINED = "!@#$%^&*()-+";
    
    static boolean isNumberStr(String str) {
        return str.matches(".*\\d+.*");
    }
    
    // CREDITS: https://stackoverflow.com/questions/20572980/pattern-to-check-if-a-string-contains-specific-characters
    static boolean isSpecialCharacterStr(String str, String chrInStringThatIWant) {
        return StringUtils.containsAny(str,chrInStringThatIWant);
    }
    
    // CREDITS! https://stackoverflow.com/questions/16127923/checking-letter-case-upper-lower-within-a-string-in-java
    static boolean isLowerCaseCharacterStr(String str) {
        return (!str.equals(str.toLowerCase())); //check if the input has a lower case letter
    }
    
    static boolean isUpperCaseCharacterStr(String str) {
        return (!str.equals(str.toUpperCase())); //check if the input has a CAPITAL case letter
    }
                
    static int minimumNumber(int n, String password) {
        int addCharacter = 0;
        if ( !isLowerCaseCharacterStr(password)) {
            addCharacter++;
        }
        if ( !isUpperCaseCharacterStr(password)) {
            addCharacter++;
        }
        if ( !isNumberStr(password) ) {
            addCharacter++;
        }
        if ( !isSpecialCharacterStr(password,SPECIAL_CHARACTER_DEFINED) ) {
            addCharacter++;
        }
        
        return (addCharacter+Math.max(0,MIN_LEN-n-addCharacter));
    } // minimumNumber

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();
        // TEST CASE 64 EXPECTED 1
        // AUzs-nV
        //int answer = minimumNumber(7, "AUzs-nV");
        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
