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
    int height=-1;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        helper(root, 1);
        return height;
    }

    void helper(TreeNode root , int level){
        height = Math.max(level, height);
        if(root == null){
            return;
        }
        
        if(root.left != null) {
            helper(root.left, level+1);
        }
        
        if(root.right != null) {
            helper(root.right, level+1);
        }
        
    }
}