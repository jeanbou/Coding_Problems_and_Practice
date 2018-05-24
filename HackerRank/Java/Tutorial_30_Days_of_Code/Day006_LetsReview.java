package hackerRank_Java30DaysOfCode;

import java.util.*;

public class Day006_LetsReview {

	    @SuppressWarnings("resource")
		public static void main(String[] args) {
	        
	    	Scanner scan = new Scanner(System.in);
		    int lineNumber = scan.nextInt();
	        
	        if (lineNumber <= 0 ) {
					throw new IllegalArgumentException(" Check Arguments Exception : Input : lineNumber = "+Integer.toString(lineNumber)+" !\nOut of specified range");
			}
	        else {
	            
	        	for (int i = 1; i <= lineNumber; i++) {
	                String aWord = scan.next().trim();
	                int aWordLength = aWord.length();
	                if (aWordLength <= 0 || aWord.isEmpty() ) {
					    throw new IllegalArgumentException(" Check Arguments Exception : Input : aWordLength = "+Integer.toString(aWordLength)+" !\nOut of specified range");
				    }
	                else {
	                    
				    	StringBuilder strEven = new StringBuilder(aWordLength/2+1);
	                    StringBuilder strOdd = new StringBuilder(aWordLength/2+1);
	                    for (int j = 0; j < aWordLength; j++ ) {
	                        if ( j % 2 == 0 ) {
	                            strEven.append(aWord.charAt(j));
	                        }
	                        else {
	                            strOdd.append(aWord.charAt(j));
	                        }
	                    } // end of for for string
	                
	                    System.out.println(strEven.toString()+" "+strOdd.toString());
	            
				    } // end of length of i-String check
	        
	            } // end of for for i-String  
	    
	        } // end of OK else     
	 
	    } // end of main

}
