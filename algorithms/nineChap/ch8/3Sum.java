public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {  // for a
        // pay attention
        // skip duplicate triples with the same first numebr
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] == -numbers[i]) {
                    ArrayList<Integer> answer = new ArrayList<>();
                    answer.add(numbers[i]);
                    answer.add(numbers[left]);
                    answer.add(numbers[right]);
                    result.add(answer);
                    left++;
                    right--;
                    
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                } else if (numbers[left] + numbers[right] < -numbers[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}