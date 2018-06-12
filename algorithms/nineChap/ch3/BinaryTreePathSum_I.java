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


public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root, path, result, root.val, target);
        return result;
    }
    
    private void helper(TreeNode root,
                        List<Integer> path,
                        List<List<Integer>> result,
                        int sum,
                        int target) {
                            
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
    
        if (root.left != null) {
            path.add(root.left.val);
            sum += root.left.val;
            helper(root.left, path, result, sum, target);
            sum -= root.left.val;
            path.remove(path.size() - 1);
        }
        
        if (root.right != null) {
            path.add(root.right.val);
            sum += root.right.val;
            helper(root.right, path, result, sum, target);
            sum -= root.right.val;
            path.remove(path.size() - 1);
        }
    }
}