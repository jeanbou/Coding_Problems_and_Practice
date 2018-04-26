package hackerRank_JavaProblemSolving;

import java.io.IOException;
import java.util.Scanner;

public class Problem029_Climbing_Leader_Board {
    
    // Hacker ranks comments based vesion O(n+m), no binary search approach
    static void climbingLeaderboardHackerRanksVersion(int n,int m,int[] alice,int[] scores) { // The signature changes
        
        int[] rank = new int[n];
        rank[0] = 1; // init
    
        for (int i=1; i<n; i++) {
            if(scores[i] < scores[i-1]){
                rank[i] = rank[i-1] + 1;
            }
            else{
                rank[i] = rank[i-1];
            }
        }    
    
        int k = n-1;
    
        for(int i=0; i < m; i++) {
            
            while( k>=0 && alice[i] >= scores[k] ) {
                k--;
            }
            
            if(k >= 0) {
                System.out.println(rank[k]+1);
            } else {
                System.out.println("1");
            }
        } // The end of For       
    } // The end of climbingLeaderboard based on the comment Hacker Rank Version
    
    
    
    // My personal draft unaccomplished version
    /*static int[] climbingLeaderboard(int[] scores, int[] alice) {
        
        int [] ranking = new int[alice.length];
        
        // Based on the idea that the scores & alice score are already sorted arrays
        // Such nice logic imput allows programmer to make code more efficient
        int lastInd = scores.length-1; 
        
        for (int i = 0; i < alice.length; i++) {
            // Completely dirty code
            //if (scores[lastInd] >= alice[i]) {
            //    System.out.print(" lastInd : "+lastInd+" score "+scores[lastInd]);
            //    ranking[0] = lastInd;
            //    lastInd--;
            //}
            // The end of completely dirty code
            System.out.println(" i : "+i+" alice "+alice[i]);
            for (int j = lastInd; j > 1 && alice[i] >= scores[j]; j--) {
                System.out.println(" j : "+j+" scorej "+scores[j]+" j-1 : "+(j-1)+" scorej-1 "+scores[j-1]);
                if (scores[j] <= alice[i] && alice[i] <= scores[j-1]) {
                    lastInd = j-1;
                    // Important part, the next alice score can be equal to its previous one in this case the ranking should be the same, but we need to increment i and move on allice array
                    i--;
                    do {
                        i++;
                        ranking[i] = j-1;
                        System.out.println("i ranking[i] "+i+" "+ranking[i]+" alice i : "+alice[i]);                    
                    } while (i < alice.length-1 && alice[i] == alice[i+1] );
                    // Break from index j-for-cycle
                    break;
                }
            } // the end of for for comparison
            ranking[i] = lastInd;
        } // the end of for for alice scores      
        
        if (alice[alice.length-1] > scores[scores.length-1]) {
            ranking[alice.length-1] = 1;
        }
        
        //System.out.println(i+" "+j+" "+lastInd+" alice i "+alice[i]+" sroce-j "+scores[j]);
        //if (ranking[ranking.length-1] == 0) {
        //    ranking[ranking.length-1] = 1;
        //}
        
        return ranking;
    }*/
    
    // NOT WORKING BINARY SEARCH O(n+mlogn) version, dropped it, because we have better O(n+m) solution above
    /*
    static int[] climbingLeaderboard(int[] scores, int n, int[] alice)
    {
        int m = alice.length;
        int [] ranking = new int[m];
        int [] array = range(0,n).map(i->scores[n-i-1]).distinct().toArray();
        int index = 0;
        for(int i = 0; i < m; i++) {
            int score = alice[i];
            index = binarySearch(array, index<0?0:index, m, score);
            if(index<0) index=-index-2;
            System.out.println(array.length-index);
            //ranking[i] = m-index;
        }
        return ranking;
    }
    */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        // NO NEED OF BUFFER WRITER AS OUTPUT
        // SIMPLE HACK OF THIS TEST
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        /*int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                
        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }*/
        
        // New Scanner Reading
        int n = scanner.nextInt();
        if (n <= 0 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input : n = "+Integer.toString(n)+" !\nOut of specified range");
        }
        int[] scores = new int[n];
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        if (m <= 0 ) {
			throw new IllegalArgumentException(" Check Arguments Exception : Input : m = "+Integer.toString(m)+" !\nOut of specified range");
        }
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = scanner.nextInt();
        }
        
        scanner.close();
        
        // TEST CASE 1 
        //int [] sr = {295,294,291,287,287,285,285,284,283,279,277,274,274,271,270,268,268,268,264,260,259,258,257,255,252,250,244,241,240,237,236,236,231,227,227,227,226,225,224,223,216,212,200,197,196,194,193,189,188,187,183,182,178,177,173,171,169,165,143,140,137,135,133,130,130,130,128,127,122,120,116,114,113,109,106,103,99,92,85,81,69,68,63,63,63,61,57,51,47,46,38,30,28,25,22,15,14,12,6,4};
        //int [] ac = {5,5,6,14,19,20,23,25,29,29,30,30,32,37,38,38,38,41,41,44,45,45,47,59,59,62,63,65,67,69,70,72,72,76,79,82,83,90,91,92,93,98,98,100,100,102,103,105,106,107,109,112,115,118,118,121,122,122,123,125,125,125,127,128,131,131,133,134,139,140,141,143,144,144,144,144,147,150,152,155,156,160,164,164,165,165,166,168,169,170,171,172,173,174,174,180,184,187,187,188,194,197,197,197,198,201,202,202,207,208,211,212,212,214,217,219,219,220,220,223,225,227,228,229,229,233,235,235,236,242,242,245,246,252,253,253,257,257,260,261,266,266,268,269,271,271,275,276,281,282,283,284,285,287,289,289,295,296,298,300,300,301,304,306,308,309,310,316,318,318,324,326,329,329,329,330,330,332,337,337,341,341,349,351,351,354,356,357,366,369,377,379,380,382,391,391,394,396,396,400};
        
        // OLD CODE OLD METHOD SEE THE COMMENT ABOVE
        //int[] result = climbingLeaderboard(scores, alice);
        // NEW METHOD, NEW SIGNATURE
        climbingLeaderboardHackerRanksVersion(n, m, alice,scores);
        
        // TASk HACKED NO NEED OF BUFFER, SEE DESCRIPTION ABOVE
        /*
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
        */
        
    
    } // The end of main
}
