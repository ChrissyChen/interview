public class Solution {
    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid - 1] > A[mid + 1]) {
                end = mid;
            } else if (A[mid - 1] < A[mid + 1]) {
                start = mid;
            } else if (A[mid - 1] < A[mid] && A[mid + 1] < A[mid]) {
                return mid;
            } else if (A[mid - 1] > A[mid] && A[mid + 1] > A[mid]) {
                end = mid;
            }
        }
        
        if (A[start] > A[end]) {
            return start;
        } else {
            return end;
        }
    }
}