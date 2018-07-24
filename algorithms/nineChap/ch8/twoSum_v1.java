public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                // error!!!
                // result.add(map.get(numbers[i]));
                // result.add(i);
                
                result[0] = map.get(target - numbers[i]);
                result[1] = i;
                
                return result;
            }
            map.put(numbers[i], i);
        }
        
        return result;
    }
}