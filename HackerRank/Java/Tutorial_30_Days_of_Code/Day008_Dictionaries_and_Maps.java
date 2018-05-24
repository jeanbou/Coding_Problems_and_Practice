package hackerRank_Java30DaysOfCode;

import java.util.*;

public class Day008_Dictionaries_and_Maps {
    
    @SuppressWarnings("resource")
	public static void main(String []argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // Protective part of code
        if (n <= 0 ) {
				throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
		}
        else {
            Map<String, Integer> myPhoneBookMap = new HashMap<String, Integer>();
            for(int i = 0; i < n; i++) {
                String name = in.next();
                int phone = in.nextInt();
                // put data into phone book
                if ( name == null || name.isEmpty() ) {
				    System.out.println("Input : name is null or empty");                 
                }
                else {
                    myPhoneBookMap.put(name, phone);
                }
            } // the end of for, which puts data into map
            
            // read new data to check
            while(in.hasNext()){
                String s = in.next();
                if ( s == null || s.isEmpty() ) {
				    System.out.println(" Check Arguments Exception : s : name to find in phone book is null or empty");
                }
                else if ( myPhoneBookMap.containsKey(s) ) {
                        System.out.println(s+"="+myPhoneBookMap.get(s));
                }
                else {
                     System.out.println("Not found");
                } // end of printing if
            } // end of if which check the correcness of key to search
        } // end of searching name in phone book
        
        // close input
        in.close();
    } // the end of main    
  
} // the end of class
