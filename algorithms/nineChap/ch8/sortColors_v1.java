public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int left = 0, right = nums.length - 1;
        // partition 0 to left
        while (left <= right) {
            while (left <= right && nums[left] == 0) {
                left++;
            }
            while (left <= right && nums[right] != 0) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        } // left points to the first non-zero num
        
        // partition 1 to left and 2 to right
        right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] == 1) {
                left++;
            }
            while (left <= right && nums[right] == 2) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        } // left points to the first 2 
    }
}