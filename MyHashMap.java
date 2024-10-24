class MyHashMap {
// Time Complexity :put: O(1)
//                  get: O(1)
//                  remove: O(1)
// Space Complexity :put: O(1)
//                   get: O(1)
//                   remove: O(1)
//                   constructor: O(n) (because we are creating storage array)
// Approach : Using Linear chaining with storage Array of LinkedList Nodes

    class Node{
        int key;
        int value;
        Node next;
        public Node(int key , int value){
            this.key = key;
            this.value=value;
        }
    }
    Node[] storage;
    int primaryBuckets;

    public MyHashMap() {
        this.primaryBuckets = 10000;
        this.storage = new Node[primaryBuckets];
    }

    private int getPrimaryHash(int key){
        return key % primaryBuckets;
    }

    private Node getPrev(Node head,int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int primaryHashIndex = getPrimaryHash(key);
        if (storage[primaryHashIndex] == null){
            storage[primaryHashIndex] = new Node(-1,-1); // dummy node
        }
        Node prev=getPrev(storage[primaryHashIndex],key);
        if(prev.next != null){
            prev.next.value = value;
        } else{
            prev.next = new Node(key,value);
        }
    }
    
    public int get(int key) {
      int primaryHashIndex = getPrimaryHash(key);
      if (storage[primaryHashIndex] == null){
        return -1;
      }
      Node prev = getPrev(storage[primaryHashIndex],key) ;
      if(prev.next == null){
        return -1;
      } else{
        return prev.next.value;
      }
    }
    
    public void remove(int key) {
        int primaryHashIndex = getPrimaryHash(key);
        if (storage[primaryHashIndex] == null){
            return;
        }
        Node prev = getPrev(storage[primaryHashIndex],key);
        if (prev.next != null){
            Node curr = prev.next;
            prev.next = curr.next;
            curr.next = null;
        } else{
            return;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */