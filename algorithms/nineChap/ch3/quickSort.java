public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        // 1. get value not index
        int pivot = A[(end - start) / 2 + start];
        // 2. <= not < (if < may has endless loop)
        
        while (left <= right) {
            while (left <= right && A[left] < pivot) { // 3.A[left] < pivot not <=. 
                left++;                                 // = will also be swapped
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            // swap
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        
        quickSort(A, start, right);
        quickSort(A, left, end);
    }

}