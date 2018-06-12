**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<TreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */


class ResultType {
	public int maxLen, maxDown, maxUp;  
	public ResultType (int len, int down, int up) {
		maxLen = len;
		maxDown = down;
		maxUp = up;
	}
}

public class Solution {
	public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        return helper(root).maxLen;
    }

    private ResultType helper (MultiTreeNode root) {
    	if (root == null) {
    		return new ResultType(0, 0, 0);
    	}

    	int down = 0, up = 0, len = 1;
    	for (MultiTreeNode node : root.children) {
            ResultType type = helper(node);
            if (node != null && node.val - 1 == root.val) {
                up = Math.max(up, type.maxUp + 1);
            }
            if (node != null && node.val + 1 == root.val) {
                down = Math.max(up, type.maxDown + 1);
            }
            len = Math.max(len, type.maxLen);
        }

        len = Math.max(down + 1 + up, len);
    	return new ResultType(len, down, up);
    }
}