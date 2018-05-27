package hackerRank_Java30DaysOfCode;


import java.util.*;


class BSTreeNode {
	BSTreeNode left,right;
    int data;
    BSTreeNode(int data){
        this.data=data;
        left=right=null;
    }
}

class Day023_BSTTree_Specific_Level_Left_Order_Traversal {

	// Not used, but give just for example
	static void simpleLevelOrderTraversal(BSTreeNode root) {
	        if (root == null) {
	            return;
	        }
	        System.out.print(root.data + " ");
	        levelOrder(root.left);
	        levelOrder(root.right);        
	}

	// NOTE: Please see above the simple BST (Level Order Traversal)
	// Requirement of the task demands specificity of Queue usage
	// CREDITS : https://github.com/thechampanurag/hackerrank-30-Days-of-Code/blob/master/Day-23-BST-Level-order-traversal.java
	static void levelOrder(BSTreeNode root) {
	      Queue<BSTreeNode> queue = new LinkedList<BSTreeNode>();
	      queue.add(root);
	      while ( queue.peek() != null ) {
	    	  BSTreeNode node =queue.remove();
	          System.out.print(node.data+" ");
	          if(node.left != null) {
	              queue.add(node.left);
	          }
	          if(node.right != null) {
	              queue.add(node.right);
	           }
	      }
	}
	
	public static BSTreeNode insert(BSTreeNode root,int data){
        if(root==null){
            return new BSTreeNode(data);
        }
        else{
        	BSTreeNode cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
	
    @SuppressWarnings("resource")
	public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            int T=sc.nextInt();
            BSTreeNode root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
} // the end of class
