/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

// traversal
public class Solution {
    
    private int depth;
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        depth = 0;
        helper(root, 1);
        return depth;
    }
    
    private void helper(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }
        if (depth < curDepth) {
            depth = curDepth;
        }
        helper(root.left, curDepth + 1);
        helper(root.right, curDepth + 1);
    }
}