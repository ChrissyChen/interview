// traversal + divide and conquer
public class Solution {
	private TreeNode subtree = null; //最小sum子树的root
	private int subtreeSum = Integer.MAX_VALUE;  //最小子树的sum,先初始化为最大。

	public TreeNode findSubtree(TreeNode root) {
		helper(root);
		return subtree;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSum = helper(root.left);
		int rightSum = helper(root.right);
		int sum = leftSum + rightSum + root.val;
		if (sum < subtreeSum) {
			subtreeSum = sum;
			subtree = root;
		}
		return sum;
	}
}