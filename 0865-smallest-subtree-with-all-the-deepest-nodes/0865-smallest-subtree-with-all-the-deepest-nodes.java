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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        HashMap<TreeNode , TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        map.put(root,null);
        // int depth = 0;
        List<TreeNode> lastLevelNodes= new ArrayList<>();
        while(!q.isEmpty())
        {
            lastLevelNodes = new ArrayList<>();
            int n= q.size();
            for(int i=0;i<n;i++)
            {
                TreeNode curr = q.poll();
                lastLevelNodes.add(curr);
                if(curr.left != null){
                    q.add(curr.left);
                    map.put(curr.left, curr);
                }
                if(curr.right != null)
                {
                    q.add(curr.right);
                    map.put(curr.right, curr);
                }
            }
        }
        Set<TreeNode> set = new HashSet<>(lastLevelNodes);

        while (set.size() > 1) {
            Set<TreeNode> next = new HashSet<>();
            for (TreeNode node : set) {
                next.add(map.get(node));
            }
            set = next;
        }

        return set.iterator().next();
    }
}