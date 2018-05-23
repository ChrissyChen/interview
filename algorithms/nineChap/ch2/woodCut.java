public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        
        int start = 1, max = L[0];
        for (int i = 0; i < L.length; i++) {
            if (L[i] > max) {
                max = L[i];
            }
        }
        int end = max;
        
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (countPieces(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (countPieces(L, end) >= k) {
            return end;
        }
        if (countPieces(L, start) >= k) {
            return start;
        }
        return 0;
    }
    
    private int countPieces(int[] L, int length) {
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i] / length;
        }
        return sum;
    }
}