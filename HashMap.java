// Time Complexity : O(1) for all functions
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// DS used is an array  of LL with Separate chaining of a Linked List.

class MyHashMap {
    Node[] storage;
    int buckets;

    class Node{

        int key;
        int value;
        Node next;
        Node(int key, int value){
            this.key = key ;
            this.value = value;
            next = null;
        }
    }
    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }
    //Hash Function 
    private int hashfunction(int key){
        return key%buckets;
    }

    private Node findPrev(Node head, int key){
        Node prev = null;

        Node curr = head;
        while(curr != null && curr.key !=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    /*1. get hash of the key 
    2. check if that index is null -> if null create a nnew linkedlist attached to it.
    3. else find the prev pointer where you need to add
    4. add or update list */
    public void put(int key, int value) {
        int index = hashfunction(key);
        if(storage[index]==null){
            storage[index]= new Node(-1,-1);
        }
        Node prev = findPrev( storage[index], key);
        if(prev.next == null){
            prev.next = new Node(key,value);
            prev.next.next= null;
        } else {
            prev.next.value=value;
        }
    }
    
    public int get(int key) {
        int index = hashfunction(key);
        if(storage[index]==null) return -1;
        Node prev = findPrev(storage[index], key);
        if(prev.next == null) return -1;
        else return prev.next.value;
    }
    
    public void remove(int key) {
        int index= hashfunction(key);
        if(storage[index]==null) return;
        Node prev = findPrev(storage[index], key);
        if(prev.next==null)return;
        prev.next=prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */