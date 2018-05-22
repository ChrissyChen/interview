public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here

        
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = (end - start) / 2 + start;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int)end;
        } 
        return (int)start;
    }
}