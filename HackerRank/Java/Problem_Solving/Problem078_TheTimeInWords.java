package hackerRank_JavaProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Problem078_TheTimeInWords {
    
    // CREDITS : https://www.programcreek.com/2014/05/leetcode-integer-to-english-words-java/
    static private HashMap<Integer, String> map = new HashMap<Integer, String>();
    
    static private String numberToWords(int num) {
        fillMap();
        StringBuilder sb = new StringBuilder();
 
        if(num==0){
            return map.get(0);
        }
 
        if(num >= 1000000000){
            int extra = num/1000000000;
            sb.append(convert(extra) + " Billion");
            num = num%1000000000;
        }
 
        if(num >= 1000000){
            int extra = num/1000000;
            sb.append(convert(extra) + " Million");
            num = num%1000000;
        } 
 
        if(num >= 1000){
            int extra = num/1000;
            sb.append(convert(extra) + " Thousand");
            num = num%1000;
        } 
 
        if(num > 0){
            sb.append(convert(num));
        }
 
        return sb.toString().trim();
    }
 
    static private String convert(int num){
 
        StringBuilder sb = new StringBuilder();
 
        if(num>=100){
            int numHundred = num/100;
            sb.append(" " +map.get(numHundred)+ " Hundred");
            num=num%100;
        }
 
        if(num > 0){
            if(num>0 && num<=20){
                sb.append(" "+map.get(num));
            }else{
                int numTen = num/10;
                sb.append(" "+map.get(numTen*10));
 
                int numOne=num%10;
                if(numOne>0){
                    sb.append(" " + map.get(numOne));
                }
            }
        }
 
        return sb.toString();
    }
 
    static private void fillMap(){
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
    }
    // THE END OF LEETCODE SOURCE

    static final private String O_CLOCK_STR = "o\' clock";
    static final private String HALFPAST_STR = "half past";
    static final private String QUARTER_PAST_STR = "quarter past";
    static final private String QUARTER_TO_STR = "quarter to";
    static final private String MINUTES_TO_STR = "minutes to";
    static final private String MINUTE_TO_STR = "minute to";
    static final private String MINUTES_PAST_STR = "minutes past";
    static final private String MINUTE_PAST_STR = "minute past";
    
    static private int overClock(int h) {
        if ( h > 12) {
            return (h-12);
        }
        return h;
    }
    
    static private String timeInWords(int h, int m) {
        String res = "";
        if ( m == 0) {
            res = numberToWords(h).toLowerCase()+" "+O_CLOCK_STR;
        }
        else if (m == 30) {
            res = HALFPAST_STR+" "+numberToWords(h).toLowerCase();
        }
        else if (m == 15) {
            res = QUARTER_PAST_STR+" "+numberToWords(h).toLowerCase();
        }
        else if (m == 45) {
            res = QUARTER_TO_STR+" "+numberToWords(overClock(h+1)).toLowerCase();
        }
        else if (m > 30) {
            int restMinutes = 60-m;
            if (restMinutes < 2) { // 1 minute rest, singular form
                res = numberToWords(restMinutes).toLowerCase()+" "+MINUTE_TO_STR+" "+numberToWords(overClock(h+1)).toLowerCase();
            }
            else {
                res = numberToWords(restMinutes).toLowerCase()+" "+MINUTES_TO_STR+" "+numberToWords(overClock(h+1)).toLowerCase();
            }
        }
        else { // m < 30 
            if (m < 2) { // m == 1 
                res = numberToWords(m).toLowerCase()+" "+MINUTE_PAST_STR+" "+numberToWords(h).toLowerCase();
            }
            else { // m >= 2
                res = numberToWords(m).toLowerCase()+" "+MINUTES_PAST_STR+" "+numberToWords(h).toLowerCase();
            }
        }
        
        return res;
    } // timeInWords

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        // TESTCASE 9 (plural & singular forms)
        // 1 1 , EXPECTED : one minute past one
        //String result = timeInWords(1, 1);
        // TESTCASE 8 (plural & singular forms)
        // 10 57 , EXPECTED : three minutes to eleven
        
        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}