public class Solution {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
       // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 4) {
            return result;
        }
        
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) { // for a
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < numbers.length - 2; j++) { // for b
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
            
                int left = j + 1;
                int right = numbers.length - 1;
                while (left < right) {
                    if (numbers[left] + numbers[right] == target - numbers[i] - numbers[j]) {
                        ArrayList<Integer> answer = new ArrayList<>();
                        answer.add(numbers[i]);
                        answer.add(numbers[j]);
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
                    } else if (numbers[left] + numbers[right] < target - numbers[i] - numbers[j]) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}