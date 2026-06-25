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
    public TreeNode invertTree(TreeNode root) {
        
        if (root==null){
            return null;
        }

        //basically make a new tree
        TreeNode node=new TreeNode(root.val);

        // initialize the right side with the given trees left side, recursively
        node.right= invertTree(root.left);
       
        //initialize the left side with the given trees right side 
        node.left=invertTree(root.right);

        //returns the root
        return node;
    
        



    }
}
