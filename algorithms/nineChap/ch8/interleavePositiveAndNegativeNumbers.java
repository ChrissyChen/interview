public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
     
     /*
     O(n) time, O(1) extra space

先用两根指针分成左 - 右 + 两部分, 再进行穿插
穿插需要分情况讨论 (左 - 右 + 的前提下)
如果 - 多, 那么从第2个数和倒数第1个数开始交换
如果 + 多, 那么从第1个数和倒数第2个数开始交换
如果一样多, 那么从第1个数和倒数第1个数开始交换
*/
     
     
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length <= 2) {
            return;
        }
        
        int left = 0, right = A.length - 1;
        while (left <= right) {
            while (left <= right && A[left] < 0) {
                left++;
            }
            while (left <= right && A[right] > 0) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        } // left points to the first num > 0
        
        if (left * 2 > A.length) {
            interleave(A, 1, A.length - 1);
        } else if (left * 2 == A.length) {
            interleave(A, 0, A.length - 1);
        } else {
            interleave(A, 0, A.length - 2);
        }
    }
    
    private void interleave(int[] A, int left, int right) {
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left += 2;
            right -= 2;
        }
    }
}