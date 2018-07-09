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
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        while (prev != null) {
            prev = reverseNextKNodes(prev, k);
        }
        
        return dummy.next;
    }
    
    // head->n1->n2->n3...->nk->nk+1...
    // =>
    // head->nk->nk-1...->n2->n1->nk+1...
    private ListNode reverseNextKNodes(ListNode head, int k) {
        // find kth node
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            node = node.next;
            if (node == null) {
                return null;  //没有k个node，所以不用reverse
            }
        }
        ListNode nk = node;
        ListNode nkplus = node.next;
        ListNode n1 = head.next;
        
        // reverse
        ListNode prev = null;
        ListNode curt = n1;
        while (curt != nkplus) {  //pay attention, not curt != null
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        //connect
        head.next = nk;  //pay attention, not dummy.next = nk;
        n1.next = nkplus;
        
        return n1;
    }
}