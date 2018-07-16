class Node {
    int key, value;
    Node prev, next;
    
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}


public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> hash;
    private Node head, tail; // two dummy nodes
    
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        hash = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void moveToTail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!hash.containsKey(key)) {
            return -1;
        }
        
        // remove current
        Node current = hash.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        
        moveToTail(current);  //the most recently used node is in the end
        
        return current.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        
        // get 这个方法会把key的node挪到最末端，因此，不需要再调用 moveToTail
        if (get(key) != -1) {
            tail.prev.value = value;  // 修改node的值
            // or hash.get(key).value = value;
            return;
        }
        
        if (hash.size() == capacity) {
            hash.remove(head.next.key); // remove first node's key-value pair in hashmap
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node newNode = new Node(key, value);
        hash.put(key, newNode);  // pay attention. not hash.put(key, value);
        moveToTail(newNode);
    }
}