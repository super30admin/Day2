// Time Complexity : O(1)
// Space Complexity : O(N) where n is capacity
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Node{
    int val;
    int key;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
    }
}
class MyHashMap {
    int capacity;
    Node [] hashTable;
    public static final int INITIAL_CAPACITY = 1000;
    public MyHashMap() {
        this.capacity = INITIAL_CAPACITY;
        this.hashTable = new Node[this.capacity];
    }

    /*
        Generates the hash key
     */

    public int hashKey(int key) {
        return Integer.hashCode(key)%this.capacity;
    }

    /*
        Finds the node in linked list using initally dummy node as prev = -1,1. if not found returns null
     */
    private Node find(Node dummy, int key){
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    /*
       If node is found, replaces its value if not creates a new node and adds to end of LL
    */
    public void put(int key, int value) {
        int bucket = hashKey(key);
        if(hashTable[bucket]==null){
            hashTable[bucket] = new Node(-1,-1);
        }
        Node prev = find(hashTable[bucket],key);
        if(prev.next != null){
            prev.next.val=value;
        } else {
            prev.next = new Node(key, value);
        }
    }
    /*
        If LL not created returns -1. Finds the node, if found, returns value if not -1
     */
    public int get(int key) {
        int bucket = hashKey(key);
        if(hashTable[bucket]==null){
            return -1;
        }
        Node prev = find(hashTable[bucket],key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.val;
    }
    /*
        If LL not created returns null. Finds the node, if found, takes prev and points it to next next to remove found node
    */
    public void remove(int key) {
        int bucket = hashKey(key);
        if(hashTable[bucket]==null){
            return;
        }
        Node prev = find(hashTable[bucket],key);
        if(prev.next!=null){
            prev.next =  prev.next.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1,1);
        hashMap.put(2,2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2,1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }
}