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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int l = height(root.left);
        int r = height(root.right);
        if(Math.abs(l-r)>1){
            return false;
        }
        
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        return left && right;
        
    }

    int height(TreeNode root){
        if(root== null) return 0;
        int LH = height(root.left);
        int RH = height(root.right);
        
        return Math.max(LH, RH) + 1;

    }

    int isHeight(TreeNode root){
        if(root== null) return 0;
        
        int LH = isHeight(root.left);
        if(LH == -1) return -1;
        int RH = isHeight(root.right);
        if(RH == -1) return -1;
        if(Math.abs(LH - RH) >1 ) return -1;

        return Math.max(LH, RH) + 1;
    }
}