/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        TreeNode targetNode = findNode(root, target);
        if (targetNode == null)
            return ans;
        Map<TreeNode, TreeNode> map = new HashMap<>();

        buildMap(map, root, null);

        Queue<Pair> q = new LinkedList<>();

        Set<TreeNode> visited = new HashSet<>();

        q.add(new Pair(targetNode, k));
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Pair curr = q.poll();
                TreeNode node = curr.node;
                int num = curr.num;
                visited.add(node);
                if (num == 0) {
                    ans.add(node.val);
                }
                if (node.left != null && visited.add(node.left)) {
                    q.add(new Pair(node.left, num - 1));
                }
                if (node.right != null && visited.add(node.right)) {
                    q.add(new Pair(node.right, num - 1));
                }

                TreeNode parent = map.get(node);
                if (parent != null && visited.add(parent)) {
                    q.add(new Pair(parent, num - 1));
                }

            }
        }
        return ans;

    }

    TreeNode findNode(TreeNode root, TreeNode target) {
        if (root == null)
            return null;
        if (root == target)
            return root;

        TreeNode left = findNode(root.left, target);
        if (left != null)
            return left;

        TreeNode right = findNode(root.right, target);
        if (right != null)
            return right;

        return null;
    }

    void buildMap(Map<TreeNode, TreeNode> map, TreeNode root, TreeNode parent) {
        if (root == null)
            return;
        map.put(root, parent);
        buildMap(map, root.left, root);
        buildMap(map, root.right, root);

    }
}