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
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        while (lists.size() > 1) {
            List<ListNode> newLists = new ArrayList<>();
            for (int i = 0; i + 1 < lists.size(); i += 2) {
                ListNode merged = merge(lists.get(i), lists.get(i + 1));
                newLists.add(merged);
            }
            
            if (lists.size() % 2 == 1) {
                newLists.add(lists.get(lists.size() - 1));
            }
            
            lists = newLists;
        }
        
        return lists.get(0); // pay attention
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tail.next = node1;
                tail = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                tail = node2;
                node2 = node2.next;
            }
        }
        
        if (node1 != null) {
            tail.next = node1;
        }
        
        if (node2 != null) {
            tail.next = node2;
        }
        
        return dummy.next;
    }
}