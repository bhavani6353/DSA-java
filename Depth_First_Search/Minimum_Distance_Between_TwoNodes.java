// Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

 

// Example 1:


// Input: root = [4,2,6,1,3]
// Output: 1
// Example 2:


// Input: root = [1,0,48,null,null,12,49]
// Output: 1



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }
    int prev=-100000000;
    int min=Integer.MAX_VALUE;
    
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left); 
        
        int cur=root.val;
        int cur_diff=cur-prev;
        min=Math.min(min,cur_diff);
        prev=cur;
        
        inorder(root.right);
    }
    
}




 
  
  
  
  
