package hackerRank_JavaProblemSolving;


import java.util.*;

public class Problem009_TileConvert_Solution {

    static String timeConversion(String s) {
        if (s == null || s.length() != 10) {
				throw new IllegalArgumentException(" Check Arguments Exception : Input string length : N = "+Integer.toString(s.length())+ " !\nOut of specified range of 10 characters or s == null");
		}
        
        String newFormatStr = s.substring(0,8);
        String firstTwoNumbers = s.substring(0,2);
        int newHour = Integer.parseInt(firstTwoNumbers);
        String newHourStr = "";        
        if (s.charAt(8) == 'A' && newHour == 12) {
            newHourStr = "00";
            return (newHourStr+s.substring(2,8));
        }
        else if (s.charAt(8) == 'P' && newHour == 12) {
            return s.substring(0,8);
        }
        else if (s.charAt(8) == 'A' && newHour != 12) {
            return s.substring(0,8);
        }
        else { // if (s.charAt(8) == 'P' && newHour != 12) // Actually!
            newHourStr = Integer.toString(12+newHour);
            return (newHourStr+newFormatStr.substring(2,8));
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
