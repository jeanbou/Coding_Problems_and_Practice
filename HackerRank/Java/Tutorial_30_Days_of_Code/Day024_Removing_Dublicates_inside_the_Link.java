package hackerRank_Java30DaysOfCode;

import java.util.*;

class ListNode {
	int data;
	ListNode next;
	ListNode(int d){
        data=d;
        next=null;
    }
}

class Day024_Removing_Dublicates_inside_the_Link {
	
	public static ListNode removeDuplicates(ListNode head) {
        
		ListNode copyOfHead = head; // Keeping the pointer on the head of head to return it for later check
        while( head != null && head.next != null ) {
            if ( head.data != head.next.data ) {
                head = head.next;
            }
            else { // remove duplicate by re-linking
                head.next = head.next.next;                
            }          
        } // the end of while
        
        // Compensatory code for the case when you have the sequence of identical data
        // After running main part of code for such specific case you have 2 instance link with identical values, let's compensate it
        if ( copyOfHead.next != null && copyOfHead.data == copyOfHead.next.data ) {
            copyOfHead.next = null;
        }
        
        return copyOfHead;
    }
	
	public static  ListNode insert(ListNode head,int data) {
		ListNode p=new ListNode(data);			
	   if(head==null)
	       head=p;
	   else if(head.next==null)
	       head.next=p;
	   else
	   {
		   ListNode start=head;
	       while(start.next!=null)
	           start=start.next;
	       start.next=p;
	
	   }
	   return head;
	}
	
	public static void display(ListNode head) {
			ListNode start=head;
	        while(start!=null) {
	             System.out.print(start.data+" ");
	             start=start.next;
	        }
	}
	
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
         Scanner sc=new Scanner(System.in);
         ListNode head=null;
         int T=sc.nextInt();
         while(T-->0){
             int ele=sc.nextInt();
             head=insert(head,ele);
         }
         head=removeDuplicates(head);
         display(head);
	}
	
} // the end of class
