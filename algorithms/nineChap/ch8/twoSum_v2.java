class Pair {
    public int value, index;
    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class Solution {
    private Comparator<Pair> PairComparator = new Comparator<Pair>() {
        public int compare(Pair a, Pair b) {
            return a.value - b.value;
        }
    };
    
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
        
        Pair[] nums = new Pair[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = new Pair(numbers[i], i);
        }
        
        Arrays.sort(nums, PairComparator);
        
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l].value + nums[r].value == target) {
                int index1 = nums[l].index;
                int index2 = nums[r].index;
                result[0] = Math.min(index1, index2);
                result[1] = Math.max(index1, index2);
                return result;
            } else if (nums[l].value + nums[r].value < target) {
                l++;
            } else {
                r--;
            }
        }
        
        return result;
    }
}