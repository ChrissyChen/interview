/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        if (graph == null || graph.size() == 0) {
            return result;
        }
        
        HashMap<DirectedGraphNode, Integer> inDegree = getInDegree(graph);
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {  // add all nodes that indegree = 0 in queue
            if (!inDegree.containsKey(node)) {
                queue.add(node);
                result.add(node);
            }
        }
        
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                    result.add(neighbor);
                }
            }
        }
        
        return result;
    }
    
    private HashMap<DirectedGraphNode, Integer> getInDegree(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Integer> inDegree = new HashMap<>();
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (inDegree.containsKey(neighbor)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) + 1);
                } else {
                    inDegree.put(neighbor, 1);
                }
            }
        }
        return inDegree;
    }
}