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
        if (head == null || m == n) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        
        ListNode nodeM = null, nodeMminus = null;  // need init
        if (m == 1) {
            nodeM = head;
        } else {
            // find (m - 1)th node
            for (int i = 1; i < m - 1; i++) {
                head = head.next;
            }
            nodeMminus = head;
            head = head.next;
            nodeM = head;
        }
        
        
        // find nth node
        for (int i = m; i < n; i++) {
            head = head.next;
        }
        ListNode nodeN = head;
        ListNode nodeNplus = head.next;
        
        //reverse
        head = nodeM;
        ListNode prev = null;
        while (head != nodeNplus) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        //connect
        if (m == 1) {
            dummy.next = nodeN;
        } else {
            nodeMminus.next = nodeN;
        }
        nodeM.next = nodeNplus;
        
        return dummy.next;
    }
}