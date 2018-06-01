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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> inorder = new ArrayList<Integer>();
        traverse(root, inorder);
        return inorder;
    }
    
    private void traverse(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        
        traverse(root.left, inorder);
        inorder.add(root.val);
        traverse(root.right, inorder);
    }
}