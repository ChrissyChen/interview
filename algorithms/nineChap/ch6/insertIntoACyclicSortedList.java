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
    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // write your code here
        ListNode newNode = new ListNode(x);
        if (node == null) {
            newNode.next = newNode;
            return newNode;
        }
        
        ListNode curt = node;
        ListNode next = curt.next;
        while (node != next) {
            if (curt.val <= x && next.val >= x) { // curt = 3, x = 4, next = 5
                break;
            }
            
            if (next.val < curt.val && (x >= curt.val || x <= next.val)) { //attention!
                // curt = 5, x = 7, next = 1
                // curt = 5, x = 1, next = 3
                break;
            }
            curt = curt.next;
            next = next.next;
        }
        
        newNode.next = next;
        curt.next = newNode;
        return newNode;
    }
}