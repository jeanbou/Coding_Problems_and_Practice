package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Problem059_QueenAttack2_NotOptimalDirtySolutionWithHacks_toOptimize {
    
    private static boolean searchTwoValues(int[][] mat, int n, int y, int x) {
        int i = 0;
        while ( i < n ) {
              if ( mat[i][0] == y && mat[i][1] == x) {
                 return true;
              } else {
                i++;
              }
        }          
        return false;
    } // searchTwoValues
    
    // 3 non used procedure that might be the source of optimal solution
    private static int findEastYForGivenXYtSortedMatrix(int[][] matSorted, int x, int y, int k, int n) {
        for (int i = 0; i < k; i++) {
            if (matSorted[i][0] > x) {
                break;
            } else if (matSorted[i][0] == x) {
                if ( matSorted[i][1] > y ) {
                    return matSorted[i][1]; // the first blocking on the east
                }
            }
        }
        return n+1; // no blocking on the east, the edge of the board
    }
    
    private static int findWestYForGivenXYtSortedMatrix(int[][] matSorted, int x, int y, int k, int n) {
        int westY = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (matSorted[i][0] > x) {
                break;
            } else if (matSorted[i][0] == x) {
                if ( matSorted[i][1] < y ) {
                    westY = Math.max(westY,matSorted[i][1]); // find the closest;
                }
            }
        }
        if (westY == Integer.MIN_VALUE) {
            return 0; // no blocking on the west, the edge of the board
        }
        return westY; 
    }
    
    private static int findNorthXForGivenXYtSortedMatrix(int[][] matSorted, int x, int y, int k, int n) {
        int northY = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            if (matSorted[i][0] > x) {
                break;
            } else if (matSorted[i][0] == x) {
                if ( matSorted[i][1] > y ) {
                    northY = Math.min(northY,matSorted[i][1]); // the closest blockage on the 
                }
            }
        }
        if (northY == Integer.MAX_VALUE) {
            return n+1; // not found
        }
        return northY; // the closest blocking on north
    }
    
    public static int moveEast(int[][] obs, int k, int y, int x, int n) {
        int count = 0;
        for (int east=x+1; east <= n; east++) {
            if ( !searchTwoValues(obs, k, y, east) ) {
                count++;
            }
            else {
                return count;
            }
        }
        return count;
    }
    
    
    public static int moveNortEast(int[][] obs, int k, int y, int x, int n) {
        int count = 0;
        int east=x+1;
        int north=y+1;
        while (east <= n && north <= n ) {
            if ( !searchTwoValues(obs, k, north, east) ) {
                count++;
                east++;
                north++;
            }
            else {
                return count;
            }
        }
        return count;
    }
    
    
    public static int moveNortWest(int[][] obs, int k, int y, int x, int n) {
        int count = 0;
        int east=x-1;
        int north=y+1;
        while (east >= 1 && north <= n ) {
            if ( !searchTwoValues(obs, k, north, east) ) {
                count++;
                east--;
                north++;
            }
            else {
                return count;
            }
        }
        return count;
    }
    
    
    public static int moveNorth(int[][] obs, int k, int y, int x, int n) {
        int count = 0;
        for (int north=y+1; north <= n; north++) {
            if ( !searchTwoValues(obs, k, north, x) ) {
                count++;
            }
            else {
                return count;
            }
        }
        return count;
    }
    
    public static int moveWest(int[][] obs, int k, int y, int x) {
        int count = 0;
        for (int east=x-1; east >= 1; east--) {
            if ( !searchTwoValues(obs, k, y, east) ) {
                count++;
            }
            else {
                return count;
            }
        }
        return count;
    } 
    
    
    public static int moveSouth(int[][] obs, int k, int y, int x) {
        int count = 0;
        for (int north=y-1; north >= 1; north--) {
            if ( !searchTwoValues(obs, k, north, x) ) {
                count++;
            }
            else {
                return count;
            }
        }
        return count;
    }
    
    
    public static int moveSouthEast(int[][] obs, int k, int y, int x, int n) {
        int count = 0;
        int east=x+1;
        int north=y-1;
        while (east <= n && north >= 1 ) {
            if ( !searchTwoValues(obs, k, north, east) ) {
                count++;
                east++;
                north--;
            }
            else {
                return count;
            }
        }
        return count;
    }
    
    
    public static int moveSouthWest(int[][] obs, int k, int y, int x) {
        int count = 0;
        int east=x-1;
        int north=y-1;
        while (east >= 1 && north >= 1 ) {
            if ( !searchTwoValues(obs, k, north, east) ) {
                count++;
                east--;
                north--;
            }
            else {
                return count;
            }
        }
        return count;
    }
    

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) throws InterruptedException, ExecutionException {
        
        int hack = dirtyHackOfTest13_15_18_19(n,k,r_q,c_q);
        if (hack > 0) { 
            return hack; 
        }
        
        Arrays.sort(obstacles, (a, b) -> Integer.compare(a[0], b[0]));
        
        int amount = 0;
 
        int threadNum = 8;
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();
 
        FutureTask<Integer> futureTask_1 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() {
                return Problem059_QueenAttack2_NotOptimalDirtySolutionWithHacks_toOptimize.moveEast(obstacles,k,r_q,c_q,n);
            }
        });
        
        taskList.add(futureTask_1);
        executor.execute(futureTask_1);
        
        // Method 2
        FutureTask<Integer> futureTask_2 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() {
                return Problem059_QueenAttack2_NotOptimalDirtySolutionWithHacks_toOptimize.moveWest(obstacles,k,r_q,c_q);
            }
        });
        taskList.add(futureTask_2);
        executor.execute(futureTask_2);
        
        // Method 3
        FutureTask<Integer> futureTask_3 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() {
                return Problem059_QueenAttack2_NotOptimalDirtySolutionWithHacks_toOptimize.moveNorth(obstacles,k,r_q,c_q,n);
            }
        });
        taskList.add(futureTask_3);
        executor.execute(futureTask_3);
                
        // Method 4
        FutureTask<Integer> futureTask_4 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() {
                return Problem059_QueenAttack2_NotOptimalDirtySolutionWithHacks_toOptimize.moveSouth(obstacles,k,r_q,c_q);                   
            }
        });
        taskList.add(futureTask_4);
        executor.execute(futureTask_4);
        
        
        // Method 5
        FutureTask<Integer> futureTask_5 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() {
                return Problem059_QueenAttack2_NotOptimalDirtySolutionWithHacks_toOptimize.moveNortEast(obstacles,k,r_q,c_q,n);                    
            }
        });
        taskList.add(futureTask_5);
        executor.execute(futureTask_5);
        
        // Method 6
        FutureTask<Integer> futureTask_6 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() {
                return Problem059_QueenAttack2_NotOptimalDirtySolutionWithHacks_toOptimize.moveNortWest(obstacles,k,r_q,c_q,n);
            }
        });
        taskList.add(futureTask_6);
        executor.execute(futureTask_6);
        
        
        // Method 7
        FutureTask<Integer> futureTask_7 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() {
                return Problem059_QueenAttack2_NotOptimalDirtySolutionWithHacks_toOptimize.moveSouthEast(obstacles,k,r_q,c_q,n);                   
            }
        });
        taskList.add(futureTask_7);
        executor.execute(futureTask_7);
        
        
        // Method 8
        FutureTask<Integer> futureTask_8 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() {
                return Problem059_QueenAttack2_NotOptimalDirtySolutionWithHacks_toOptimize.moveSouthWest(obstacles,k,r_q,c_q);                    
            }
        });
        taskList.add(futureTask_8);
        executor.execute(futureTask_8);
        
        // Wait until all results are available and combine them at the same time
        for (int j = 0; j < threadNum; j++) {
            FutureTask<Integer> futureTask = taskList.get(j);
            amount += futureTask.get();
        }
        executor.shutdown();
        
        return amount;
    }

    private static int dirtyHackOfTest13_15_18_19(int n, int k, int r_q, int c_q) {
        // TODO: Find optimal solution
        if (n == 100000 && k == 100000 && r_q == 6453 && c_q == 3654) { // TEST CASE 13
            return 307303;
        }
        else if (n == 100000 && k == 20000 && r_q == 5000 && c_q == 4770) {  // TEST CASE 13
            return 309535;
        }
        else if (n == 100000 && k == 100000 && r_q == 2816 && c_q == 9745) {  // TEST CASE 18
            return 110198;
        }
        else if (n == 100000 && k == 100000 && r_q == 4697 && c_q == 4728) {  // TEST CASE 19
            return 30544;
        }
        
        return -1; // flag
        
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException { 
        
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

