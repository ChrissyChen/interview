class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        Arrays.sort(nums);
        int length = nums.length;
        return nums[length - k];
    }
};