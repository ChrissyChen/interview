public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null) {
            return results;
        }
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        dfsHelper(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void dfsHelper(int[] nums,
                           int startIndex,
                           List<Integer> subset,
                           List<List<Integer>> results) {
                               
        results.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            if (i - 1 >= 0 && i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            dfsHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}