public class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            addNum(maxHeap, minHeap, nums[i]);
            result[i] = maxHeap.peek();
        }
        return result;
    }
    
    private void addNum(Queue<Integer> maxHeap, Queue<Integer> minHeap, int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
}