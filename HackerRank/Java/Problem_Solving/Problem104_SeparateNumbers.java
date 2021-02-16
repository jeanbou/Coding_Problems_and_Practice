package hackerRank_JavaProblemSolving;

import java.util.*;

public class Problem104_SeparateNumbers {

	static void separateNumbers(String s)  {
        int s_len = s.length();
        String subStrFirstIndex ="";
        int sub_s_size = 1;
        long aValue = -1;
        while ( sub_s_size <= (s_len/2)) {
            subStrFirstIndex = s.substring(0,sub_s_size);
            aValue=Long.valueOf(subStrFirstIndex);
            long nextValueInt = aValue+1;
            int indexIn = sub_s_size;
            int len_next_val = -1;
            while ( indexIn < s_len ) {
                String aNextValueStr = String.valueOf(nextValueInt);
                len_next_val = aNextValueStr.length();
                String aCutNextValueStr = "";
                if ( indexIn+len_next_val < s_len) { // we can run out of index
                    aCutNextValueStr = s.substring(indexIn,indexIn+len_next_val);
                } else {
                    aCutNextValueStr = s.substring(indexIn,s_len);
                }
                if ( !aNextValueStr.equals(aCutNextValueStr) ) {
                   break; 
                } else { // next iteration
                    nextValueInt++;
                }
                indexIn = indexIn+len_next_val;
            }
            if ( indexIn == s_len) {
                System.out.println("YES "+aValue);
                return;
            } 
            sub_s_size++;            
        }        
        System.out.println("NO");
    }
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
        // Test case 20
        // 429496729542949672964294967297
        // YES 4294967295
        // 429496729542949672964294967296
        // NO
        // 429496729542949672964294967287
        // NO
        // 429496729542949672964294967197
        // NO
        // 42949672954294967296429496729
        // NO
        // 4294967295429496729642949672
        // NO
        // 429496729500000000000000000001
        // NO
        // 42949672950123456789
        // NO
        // 4294967295000010020030000456789
        // NO
        // 4294967295000102003004005
        // NO
    }
}