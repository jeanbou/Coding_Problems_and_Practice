package hackerRank_Java30DaysOfCode;

import java.util.*;

class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
}

class Day015_LinkedList_InsertionFunct_withRun2the_end_ofList {

	public static  Node insert(Node head,int d) {
        
        // CREDITS : ( if use the simple insertion )
        // https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
        // Note that in this case printing out by display method will be done in reverse order after
        
        // that's why I used complicated insertion then running up to the end of LinkedList
        // note sure about more efficient solution
        // CREDITS : https://stackoverflow.com/questions/32625964/insert-node-at-the-end-of-linked-list
        
        	Node newNode = new Node(d);
        	if (head == null) {
            		return newNode;
        	}
        	Node current = head; 
        	while (current.next != null) {
            		current = current.next;
        	}
        	current.next = newNode;
        	return head;
    	}
	
	public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }

}
