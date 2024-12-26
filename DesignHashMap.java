// Time Complexity : O (n/k) put, get, remove where k = hashmap array capacity
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {

    class Container {
        class ListNode {
            int key;
            int val;
            ListNode next;
            ListNode prev;

            ListNode() {
            }
            
            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        ListNode head;
        ListNode tail;

        Container() {
            head = null;
            tail = null;
        }

        public void add(int key, int val) {
            for (ListNode x = head; x != null; x = x.next) {
                if (x.key == key) {
                    x.val = val;
                    return;
                }
            }
            final ListNode l = tail;
            final ListNode newNode = new ListNode(key, val);
            newNode.prev = l;
            tail = newNode;
            if (l == null)
                head = newNode;
            else
                l.next = newNode;
        }

        public void remove(int key) {
            ListNode x;
            for (x = head; x != null; x = x.next) {
                if (x.key == key) {
                    break;
                }
            }
            if (x == null) return;
            final ListNode next = x.next;
            final ListNode prev = x.prev;

            if (prev == null) {
                head = next;
            } else {
                prev.next = next;
                x.prev = null;
            }

            if (next == null) {
                tail = prev;
            } else {
                next.prev = prev;
                x.next = null;
            }
        }

        public int search(int key) {
            for (ListNode x = head; x != null; x = x.next) {
                if (x.key == key)
                    return x.val;
            }
            return -1;
        }
    }

    private final int capacity = 10000;
    Container[] hashTable;


    public MyHashMap() {
        hashTable = new Container[capacity];
    }
    
    public void put(int key, int value) {
        int index = key % capacity;
        if (hashTable[index] == null) {
            hashTable[index] = new Container();
        }
        hashTable[index].add(key, value);
    }
    
    public void remove(int key) {
        int index = key % capacity;
        if (hashTable[index] == null) {
            return; // do nothing
        }
        hashTable[index].remove(key);
    }
    
    public int get(int key) {
        int index = key % capacity; 
        if (hashTable[index] == null) {
            return -1;
        }
        return hashTable[index].search(key);
    }
}
