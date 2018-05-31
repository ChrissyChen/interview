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

// divide and conquer
public class Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
       List<Integer> preorder = new ArrayList<Integer>();
       if (root == null) {
           return preorder;
       }
       
       List<Integer> left = preorderTraversal(root.left);
       List<Integer> right = preorderTraversal(root.right);
       preorder.add(root.val);
       preorder.addAll(left);
       preorder.addAll(right);
       
       return preorder;
    }
    
}