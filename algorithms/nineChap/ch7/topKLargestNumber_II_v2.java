public class Solution {
    Queue<Integer> minHeap;
    int maxSize;
    
    //用PriorityQueue保存前K大的数, 每当pq中加入多于k个数时，将多余的数poll。最后返回一个从大到小排序的list
    /*
    * @param k: An integer
    */public Solution(int k) {
        // do intialization if necessary
        minHeap = new PriorityQueue<Integer>();
        maxSize = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if (minHeap.size() < maxSize) {
            minHeap.add(num);
        } else {
            if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> result = new ArrayList<>(minHeap);
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}