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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return null;
        }
        
        int capacity = hashTable.length;
        int newCapacity = 2 * capacity;
        ListNode[] newTable = new ListNode[newCapacity];
        
        for (int i = 0; i < capacity; i++) {
            while (hashTable[i] != null) {
                int index = (hashTable[i].val % newCapacity + newCapacity) % newCapacity;
                ListNode node = new ListNode(hashTable[i].val);
                
                if (newTable[index] == null) {
                    newTable[index] = node;
                    newTable[index].next = null;
                } else {  // 这里加list尾巴是因为加前面不给过。。。
                    ListNode head = newTable[index];
                    while (head.next != null) {
                        head = head.next;
                    }
                    head.next = node;
                    node.next = null;
                }
                
                hashTable[i] = hashTable[i].next;
            }
        }
        
        return newTable;
    }
};