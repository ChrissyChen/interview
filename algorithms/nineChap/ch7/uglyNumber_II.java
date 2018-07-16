public class Solution {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> hash = new HashSet<>();
        Long[] factors = {Long.valueOf(2), Long.valueOf(3), Long.valueOf(5)};
        
        Long num = Long.valueOf(1);
        queue.add(num);
        hash.add(num);
        
        for (int i = 0; i < n; i++) {
            num = queue.poll();
            for (int j = 0; j < factors.length; j++) {
                if (!hash.contains(num * factors[j])) {
                    hash.add(num * factors[j]);
                    queue.add(num * factors[j]);
                }
            }
        }
        
        return num.intValue();
    }
}