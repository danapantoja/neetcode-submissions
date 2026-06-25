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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return null;
        if (root.val!=key){
            if (key < root.val){
                root.left = deleteNode (root.left, key);
            }else{
                root.right = deleteNode(root.right, key);
            }
        }else{
            if (root.left==null && root.right==null){
                return null;
            }else if (root.left==null || root.right==null){
                if (root.left==null){
                    return root.right;
                }else{
                    return root.left;
                }
                
            }else{//two children
                int temp = root.right.val;
                root.right.val = root.val;
                root.val = temp;
                root.right = deleteNode(root.right, root.right.val);
                return root;
            }
        }
        
        return root;
    }
}