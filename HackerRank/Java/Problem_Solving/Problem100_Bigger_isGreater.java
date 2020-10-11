package hackerRank_JavaProblemSolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Problem100_Bigger_isGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreaterWithBug(String w) {
        int len = w.length();
        String outputStr = new String("no answer");
        if (len < 2) {
        	return outputStr;
        }
        char endChar = w.charAt(len-1);
        if (len == 2 ) {
        	char firstChar = w.charAt(0);
        	if ( firstChar < endChar) {
        		String s = new StringBuilder().append(endChar).append(firstChar).toString();
        		return s;
        	}
        	return outputStr;
        }
        // More complicated case for
        StringBuilder withoutOneCharStr = new StringBuilder(w);
        String withoutOneCharStrSoreted = "";
        boolean noFirstSwitch = true;
        for (int i=len-1; ( i>=0 && noFirstSwitch ) ; i--) {
        	endChar = w.charAt(i);
        	for (int j=i-1; ( j>=0 && noFirstSwitch ) ; j--) {
        		char beforeChar = w.charAt(j);
        		if (endChar > beforeChar) { // identified a character for first switch
        			noFirstSwitch = false;
        			// switching two characters in string using Geek for Geek code
    				StringBuilder sb = new StringBuilder(w); 
    		        sb.setCharAt(i, w.charAt(j)); 
    		        sb.setCharAt(j, w.charAt(i)); 
    		        String newStringSwapedOneCharStr = sb.toString();
    		        if (i == len-1) { // we need only one switch and it's OK
    		        	return newStringSwapedOneCharStr;    		        	
        			}
        			char tempArray[] = withoutOneCharStr.deleteCharAt(i).toString().toCharArray(); // remove last character;
        			// sorting in alphabetic order the string without one character 
        			Arrays.sort(tempArray); 
        			withoutOneCharStrSoreted = new String(tempArray);        	         
        		}
        	}
        }
        if ( noFirstSwitch ) {
        	return outputStr;
        }
        // Switch was done
        return ( ( new StringBuilder().append(endChar).toString() ) + withoutOneCharStrSoreted );
        
    }
    
    // Solution from GitHub
    // Credits to https://github.com/JohnCanessa/Bigger-is-Greater/blob/master/Solution.java
    /*
     * Remove the last character in the string and put it into the bucket.
     */
    static void lastCharToBucket(StringBuilder sb, TreeMap<Character, Integer> bucket) {
      // **** put last character into bucket ****
      if (bucket.containsKey(sb.charAt(sb.length() - 1))) {
        int count = bucket.get(sb.charAt(sb.length() - 1));
        count++;
        bucket.put(sb.charAt(sb.length() - 1), count);
      } else {
        bucket.put(sb.charAt(sb.length() - 1), 1);
      }

      // **** remove last character from string ****
      sb.deleteCharAt(sb.length() - 1);
    }

    /*
     * Append char to string and remove from bucket (if needed).
     */
    static void appendCharRemoveFromBucket(char ch, StringBuilder sb, TreeMap<Character, Integer> bucket) {

      // **** append character to string ****
      sb.append(ch);

      // **** remove character from bucket or decrement count ****
      int count = bucket.get(ch);
      if (count == 1)
        bucket.remove(ch);
      else
        bucket.put(ch, --count);
    }

    /*
     * Complete the biggerIsGreater function below.
     */
    static String biggerIsGreater(String w) {

      // **** check for single character ****
      if (w.length() <= 1) {
        return "no answer";
      }

      // **** create a character bucket ****
      TreeMap<Character, Integer> bucket = new TreeMap<Character, Integer>();

      // **** for ease of use ****
      StringBuilder sb = new StringBuilder(w);

      // **** go left looking for smaller character ****
      while (sb.length() > 1) {

        // **** move last character in string into the bucket ****
        lastCharToBucket(sb, bucket);

        // **** check if larger character in bucket ****
        Map.Entry<Character, Integer> entry = bucket.higherEntry(sb.charAt(sb.length() - 1));
        if (entry != null) {
          break;
        }

      }

      // **** ****
      if (bucket.isEmpty())
        return "no answer";

      // **** look in bucket for the smallest character larger than this one ****
      Map.Entry<Character, Integer> entry = bucket.higherEntry(sb.charAt(sb.length() - 1));

      // **** no character found ****
      if (entry == null)
        return "no answer";

      // ***** for ease of use ****
      char ch = entry.getKey();

      // **** move last character in string into the bucket ****
      lastCharToBucket(sb, bucket);

      // **** append character to string and remove from bucket ****
      appendCharRemoveFromBucket(ch, sb, bucket);

      // **** loop appending characters (in ascending order) from bucket ****
      while (!bucket.isEmpty()) {

        // **** get smallest character from bucket ****
        ch = bucket.firstKey();

        // **** append character to string and remove from bucket ****
        appendCharRemoveFromBucket(ch, sb, bucket);

      }

      // **** return edited string ***
      return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
	
}
