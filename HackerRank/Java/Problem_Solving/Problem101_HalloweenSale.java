package hackerRank_JavaProblemSolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Task description, stored in cash
// https://webcache.googleusercontent.com/search?q=cache:PSCXlPhXVqMJ:https://www.hackerrank.com/challenges/halloween-sale%3Fh_r%3Dprofile+&cd=1&hl=fr&ct=clnk&gl=lu
// Never used solution from GitHub https://github.com/charles-wangkai/hackerrank/blob/master/halloween-sale/Solution.java
// It means I never checked it, plus it has its' dumm cycle. No need O(1) is fine

/* Given task given test - cases
 20 3 6 80 :: Output 6
 20 3 6 85 :: OUtput 7
 
 */

/* Unlocked failed test case for 5 hackos 
 
Input (stdin)
Download
16 2 1 9981
Expected Output
Download
9917
 
 */
 
public class Problem101_HalloweenSale {

    static int howManyGames_FirstTryIneficientComputationalGreedyCode(int p, int d, int m, int s) {
        int counter = 0;
        int sum = 0;
        int price = p;
        while ( sum <= s ) {
            sum += price;
            counter++;
            if (price > m) {
                price -= d;
            } else {
                price = m;                
            }
        }
        /*if (sum == s) {
            return counter;
        }*/
        return counter-1;
    }

    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
    	if (s < p) { // dummy user input
    		return 0;
    	} else if (s == p) { // less dummy input
    		return 1;
    	}
    	// an=p - last element and a1 = first element that we don't know, but we have a limit m
    	// Using arythm-progression smart math battery of simple formulas https://en.wikipedia.org/wiki/Arithmetic_progression
    	// Let's figure out in a smart way a1 which is >= m (principal condition)
    	int n = p/d;    	
    	int a1 = p- n*d;
    	//System.out.println("a1Tilda :"+ a1);
    	if (a1 < m ) { // it does not mean that m in such way is the lowest member of arythm progression
    		a1 = m + (p - m) % d;    		
    	}
    	int N =  (p - a1) / d + 1;
    	int sumOfEstimatedArythmProgression = ( p + a1 ) * N / 2;
    	if ( sumOfEstimatedArythmProgression > s) { // Standard, dummy run because we don't know in terms of formula S(mn) two variable m and am and S(mn) is approximate (arround of s)
    		// Usually we never go there, because we well estimated our a1 that is actually am in terms of formular
			return howManyGames_FirstTryIneficientComputationalGreedyCode(p, d, m, s);	
    	} else { // The rest
    		int restOFS = s - sumOfEstimatedArythmProgression;
    		if (restOFS < d) { // perfect match with arythm-progression
    			return N;
    		} else { // restOFS >= d    		
    			return (N + (restOFS / m));
    		} 		
    	}    	        
    } // end of howManyGames
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        
        // Debugging reasons
        //System.out.println(howManyGames(16, 2, 1, 9981));
    	//System.out.println(howManyGames_FirstTryIneficientComputationalGreedyCode(16, 2, 1, 9981));
        
    } // main
} 
