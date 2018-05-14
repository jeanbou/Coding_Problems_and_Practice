package hackerRank_Java30DaysOfCode;

import java.util.*;

public class Day018_Palindrom__Stack_n_Queue_Solution {
   
    private Stack<Character> stack = new Stack<Character>();
    Queue<Character> queue = new ArrayDeque<Character>();
    
    private void pushCharacter(char c) {
        stack.push(c);
    }
    
    private char popCharacter() {
        return ((Character) stack.pop());
    }
    
    private void enqueueCharacter(char c) {
        queue.add(c);
    }
    
    private char dequeueCharacter() {
        return queue.remove();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Day018_Palindrom__Stack_n_Queue_Solution p = new Day018_Palindrom__Stack_n_Queue_Solution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is " 
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}
