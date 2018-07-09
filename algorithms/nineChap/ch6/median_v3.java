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
        
        int size = nums.length;
        int mid = size / 2;
        if (size % 2 == 0) {
            return findKthElement(nums, mid);
        } else {
            return findKthElement(nums, mid + 1);
        }
    }
    
    private int findKthElement(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[left];
        int i = left, j = right;
        
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if (i <= j ) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }  // [left, j] < pivot; [i, right] >= pivot;
        
        if (left + k - 1 <= j) { // j, i are adjacent
            return quickSelect(nums, left, j, k);
        } else if (left + k - 1 >= i) { // j, i are adjacent
            return quickSelect(nums, i, right, k - (i - left)) ;
        } else {  // j, pivot, i
            return pivot;// or nums[i - 1] or nums[j + 1] or pivot
        }
    }
}