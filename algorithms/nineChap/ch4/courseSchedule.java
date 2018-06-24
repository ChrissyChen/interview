public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        if (numCourses == 0 || numCourses == 1) {
            return true;
        }
        
        //Arrays.stream(prerequisites).distinct();
        //System.out.println(Arrays.deepToString(prerequisites));
        
        HashMap<Integer, ArrayList<Integer>> neighbors = getNeighbors(numCourses, prerequisites);
        HashMap<Integer, Integer> prereqs = getPrereqs(numCourses, prerequisites);
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (prereqs.get(i) == 0) {
                queue.add(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            count++;
            for (Integer nb : neighbors.get(course)) {
                prereqs.put(nb, prereqs.get(nb) - 1);
                System.out.println(prereqs.get(nb));
                if (prereqs.get(nb) == 0) {
                    queue.add(nb);
                }
            }
        }
        
        return count == numCourses;
    }
    
    private HashMap<Integer, ArrayList<Integer>> getNeighbors(int numCourses, 
                                                        int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> neighbors = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            neighbors.put(i, new ArrayList<Integer>());
        }
        
        int size = prerequisites.length;
        for (int i = 0; i < size; i++) {
            int nextCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            ArrayList<Integer> nb = neighbors.get(preCourse);
            nb.add(nextCourse);
            neighbors.put(preCourse, nb);
        }
        System.out.println(neighbors.toString());
        return neighbors;
    }
    
    private HashMap<Integer, Integer> getPrereqs(int numCourses, 
                                                        int[][] prerequisites) {
        HashMap<Integer, Integer> prereqs = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            prereqs.put(i, 0);
        }
        
        int size = prerequisites.length;
        for (int i = 0; i < size; i++) {
            int nextCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            prereqs.put(nextCourse, prereqs.get(nextCourse) + 1);
        }
        
        System.out.println(prereqs.toString());
        return prereqs;
    }
}