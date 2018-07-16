/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
    
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        Queue<ListNode> minHeap = new PriorityQueue<>(lists.size(), ListNodeComparator);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.add(lists.get(i));   
            }
        }
        
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll(); // smallest
            tail.next = node;
            tail = node;
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        
        return dummy.next;
        
    }
}