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
    public boolean isValidBST(TreeNode root) {
        boolean ans = solve(root, Long.MIN_VALUE, Long.MAX_VALUE);

        List<Integer> arr= new ArrayList<>();
        inorder(root,arr);
        System.out.println(arr);
        
        for(int i=0;i<arr.size()-1 ;i++){
            if(arr.get(i)>=arr.get(i+1)){
                return false;
            }
        }
        return true;
        // return ans;
    }

    // public boolean solve(TreeNode root , long min , long max){
    //     if(root == null) return true;

    //     if(root.val <= min || root.val >= max) return false;

    //     boolean left  = solve(root.left, min , root.val);
    //     boolean right = solve(root.right, root.val , max);

    //     return left && right;
    // }

    public boolean solve(TreeNode root, long min , long max)
    {
        if(root == null ) return true;
        if(root.val <= min || root.val >= max) return false;

        boolean left = solve(root.left , min , root.val);
        boolean right = solve(root.right , root.val , max);

        return (left && right);
    }

    void inorder(TreeNode root , List<Integer> arr)
    {
        if(root == null) return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}