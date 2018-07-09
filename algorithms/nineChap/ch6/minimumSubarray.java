public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE, sum = 0, maxSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
        }
        return min;
    }
}