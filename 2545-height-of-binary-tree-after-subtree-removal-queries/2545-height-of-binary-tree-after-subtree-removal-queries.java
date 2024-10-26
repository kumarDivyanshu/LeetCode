import java.util.*;

class Solution {
    private Map<Integer, Integer> nodeToHeight = new HashMap<>();
    private Map<Integer, Integer> nodeToDepth = new HashMap<>();
    private Map<Integer, List<Integer>> depthHeights = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        // Step 1: Compute height and depth for each node
        computeHeightAndDepth(root, 0);

        // Step 2: Prepare depth heights list
        prepareDepthHeights();

        // Step 3: Process each query
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = getRemainingTreeHeight(queries[i]);
        }

        return result;
    }

    // Helper method to compute height and depth of each node
    private int computeHeightAndDepth(TreeNode node, int depth) {
        if (node == null) return -1;

        nodeToDepth.put(node.val, depth);

        int leftHeight = computeHeightAndDepth(node.left, depth + 1);
        int rightHeight = computeHeightAndDepth(node.right, depth + 1);

        int height = Math.max(leftHeight, rightHeight) + 1;
        nodeToHeight.put(node.val, height);

        depthHeights.computeIfAbsent(depth, k -> new ArrayList<>()).add(height);

        return height;
    }

    // Prepare depth heights to store max heights at each depth level
    private void prepareDepthHeights() {
        for (List<Integer> heights : depthHeights.values()) {
            Collections.sort(heights, Collections.reverseOrder());
        }
    }

    // Calculate remaining tree height after removing subtree of the queried node
    private int getRemainingTreeHeight(int queryNode) {
        int nodeDepth = nodeToDepth.get(queryNode);
        int nodeHeight = nodeToHeight.get(queryNode);

        // Get the two largest heights at this depth
        List<Integer> heightsAtDepth = depthHeights.get(nodeDepth);
        int maxHeight = heightsAtDepth.get(0);
        int secondMaxHeight = heightsAtDepth.size() > 1 ? heightsAtDepth.get(1) : -1;

        // If the query node's height was the max height, use the second max height; otherwise, keep the max height
        return (nodeHeight == maxHeight ? secondMaxHeight : maxHeight) + nodeDepth;
    }
}
