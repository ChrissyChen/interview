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
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (head == null || m >= n) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        // find (m-1)th node
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        ListNode preNodeM = head;
        ListNode nodeM = head.next;
        
        // reverse
        ListNode nodeN = nodeM;
        ListNode postNodeN = nodeM.next;
        for (int i = m; i < n; i++) {
            if (postNodeN == null) {
                return null;
            }
            ListNode temp = postNodeN.next;
            postNodeN.next = nodeN;
            nodeN = postNodeN;
            postNodeN = temp;
        }
        // after for loop, nodeN points to nth node
        
        // connect
        preNodeM.next = nodeN;
        nodeM.next = postNodeN;
        
        return dummy.next;
    }
}