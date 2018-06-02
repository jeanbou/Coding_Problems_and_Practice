package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem024_PickingNumbers {

	// Debugging cases No, 5; 6 & 7
	static int[] o = {4, 2, 3, 4, 4, 9, 98, 98, 3, 3, 3, 4, 2, 98, 1, 98, 98, 1, 1, 4, 98, 2, 98, 3, 9, 9, 3, 1, 4, 1, 98, 9, 9, 2, 9, 4, 2, 2, 9, 98, 4, 98, 1, 3 }; 
	static int[] c = {66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66};  
    static int[] d = {64,97,5,97,97,4,97,4,97,97,97,97,4,4,5,5,97,5,97,99,4,97,5,97,97,97,5,5,97,4,5,97,97,5,97,4,97,5,4,4,97,5,5,5,4,97,97,4,97,5,4,4,97,97,97,5,5,97,4,97,97,5,4,97,97,4,97,97,97,5,4,4,97,4,4,97,5,97,97,97,97,4,97,5,97,5,4,97,4,5,97,97,5,97,5,97,5,97,97,97};
  
	
    static int pickingNumbers(int[] a) {
        
        Arrays.sort(a); // Idea that allows algorithms to be a complexity of O((n+1)*logn)
        
        int seqNum = 1;
        int prevSeqNum = 1;
        int maxSeq = seqNum;
        int minValOfSubSeq = a[0];
        
        for (int i = 0; i < a.length-1; i++ ) {
            
        	if (a[i] == a[i+1]) { // calculation of one value subsequence
                seqNum++;                
            }
            else { // Then new value jump up
                if (a[i+1] - a[i] == 1 ) { // The differences are OKay, it required to continue counting
                    prevSeqNum = seqNum;
                    if (a[i+1] - minValOfSubSeq == 1) { // Playing with the previous lowest value of sub-sequence
                        seqNum = 1;
                    }
                    else { // No, the difference between the lowest and the highest of 1 at least 2 and more
                        minValOfSubSeq = a[i];
                        seqNum = 1;
                    }                  
                }        
                else { // Jump is to high, re-start
                    minValOfSubSeq = a[i+1];
                    prevSeqNum = 0;
                    seqNum = 1;                     
                }    
            } // the end of if else for similar/not similar values
        	
        	// DEBUGING PART
            //System.out.println(" seqNum : "+seqNum+" prevSeqNum "+prevSeqNum);
            maxSeq = Math.max(maxSeq,seqNum+prevSeqNum);
        }  
        
        // Compensatory code for all equals value in array, tiny trick that must be re-think
        if (a[a.length-1] == a[0]) {
            maxSeq--;
        }
        
        return maxSeq;

    } // the end of method

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        if (n <= 0 ) {
				throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
		}
        else {
        	int[] a = new int[n];

        	String[] aItems = scanner.nextLine().split(" ");
        	scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        	for (int i = 0; i < n; i++) {
        		int aItem = Integer.parseInt(aItems[i]);
        		a[i] = aItem;
        	}
        
        	// DEGUNING CODE FOR TEST for cases No. 5; 6 & 7
        	// int result = pickingNumbers(o); Expected 22        
        	// int result = pickingNumbers(b); // Expected 100 
        	// int result = pickingNumbers(d); // Expected 50
        	
        	int result = pickingNumbers(a);
        	
        	bufferedWriter.write(String.valueOf(result));
        	bufferedWriter.newLine();
        }
        
        bufferedWriter.close();

        scanner.close();
        
    } // the end of main

} // the end of class