public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        boolean[] visited = new boolean[nums.length];
        dfsHelper(nums, visited, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void dfsHelper(int[] nums, boolean[] visited,
                           List<Integer> permutation, List<List<Integer>> results) {
                        //没有startIndex。因为startIndex是为了加startIndex之后的元素。 这里是从头开始加，所以每次都从index=0开始走一遍。eg.123,132      
                               
        if (nums.length == permutation.size()) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) { // i = 0
            if (visited[i]) {
                continue;
            }
            
            permutation.add(nums[i]);
            visited[i] = true;
            dfsHelper(nums, visited, permutation, results);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}