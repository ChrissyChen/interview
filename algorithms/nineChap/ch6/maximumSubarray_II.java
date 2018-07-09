public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        
        int sum = 0, minSum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            sum += nums.get(i);  // pay attention
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            left[i] = max; //存储的是在i这个分割线，i左边最大的subarray sum是多少
        }
        
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            right[i] = max; //存储的是在i这个分割线，i右边最大的subarray sum是多少
        }
        
        max = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {  // pay attention
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}