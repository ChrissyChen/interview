/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: a ListNode
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curt = dummy;
        ListNode preNode1 = null, preNode2 = null;
        
        while (curt.next != null) {
            if (curt.next.val == v1) {
                preNode1 = curt;
            } else if (curt.next.val == v2) {
                preNode2 = curt;
            }
            curt = curt.next;
        }
        // cannot find v1/v2
        if (preNode1 == null || preNode2 == null) {
            return head;
        }
        
        ListNode node1 = preNode1.next;
        ListNode node2 = preNode2.next;
        ListNode postNode1 = node1.next;
        ListNode postNode2 = node2.next;
        
        // swap: corner cases
        if (node1 == preNode2) { // v1 and v2 are adjacent
            preNode1.next = node2;
            node2.next = node1;
            node1.next = postNode2;
        } else if (node2 == preNode1) { // v2 and v1 are adjacent
            preNode2.next = node1;
            node1.next = node2;
            node2.next = postNode1;
        } else {
            //swap: normal case
            preNode1.next = node2;
            node2.next = postNode1;
            preNode2.next = node1;
            node1.next = postNode2;
        }
        
        return dummy.next;
    }
}