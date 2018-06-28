public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        
        int[] nums = removeDuplicates(candidates);
        
        dfsHelper(nums, 0, new ArrayList<Integer>(), target, results);
        return results;
    }
    
    private void dfsHelper(int[] nums, int startIndex, List<Integer> comb, 
                           int remainTarget, List<List<Integer>> results) {
        if (remainTarget == 0) {
            results.add(new ArrayList<Integer>(comb));
            return;
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] > remainTarget) {
                break;
            }
            comb.add(nums[i]);
            dfsHelper(nums, i, comb, remainTarget - nums[i], results);
            comb.remove(comb.size() - 1);
        }
    }
    
    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);
        
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }
        
        int[] nums = new int[index+ 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }
        return nums;
    }
}