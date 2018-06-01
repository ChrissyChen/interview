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
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> postorder = new ArrayList<Integer>();
        traverse(root, postorder);
        return postorder;
    }
    
    private void traverse(TreeNode root, List<Integer> postorder) {
        if (root == null) {
            return;
        }
        
        traverse(root.left, postorder);
        traverse(root.right, postorder);
        postorder.add(root.val);
    }
}