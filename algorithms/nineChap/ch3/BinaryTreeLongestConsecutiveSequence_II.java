class ResultType {
	public int maxLen, maxDown, maxUp;  
	public ResultType (int len, int down, int up) {
		maxLen = len;
		maxDown = down;
		maxUp = up;
	}
}

public class Solution {
	public int longestConsecutive2(TreeNode root) {
        // Write your code here
        return helper(root).maxLen;
    }

    private ResultType helper (TreeNode root) {
    	if (root == null) {
    		return new ResultType(0, 0, 0);
    	}

    	ResultType left = helper(root.left);
    	ResultType right = helper(root.right);

    	int down = 0, up = 0;
    	if (root.left != null && root.left.val - 1 == root.val) {
    		up = Math.max(up, left.maxUp + 1);    // up是算上自己（即root）以后呈连续上升趋势的len
    	}
    	if (root.left != null && root.left.val + 1 == root.val) {
    		down = Math.max(up, left.maxDown + 1);   // down是算上自己（即root）以后呈连续下降趋势的len
    	}
    	if (root.right != null && root.right.val - 1 == root.val) {
    		up = Math.max(up, right.maxUp + 1);
    	}
    	if (root.right != null && root.right.val + 1 == root.val) {
    		down = Math.max(up, right.maxDown + 1);
    	}

    	int len = down + 1 + up;  // len是算上自己（即root）以后的连续Len
    	len = Math.max(len, Math.max(left.maxLen, right.maxLen)); //与左右子树最大连续len比较

    	return new ResultType(len, down, up);
    }
}