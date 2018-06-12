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
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        findPath(root, String.valueOf(root.val), paths);
        return paths;
    }
    
    private void findPath(TreeNode root, String path, List<String> paths) {
        if (root.left == null && root.right == null) { // is a leaf. end with no "->"
            paths.add(path);
            return;
        }
        
        if (root.left != null) {  // needed, otherwise NPE
            findPath(root.left, path + "->" + String.valueOf(root.left.val), paths);
        }
        if (root.right != null) {
            findPath(root.right, path + "->" + String.valueOf(root.right.val), paths);
        }
    }
}