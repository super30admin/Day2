// Time Complexity : O(n) where n is length of inner DS that is linked list- 1000 
// so O(1) which is constant
// Space Complexity : O(n) where n is count of elements, which are 10000 * 1000 
// so constant O(1)
// Did this code successfully run on Leetcode : yes
// Approach  : 
// the primary storage is of Array which is contigous memory, for which the size we take is 10000
// the secondary storage for linking is linked list which can be of max length 1000

public class MyHashMap {

    private Node[] storage;

    public class Node
    {
        public int key;
        public int value;
        public Node next;
        public Node (int key, int value)
        {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int hashing(int key)
    {
        return key%10000;
    }

    public MyHashMap() {
        storage = new Node[10000];
    }

    public Node search(Node head,int key)
    {
        // will get the previous pointer to the key we are seaching.
        Node prev = head;
        Node curr = prev.next;
        while(curr!=null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void Put(int key, int value) {
        int hashIndex = hashing(key);
        if(storage[hashIndex] == null)
        {
            storage[hashIndex] = new Node(-1,-1);
        }
        Node prev = search(storage[hashIndex],key);
        if(prev.next!=null)
        {
            prev.next.value = value;
        }
        else
        {
            prev.next = new Node(key,value);
        }
        
    }
    
    public int Get(int key) {
        int hashIndex = hashing(key);
        if(storage[hashIndex] == null)
        {
            return -1;
        }
        Node prev = search(storage[hashIndex],key);
        if(prev.next == null)
        {
            return -1;
        }
        return prev.next.value;
    }
    
    public void Remove(int key) {
        int hashIndex = hashing(key);
        if(storage[hashIndex] == null)
        {
            return;
        }
        Node prev = search(storage[hashIndex],key);
        if(prev.next == null)
        {
            return;
        }
        Node tmp = prev.next;
        prev.next = tmp.next;
        tmp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key,value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */