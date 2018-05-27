package hackerRank_Java30DaysOfCode;

import java.util.*;

import java.util.regex.*;

public class  Day028_RexExpression_andSorting {

	    private static final Scanner scanner = new Scanner(System.in);
	    
	    // CREDITS http://zparacha.com/java-regex-to-validate-gmail-address
	    public static boolean isGmailAddress(String emailAddress) {
			String expression = "^[\\w.+\\-]+@gmail\\.com$";
			CharSequence inputStr = emailAddress;
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(inputStr);
			return matcher.matches();
		}

	    public static void main(String[] args) {
	        int N = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        
	        ArrayList<String> listofExtractedNames = new ArrayList<String>();

	        for (int NItr = 0; NItr < N; NItr++) {
	            String[] firstNameEmailID = scanner.nextLine().split(" ");
	            if (isGmailAddress(firstNameEmailID[1])) {
	                listofExtractedNames.add(firstNameEmailID[0]);
	            }
	        }

	        scanner.close();
	        
	        Collections.sort(listofExtractedNames);
	        for(String name: listofExtractedNames){
				System.out.println(name);
			}
	    }
	}
