package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem055_Append_and_Delete_PlayingWithStringAnalysis {

    static final String YES_ANSWER = "Yes";
    static final String NO_ANSWER = "No";
    
    static int similarCharacterStartingFromZero(String s, String t, int maxIndex2Compare) {
        int counter = 0;
        for (int i = 0; i < maxIndex2Compare; i++) {
            if ( s.charAt(i) == t.charAt(i) ) {
                counter++;
            }
            else { // exit from cycle
                break;
            }
        }
        return counter;
    } // similarCharacterStartingFromZero

   
    static String appendAndDelete(String s, String t, int k) {        
        int len_s = s.length();
        int len_t = t.length();        
        if ( s.equals(t) ) { // strings are identical
            if (k % 2 == 0) {
                return YES_ANSWER;                
            }            
            if (k > 2 * len_s) {
                return YES_ANSWER;
            }            
            return NO_ANSWER;
        }
        else {            
            int simCharNum = similarCharacterStartingFromZero(s,t,Math.min(len_s,len_t));
            int totalNumOfMinOpperation = Math.abs(len_s-simCharNum)+Math.abs(len_t-simCharNum);
            if (totalNumOfMinOpperation > k) {
                return NO_ANSWER;
            }
            else if (totalNumOfMinOpperation == k) {
                return YES_ANSWER;
            }
            else {
                if ( k%2 == 1 ) {
                    return YES_ANSWER;                
                }
                if ( (totalNumOfMinOpperation-k) % 2 == 0 ) {
                    return YES_ANSWER;                
                }
                // BY DEFAULT
                return NO_ANSWER;
            }            
        }
    } // appendAndDelete

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        // TEST CASE 0.0 EXPECTED ANSWER YES
        //String result = appendAndDelete("hackerhappy","hackerrank",9);
        // TEST CASE 0.2 EXPECTED ANSWER NO
        //String result = appendAndDelete("ashley", "ash", 2);
        // TEST CASE 2 EXPECTED ANSWER YES
        //String result = appendAndDelete("aaaaaaaaaa","aaaaa",7);
        // TEST CASE 3 EXPECTED ANSWER YES  (trouble maker)      
        //String result = appendAndDelete("zzzzz", "zzzzzzz", 4);        
        // TEST CASE 4 EXPECTED ANSWER NO
        //String result = appendAndDelete("qwerasdf", "qwerbsdf", 6);
        // TEST CASE 5 EXPECTED ANSWER NO
        //String result = appendAndDelete("y", "yu", 2);
        // TEST CASE 6  EXPECTED ANSWER NO (trouble maker)
        //String result = appendAndDelete("qwerty","zxcvbn", 100);
        
        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
