package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem058_NonDivisibleSubset__MuthukoyaSolution {

    // CREDITS : Adil Muthukoya
    // https://www.hackerrank.com/Adil_Muthukoya?hr_r=1
    static int nonDivisibleSubset(int k, int[] S) { // Direct O(n*n/2) direct solution that fails on TEST 2 that doesn't clear why expected result is 5 and not 6 (whole set)
        // Lack of explanation, but there is a clarifying solution from Adil Muthukoya
        int n = S.length;
        Set<Integer> setOfUniqueIndexes = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if ((S[i]+S[j])%k != 0) {
                    setOfUniqueIndexes.add(S[i]);
                    setOfUniqueIndexes.add(S[j]);
                }
            }            
        }
        
        return setOfUniqueIndexes.size();
    } // nonDivisibleSubset

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }
        // 2 7 12 17 22 Test Case 1
        // 5 Expected
        //int [] s1 = {2, 7, 12, 17, 22} ;
        //int result = nonDivisibleSubset(5, s1);
        
        // Test Case 2 THAT SHOWS LACK OF EXPLANATION WHY 5 and not 6 ?       
        // 5 Expected
        //int [] s2 = {422346306, 940894801, 696810740, 862741861, 85835055, 313720373} ;
        //int result = nonDivisibleSubset2(9, s2);
        
        // CREDITS : Adil Muthukoya's solution
        int count=0;
        int b[]=new int[k+1];
        for(int i=0;i<n;i++) {
            b[S[i]%k]=b[S[i]%k]+1;
        }
        int cond=(k%2==0)?k/2:(k/2)+1;
        for(int j=0;j<cond;j++) { 
            if(b[0]!=0&&j==0) {
               count++;
            }
            else {
                count+=(b[j]>b[k-j])?b[j]:b[k-j];
            }
        }
        if( k % 2 == 0 ) {
           count+=1;
        }   
        //bufferedWriter.write(String.valueOf(result));
        
        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
