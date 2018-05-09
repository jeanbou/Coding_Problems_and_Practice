package hackerRank_Java30DaysOfCode;

import java.util.*;

class TreeNode {
	TreeNode left,right;
    int data;
    TreeNode(int data){
        this.data=data;
        left=right=null;
    }
}

class  Day022_BinaryTree_MaxDepth {
	
	public static int getHeight(TreeNode root) {
	      if (root == null) {
	          return -1;
	      }
	      else {
	        // CREDITS : difficult part of the code, that's why
	        // https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
	        /* compute the depth of each subtree */
	        int lDepth = getHeight(root.left);
	        int rDepth = getHeight(root.right);
	  
	        /* use the larger one */
	        if (lDepth > rDepth)
	            return (lDepth + 1);
	        else
	            return (rDepth + 1);
	      }
	}
	
	public static TreeNode insert(TreeNode root,int data){
        if(root==null){
            return new TreeNode(data);
        }
        else{
        	TreeNode cur;
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
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        TreeNode root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}
