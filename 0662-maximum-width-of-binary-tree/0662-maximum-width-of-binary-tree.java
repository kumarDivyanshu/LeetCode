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
    Pair(TreeNode node, int num){
        this.node=node;
        this.num=num;
    }
} 

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null ) return 0;
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;

        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            int n = q.size();
            int mmin = q.peek().num;
            int first = 0;
            int last = 0;

            for(int i=0;i< n;i++){
                Pair curr = q.poll();
                TreeNode node = curr.node;
                int num = curr.num;

                if(i==0){
                    first = num;
                }
                if(i==n-1){
                    last = num;
                }
                if(node.left != null){
                    q.add(new Pair(node.left,2*num +1));
                }
                if(node.right != null){
                    q.add(new Pair (node.right , 2*num +2));
                }

            }
            ans = Math.max(ans , last-first+1);
        }
        return ans;
    }
}