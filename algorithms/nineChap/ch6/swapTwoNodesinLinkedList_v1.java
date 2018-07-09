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
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode tempV1 = null, tempV2 = null;
        while (head != null) {
            if (head.val == v1) {
                tempV1 = head;
            }
            if (head.val == v2) {
                tempV2 = head;
            }
            head = head.next;
        }
        
        if (tempV1 != null && tempV2 != null) {
            tempV1.val = v2;
            tempV2.val = v1;
        }
        return dummy.next;
    }
}