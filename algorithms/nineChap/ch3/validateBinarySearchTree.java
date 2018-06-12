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

class ResultType {
    public int max, min;
    public boolean isValid;
    public ResultType (int max, int min, boolean isValid) {
        this.max = max;
        this.min = min;
        this.isValid = isValid;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root).isValid;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, true);  // KEY!
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        if (!left.isValid || !right.isValid) {
            return new ResultType(0, 0, false);
        }
        
        if ((root.left != null && left.max >= root.val) ||
                    (root.right != null && right.min <= root.val)) { //题目要求右子树>root
            return new ResultType(0, 0, false);         //其实题目BST的定义不对！
        } 
        
        return new ResultType(Math.max(root.val, right.max), Math.min(root.val, left.min), true);
    }
}