// Amortized Time Complexity for Put,Get,Remove : O(1)
// Time Complexity for Put,Get,Remove : O(n), where n is the size of each bucket
// Space Complexity for HashMap: O(n), where n is the range of key elements

// Approach: Linear chaining technique, where we have buckets of linkedlists

public class MyHashMap {
    
    public class Node{
        public int Key;
        public int Value;
        public Node Next;
        
        public Node(int k, int v)
        {
            Key = k;
            Value = v;
        }
    }
    
    int bucketSize = 10000;
    Node[] arr;
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new Node[10000];
    }
    
    private int getHash(int key){
        return key%bucketSize;
    }
    
    private Node getPrev(int key){
        int hash = getHash(key);
        
        if(arr[hash] == null)
            return null;
        
        Node cur = arr[hash];
        
        while(cur!=null && cur.Next!=null && cur.Next.Key != key)
            cur = cur.Next;
        
        return cur;
    }
    
    /** value will always be non-negative. */
    public void Put(int key, int value) {
        Node prev = getPrev(key);
        
        // create bucket if not present
        if(prev == null){
            int hash = getHash(key);
            arr[hash] = new Node(-1, -1);
            prev = arr[hash];
        }
        
        // if key doesn't exist add it
        if(prev.Next == null){
            prev.Next = new Node(key, value);
        }else{
            prev.Next.Value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int Get(int key) {
        Node prev = getPrev(key);
        if(prev == null || prev.Next==null)
            return -1;
        return prev.Next.Value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void Remove(int key) {
        Node prev = getPrev(key);
        if(prev != null && prev.Next!=null)
            prev.Next = prev.Next.Next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key,value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */