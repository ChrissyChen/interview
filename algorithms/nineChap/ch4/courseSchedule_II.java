public class Solution {
    
    private HashMap<Integer, ArrayList<Integer>> neighbors = new HashMap<>();
    private HashMap<Integer, Integer> prereqs = new HashMap<>();
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] result = new int[numCourses];
        
        if (numCourses == 0) {
            return result;
        }
 
        getNeighborsAndPrereqs(numCourses, prerequisites);
        
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            if (!prereqs.containsKey(i)) {
                queue.add(i);
                result[index++] = i;
            }
        }
        
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            if (neighbors.containsKey(course)) {
                for (Integer nb : neighbors.get(course)) {
                    prereqs.put(nb, prereqs.get(nb) - 1);
                    if (prereqs.get(nb) == 0) {
                        queue.add(nb);
                        result[index++] = nb;
                    }
                }
            }
        }
        
        //System.out.println(Arrays.toString(result));
        
        if (index == numCourses) {  // 不能用result.length与numCourses比较，因为即使
            return result;          // result没填满，长度也是刚开始赋值的numCourses.
        }
        return new int[0];
    }
    
    private void getNeighborsAndPrereqs(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            int next = prerequisites[i][0];
            int pre = prerequisites[i][1];
            
            if (prereqs.containsKey(next)) {
                prereqs.put(next, prereqs.get(next) + 1);
            } else {
                prereqs.put(next, 1);
            }
            
            ArrayList<Integer> nb = null;
            if (neighbors.containsKey(pre)) {
                nb = neighbors.get(pre);
            } else {
                nb = new ArrayList<>();
            }
            nb.add(next);
            neighbors.put(pre, nb);
        }
        
        //System.out.println(prereqs.toString());
        //System.out.println(neighbors.toString());
    }
}