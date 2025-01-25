// Overall Time Complexity : O (1) . The put, get and remove operations happens in O(1).
// Overall Space Complexity : O(n) . The space complexity of storing the n nodes and m number of hashmaps at each index O(m+n).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The solution to the problems involves using a storage array which points to a linked list and using an efficient 
// hash function so that we avoid the collision of keys . This technique is also called linear chaining,

class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Node[] storage;
   
    
    private int hashIdx(int key){
        return key%10000;
    }
    public MyHashMap(){
        this.storage = new Node[10000];
    }

    private Node search(Node head, int key){
        Node prev = head;
        Node curr = head.next;

        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {

        int idx = hashIdx(key);

        if(storage[idx] == null){
            storage[idx] = new Node(-1,-1);
        }

        Node prev = search(storage[idx], key);
        if(prev.next!=null){
            prev.next.value = value;
        }
        else{
            prev.next = new Node(key,value);
        }
    
    }
    
    public int get(int key) {
        int idx = hashIdx(key);
        if(storage[idx] == null) return -1;

        Node prev = search(storage[idx],key);
        if(prev.next==null){
            return -1;
        }
        else{
            return prev.next.value;
        }
    }
    
    public void remove(int key) {
        int idx = hashIdx(key);
        if (storage[idx] == null) return;
        Node prev = search(storage[idx], key);
        if (prev.next == null) return;
        if(prev.next != null){
            Node temp = prev.next;
            prev.next = prev.next.next;
            temp.next = null;
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
