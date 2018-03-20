package hackerRank_JavaProblemSolving;

import java.io.*;
import java.util.*;

public class Problem010_GradingStudents_Solution {

    static int[] gradingStudents(int[] grades) {
        
        int N = grades.length;
	    
	    if (N <= 0 ) {
			throw new IllegalArgumentException(" Check array, its size N = "+Integer.toString(N));
		}
        
        for (int i = 0; i < N; i++) {
            
            int nextUppperLimit = (int) (10*Math.floor(0.1*grades[i])+5);
            if (nextUppperLimit - grades[i] < 0) {
                nextUppperLimit += 5;
            }
            
            if (grades[i] >= 38 && (nextUppperLimit -grades[i]) <= 2) {
                grades[i] = nextUppperLimit;
            }            
        }
        
        return grades;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}