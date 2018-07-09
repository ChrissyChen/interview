public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        int size = nums.length;
        if (size % 2 == 0) {
            return nums[size / 2 - 1];
        } else {
            return nums[size / 2];
        }
    }
}