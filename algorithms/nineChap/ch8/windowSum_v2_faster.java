public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        
        // pay attention
        if (nums == null || nums.length < k || k <= 0) {
            return new int[0]; 
        }
        
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            result[0] += nums[i];
        }
        
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + nums[i + k - 1] - nums[i - 1];
        }
        
        return result;
    }
}