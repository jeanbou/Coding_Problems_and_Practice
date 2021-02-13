package hackerRank_JavaProblemSolving;

import java.io.*;
import java.util.*;

public class Problem103_TheGridSearch {    
    // TEST CASE 12
    // 1
    // 4 6
    // 123456
    // 567890
    // 234567
    // 194729
    // 4 4
    // 1234
    // 5678
    // 2345
    // 4729
    // Expected output NO
    
    // TEST CASE 14
    // 1
    // 4 6
    // 456712
    // 561245
    // 123667
    // 781288
    // 2 2
    // 45
    // 67
    // Expected output YES
    
    // TEST CASE 15
    // 1
    // 7 15
    // 111111111111111
    // 111111111111111
    // 111111111111111
    // 111111011111111
    // 111111111111111
    // 111111111111111
    // 101010101010101
    // 4 5
    // 11111
    // 11111
    // 11111
    // 11110
    // EXPECTED OUTPUT YES
   
	// CREDITS : // https://github.com/IMS94/Hacker-Rank/blob/master/java/src/hackerrank/practice/moderate/GridSearch.java
	static String gridSearch(String[] G, String[] P) {
        int k=0;
        int xa=0;
        ou:
        for(int x=0;x<G.length;x++)
        {
            if(G[x].contains(P[0]))
            {
                k=x;
                xa=G[x].indexOf(P[0]);
                int l=P[0].length();
                int y=1;                
                while(y<P.length)
                {
                    String s=G[x+1].substring(xa,xa+l);
                    if(!(s.equals(P[y])))
                    {
                        x=k-1;
                        G[k]=G[k].substring(0,xa)+"#"+G[k].substring(xa+1);
                        continue ou;
                    }
                    y++;
                    x++;
                }
                return "YES";
            }
        }
        return "NO";
    } // not mine :: see credits

	
	// Mine Implementation TODO: Does not work on a Test case No. 5
    static String gridSearch2Debug(String[] G, String[] P) {
        int g_size = G.length;
        int p_size = P.length;        
        int next_i = 0;
        int start_index_of = 0;
        while (next_i < g_size) {
            if ( G[next_i].contains(P[0]) ) {
                start_index_of = G[next_i].indexOf(P[0]);
                break;
            }
            next_i++;
        }
        if (next_i == g_size) {
            return "NO";
        }
        boolean isStartIndReInitialized = false;
        int pat_len = P[0].length();
        int j = 1;
        next_i++;
        while ( j < p_size ) {
            String cutStr = G[next_i].substring(start_index_of, start_index_of+pat_len);
            if (!cutStr.equals(P[j])) {
                if ( G[next_i].contains(P[j]) && !isStartIndReInitialized ) { // roll back and check is it possible to do the same but from different starting index
                    start_index_of = G[next_i].indexOf(P[j]);
                    int new_j = j-1;
                    int new_next_i = next_i-1;
                    while ( new_j >= 0 ) { // going backward
                       String newCutStr = G[new_next_i].substring(start_index_of, start_index_of+pat_len);
                        if (!newCutStr.equals(P[new_j])) {
                            return "NO";
                        }
                        new_next_i--; 
                        new_j--;
                    }
                    isStartIndReInitialized = true;                    
                }
                else if (!G[next_i].contains(P[j]) && !isStartIndReInitialized && G[next_i].contains(P[j-1]) ) { // no shift possible
                	start_index_of = G[next_i].indexOf(P[j-1]);
                	isStartIndReInitialized = true;
                	j--;
                }
                else if ( isStartIndReInitialized && G[next_i].contains(P[j]) && G[next_i-1].contains(P[j-1]) ) {
                	
                	start_index_of = G[next_i].indexOf(P[j]);
                	String newCutStr = G[next_i-1].substring(start_index_of, start_index_of+pat_len);
                	if (!newCutStr.equals(P[j-1])) {
                    	return "NO";
                    }		
                }
                else {
                	return "NO";
                }
            }
            /*else if ( G[next_i].contains(P[j-1]) && !isStartIndReInitialized ) { // shift
                start_index_of = G[next_i].indexOf(P[j-1]);
                j--;
                //isStartIndReInitialized = false;
            } */
            j++;
            next_i++;
        }
        return "YES";
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    	
        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }
    	
    		// TEST CASE 14 DEBUGING Expected Yes
        	/*
    		String[] G = new String[] { "456712",
    		"561245",
    		"123667",
    		"781288"};
    		String[] P = new String[] { "45",
    		"67"};
    		*/
    	    
    	    // TEST CASE 15 Debugging
    	    // Expected Yes
    		/*String[] G = new String[] { "111111111111111",
    		"111111111111111",
    		"111111111111111",
    		"111111011111111",
    		"111111111111111",
    		"111111111111111",
    		"101010101010101"};
    		
    		String[] P = new String[] { "11111",
    	    "11111",
    	    "11111",
    	    "11110"};*/
    	
    	    // TEST CASE 12
    		// Expected No
    	    /*
    		String[] G = new String[] {"123456",
    		"567890",
            "234567",
            "194729"};
    		String[] P = new String[] { "1234",
    		"5678",
    		"2345",
            "4729"};
    		*/
    		// TEST 01 Expected output YES
    		/*String[] G = new String[] {"7283455864",
    				"6731158619",
    				"8988242643",
    				"3830589324",
    				"2229505813",
    				"5633845374",
    				"6473530293",
    				"7053106601",
    				"0834282956",
    				"4607924137"};
    		String[] P = new String[] { "9505",
    				"3845",
    				"3530"};
    		*/
    		// TEST 02 Expected output No
    	/*String[] P = new String[] { "400453592126560",
    	"114213133098692",
    	"474386082879648",
    	"522356951189169",
    	"887109450487496",
    	"252802633388782",
    	"502771484966748",
    	"075975207693780",
    	"511799789562806",
    	"404007454272504",
    	"549043809916080",
    	"962410809534811",
    	"445893523733475",
    	"768705303214174",
    	"650629270887160"};
    	String[] G = new String[] { "99",
				"99"};*/
    	
    	// TEST CASE 7  
        // 4 6
    	/*String[] G = new String[] { "123412",
    			"561212",
    			"123634",
    			"781288"};
        String[] P = new String[] { "12",
        				"34"};*/
        // Expected output YES
    	
        	String result = gridSearch(G, P);
        	
        	//To Debug
            //String result = gridSearch2Debug(G, P);
        	// Debug
        	// System.out.println(result);
        	
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    	
    }

} // the end of problem 103
