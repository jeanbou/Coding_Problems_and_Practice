package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem031_SuperReducedString_Efficient_Iterative_Decoding {

    static String super_reduced_string(String s) {
        String originalS = s;
        String decodedS = s; // Very important moment of initialization, be careful
        do {
            originalS = decodedS;
            int n = originalS.length();
            decodedS = "";            
            int counterOfIdenticalChar = 1;
            for (int i = 0; i < n-1; i++) {
                if ( originalS.charAt(i) == originalS.charAt(i+1) ) {
                    counterOfIdenticalChar++;                    
                }
                else {
                    if (counterOfIdenticalChar % 2 == 1) {
                        decodedS = decodedS + originalS.charAt(i);
                        // FOR DEBUG
                        //System.out.println("decodedS : "+decodedS);
                    }
                    // re-initiate counter
                    counterOfIdenticalChar = 1;
                }
            } // the end of for that decode/reduce the original string during the one iteration
            // We have reached the end of the pair comparison and the last symbol is not taken into account, but character counter is fine
            if (counterOfIdenticalChar % 2 == 1) {
                decodedS = decodedS + originalS.charAt(n-1);  
            }
            // EXIT FROM PROCEDURE NO NEED TO PROCESS FUTHER
            if ( decodedS.isEmpty() ) {
                return "Empty String";
            }
        } while (decodedS.length() < originalS.length() );
        
        return decodedS;
    } // the end of procedure

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();
        // The test cases used to debug during the first version of the dirty code, that has been based on wrong while-cycle based instead of correct do-while approach
        //String s = "ppffccmmssnnhhbbmmggxxaaooeeqqeennffzzaaeeyyaaggggeessvvssggbbccnnrrjjxxuuzzbbjjrruuaaccaaoommkkkkxx";
        //String s = "kagoyzkgfjnyvjewazalxngpdcfahneqoqgiyjgpzobhaghmgzmnwcmeykqzgajlmuerhhsanpdtmrzibswswzjjbjqytgfewiuu";
        if (s == null || s.isEmpty() ) {
			throw new IllegalArgumentException(" Check Arguments Exception : s string is empty");
        }
        else {
            String result = super_reduced_string(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        
        bufferedWriter.close();
        scanner.close();
    } // the end of main
} // the end of class
