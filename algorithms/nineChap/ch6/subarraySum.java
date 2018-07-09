public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                result.add(0);
                result.add(i);
                return result;
            }
        
            if (map.containsKey(sum)) {
                int firstIndex = map.get(sum) + 1;
                int lastIndex = i;
                result.add(firstIndex);
                result.add(lastIndex);
                return result;
            }
            map.put(sum, i);  // pay attention. don't swap the order...
        }
        
        return result;
    }
}