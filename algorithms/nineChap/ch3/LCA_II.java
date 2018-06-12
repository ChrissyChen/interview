/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {

        ArrayList<ParentTreeNode> pathA = getPathToRoot(A);
        ArrayList<ParentTreeNode> pathB = getPathToRoot(B);

        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;

        ParentTreeNode lowestAncestor = null;
        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            lowestAncestor = pathA.get(indexA);
            indexA--;
            indexB--;
        }
        return lowestAncestor;
    }

    private List<ParentTreeNode> getPathToRoot(ParentTreeNode node) {
        List<ParentTreeNode> path = new ArrayList<ParentTreeNode>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}