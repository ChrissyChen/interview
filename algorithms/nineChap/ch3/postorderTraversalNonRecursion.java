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

// Non-recusion
public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> postorder = new ArrayList<Integer>();
        
        if (root == null) {
            return postorder;
        }
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            postorder.add(0, node.val); //总是加在第一位，后面的往后挪。
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return postorder;
    }
}