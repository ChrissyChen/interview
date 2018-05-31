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
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> preorder = new ArrayList<Integer>();
        traverse(root, preorder);
        return preorder;
    }
    
    private void traverse(TreeNode root, List<Integer> preorder) {
        if (root == null) {
            return;
        }
        
        preorder.add(root.val);
        traverse(root.left, preorder);
        traverse(root.right,preorder);
    }
    
}