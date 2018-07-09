public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
		if (nums.length == 0) return res;
		
		int closest = Integer.MAX_VALUE, sum = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		//map.put(0, 0);
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				res[0] = map.get(sum) + 1;  //从前往后扫，所以如果map里有，说明index排在前面
				res[1] = i;
				return res;
		    }

		    Integer greater = map.higherKey(sum);
		    //Returns the least key strictly greater than the given key, or null if there is no such key.
		    if (greater != null && Math.abs(sum - greater) < closest) {
			    closest = Math.abs(sum - greater);
			    res[0] = map.get(greater) + 1;
			    res[1] = i;
		    }
		
	        Integer lower = map.lowerKey(sum);
	        //Returns the greatest key strictly less than the given key, or null if there is no such key.
	        if (lower != null && Math.abs(sum - lower) < closest) {
			    closest = Math.abs(sum - lower);
			    res[0] = map.get(lower) + 1;
			    res[1] = i;
		    }
		    map.put(sum, i);
		}
		return res;
    }
}