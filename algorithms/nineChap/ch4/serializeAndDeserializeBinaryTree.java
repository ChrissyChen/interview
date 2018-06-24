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
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        List<String> result = new ArrayList<>();  // better to use string builder
        if (root == null) {
            return "[]";
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(String.valueOf(root.val));
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                result.add(String.valueOf(node.left.val));
            } else {
                result.add("#");
            }
            
            if (node.right != null) {
                queue.add(node.right);
                result.add(String.valueOf(node.right.val));
            } else {
                result.add("#");
            }
        }
        
        while (result.get(result.size() - 1).equals("#")) {
            result.remove(result.size() - 1);
        }
        
        return result.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        //System.out.println(data);
        if (data.equals("[]")) {
            return null;
        }
        
        String[] vals = data.substring(1, data.length() - 1).split(", ");
        //System.out.println(Arrays.toString(vals));
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        list.add(root);
        
        int index = 0;
        boolean isLeft = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeft) {
                    list.get(index).left = node;
                } else {
                    list.get(index).right = node;
                }
                list.add(node);
            }
            
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        } 
        return root;
    }
    
    
}