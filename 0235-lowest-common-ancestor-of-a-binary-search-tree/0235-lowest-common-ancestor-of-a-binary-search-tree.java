/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int valP = p.val;
        int valQ = q.val;
        while(root != null){
            int curr = root.val;
            if((valP <= curr && valQ>= curr) ||(valP>=curr && valQ<= curr)){
                return root;
            }
            if(valP < curr && valQ < curr){
                root = root.left;
            }
            else if(valP > curr && valQ > curr){
                root = root.right;
            }
        }
        return root;
    }
}