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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1,
                     inorder, 0, inorder.length - 1,
                     map);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd,
                           int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        // Root is always last element in postorder range
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder array
        int inIndex = map.get(rootVal);

        // Number of nodes in left subtree
        int leftSize = inIndex - inStart;

        // Build left subtree
        root.left = build(postorder, postStart, postStart + leftSize - 1,
                          inorder, inStart, inIndex - 1, map);

        // Build right subtree
        root.right = build(postorder, postStart + leftSize, postEnd - 1,
                           inorder, inIndex + 1, inEnd, map);

        return root;
    }
}
