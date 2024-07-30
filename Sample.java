// Time Complexity :O(N)
// Space Complexity :
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashMap 
{
    class Node
    {
        int key;
        int val;
        Node next;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    private Node[] storage;
    private int buckets;
    public MyHashMap() 
    {
        this.buckets = 10000;
        this.storage = new Node[this.buckets];

    }
    private int hash(int key)
    {
        return key%10000;
    }
    private Node search(Node head, int key)
    {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) 
    {
        int bucket = hash(key);
        if(storage[bucket]==null)
        {
            storage[bucket] = new Node(-1,-1);
        }
        Node prev = search(storage[bucket],key);
        if(prev.next == null)
        {
            prev.next = new Node(key, value);
        }
        else
        {
            prev.next.val = value;
        }
    }
    
    public int get(int key) 
    {
        int bucket = hash(key);
        if(storage[bucket]==null)
        {
            return -1;
        }  
        Node prev = search(storage[bucket],key);
        if(prev.next == null)
        {
            return -1;
        }
        return prev.next.val;
    }
    
    public void remove(int key) 
    {
        int bucket = hash(key);
        if(storage[bucket]==null)
        {
            return;
        }   
        Node prev = search(storage[bucket],key);
        if(prev.next == null)
        {
            return;
        }
        Node curr = prev.next;
        prev.next = prev.next.next;
        curr.next = null;
    }
}