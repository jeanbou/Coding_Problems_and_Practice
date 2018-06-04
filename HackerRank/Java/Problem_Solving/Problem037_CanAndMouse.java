package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem037_CanAndMouse {
    
    // Calculate the absolute distance for uni-dimensional position of object
    static int absoluteXDist(int x1,int x2) {
        return Math.abs(x1-x2);
    }

    static String catAndMouse(int x, int y, int z) {
        
        if (absoluteXDist(x,z) < absoluteXDist(y,z)) {
            return "Cat A";
        }
        else if (absoluteXDist(x,z) > absoluteXDist(y,z)) {
            return "Cat B";
        }        
        return "Mouse C";
        
    } // cat and Mouse method

    private static final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (q <= 0 ) {
			     throw new IllegalArgumentException(" Check Arguments Exception : Input : q = "+Integer.toString(q)+" !\nOut of specified range");
	   }
        else {
            for (int qItr = 0; qItr < q; qItr++) {
                String[] xyz = scanner.nextLine().split(" ");

                int x = Integer.parseInt(xyz[0]);

                int y = Integer.parseInt(xyz[1]);

                int z = Integer.parseInt(xyz[2]);

                String result = catAndMouse(x, y, z);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.close();

        scanner.close();
    } // the end of main
    
} // the end of class
