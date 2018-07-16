public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int item : num) {
            set.add(item);
        }
        
        int longest = 0;
        for (int item : num) {
            int size = 0;
            if (set.contains(item)) {
                size++;
                set.remove(item);
                int down = item - 1;
                int up = item + 1;
                
                while (set.contains(down)) {
                    set.remove(down);
                    down--;
                    size++;
                }
                
                while (set.contains(up)) {
                    set.remove(up);
                    up++;
                    size++;
                }
                
                //longest = Math.max(longest, up - down - 1);
                longest = Math.max(longest, size);
            }
        }
        
        return longest;
    }
}