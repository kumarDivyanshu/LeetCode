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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        // TreeNode root = new TreeNode(preorder[0]);
        // TreeNode ans = root;
        // for(int i=1;i<preorder.length ;i++){
            
        //     put(root, preorder[i]);
        // }
        // return root;
        return build(preorder , Integer.MAX_VALUE);
    }

    TreeNode put(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val< root.val){
            root.left = put(root.left , val);
        }
        else{
            root.right = put(root.right,val);
        }
        return root;
    }

    TreeNode build(int[] preorder, int bound){
        if(index == preorder.length || preorder[index] > bound){
            return null;
        }

        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = build(preorder, root.val);
        root.right = build(preorder , bound);
        return root;
    }
}