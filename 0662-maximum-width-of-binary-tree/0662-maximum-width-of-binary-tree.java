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

class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node , int num){
        this.node = node;
        this.num = num;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int width = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root , 0));

        while(!q.isEmpty()){
            int n = q.size();
            int first =0;
            int last=0;
            for(int i=0;i<n ;i++){
                Pair curr = q.poll();
                
                if(i==0){
                    first = curr.num; 
                }
                if(i== n-1){
                    last = curr.num;
                }

                if(curr.node.left != null){
                    q.add(new Pair(curr.node.left , 2*curr.num+1));
                }
                if(curr.node.right != null){
                    q.add(new Pair(curr.node.right , 2*curr.num+2));
                }
            }
            width = Math.max(width , last-first+1);
        }
        return width;
    }
}