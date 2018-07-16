public class Solution {
    Queue<Integer> minHeap;
    int maxSize;
    
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
        List<Integer> result = new ArrayList<>();
        Iterator it = minHeap.iterator();
        while (it.hasNext()) {
            result.add((Integer)it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}