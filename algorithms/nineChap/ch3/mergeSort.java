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
        int[] result = new int[A.length];
        mergeSort(A, 0, A.length - 1, result);
    }
    
    private void mergeSort(int[] A, int start, int end, int[] result) {
        if (start >= end) {
            return;
        }
        
        int mid = (end - start) / 2 + start;
        mergeSort(A, start, mid, result);
        mergeSort(A, mid + 1, end, result);
        
        int left = start, right = mid + 1;
        int index = start;
        
        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                result[index++] = A[left++];
            } else {
                result[index++] = A[right++];
            }
        }
        while (left <= mid) {
            result[index++] = A[left++];
        }
        while (right <= end) {
            result[index++] = A[right++];
        }
        
        // copy result back to A. because we need to merge sorted array in A
        for (int i = start; i <= end; i++) {
            A[i] = result[i];
        }
    }
}