public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        if (S == null || S.length == 0) {
            return 0;
        }
        
        Arrays.sort(S);
        int count = 0; // find all a+b>c
        for (int i = S.length - 1; i >= 2; i--) { // for c
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}