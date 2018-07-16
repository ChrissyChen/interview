public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        
        for (int i = A.length / 2; i >= 0; i--) {
            siftDown(A, i); // check for children's value, if larger then parent, swap!
        }
    }
    
    private void siftDown(int[] A, int i) {
        while (i <= A.length - 1) {  // i is the index
            int minIndex = i;
            
            // if left child exists and its value is smaller than its parent
            if (i * 2 + 1 <= A.length - 1 && A[i * 2 + 1] < A[minIndex]) {
                minIndex = i * 2 + 1;
            }
            
            // if right child exists and its value is smaller than its parent
            if (i * 2 + 2 <= A.length - 1 && A[i * 2 + 2] < A[minIndex]) {
                minIndex = i * 2 + 2;
            }
            
            if (minIndex == i) {  // nor left or right child is smaller than parent
                break;
            }
            
            // swap parent with smallest
            int temp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = temp;
            
            i = minIndex;//交换以后的原稍大一些的parent要接着往下看它的child要不要换
        }
    }
}