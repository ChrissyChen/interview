public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
//         //如果是没有等号，那出循环的时候left必然=right，而这时当前这个元素e还没有与k进行比较，它的状态时不定的。如果e<k, 则应该return left+1，反之return left。若果非要用=作为条件。把最后一句改成return nums[left] < k ? left + 1: left; 即可。

// 那么问题来了，怎么能想到这么操作呢？就要记住题目要求必须所有元素都经过partition。当left和right错开的时候是能够保证这一点的。此时[0,right]和[left,end]两个区间内的值都满足各自条件。 直接return left或者 right + 1 即可。
        while (left <= right) { // pay attention
            while (left <= right && nums[left] < k) { // pay attention
                left++;
            }
            while (left <= right && nums[right] >= k) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}