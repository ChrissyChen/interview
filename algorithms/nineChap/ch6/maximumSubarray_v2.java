public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        } 
        
        //comment是错的代码，对全部是负数不成立！[-1,-2,-3,-100,-1,-50]
        // if (nums.length == 1) {
        //     return nums[0];
        // }
        
        // int max = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;
        // int sum = 0;
        
        // // find min prefix sum and max prefix sum
        // for (int i = 0; i < nums.length; i++) {
        //     sum += nums[i];
        //     max = Math.max(max, sum);
        //     min = Math.min(min, sum);
        // }
        
        // return max - min; //可能前面减后面，错误！要后面减前面！
        
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}