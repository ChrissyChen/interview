public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int size = nums.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        int[] leftMin = new int[size];
        int[] rightMin = new int[size];
        
        int sum = 0, minSum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            leftMax[i] = max;
        }
        System.out.println("left max =" + max);
        
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            rightMax[i] = max;
        }
        System.out.println("right max =" + max);
        
        sum = 0;
        int maxSum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
            leftMin[i] = min;
        }
        System.out.println("left min =" + min);
        
        sum = 0;
        maxSum = 0;
        min = Integer.MAX_VALUE;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums[i];
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
            rightMin[i] = min;
        }
        System.out.println("right min =" + min);
        
        int diff = 0;
        for (int i = 0; i < size - 1; i++) {
            diff = Math.max(diff, Math.abs(leftMax[i] - rightMin[i + 1]));
            diff = Math.max(diff, Math.abs(leftMin[i] - rightMax[i + 1]));
        }
        return diff;
    }
}