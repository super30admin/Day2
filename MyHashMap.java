// Time Complexity : O(length of array/length of nested data structure) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {

    class Node {

        int key;
        int val;
        Node next;

        public Node(int key, int val) {

            this.key = key;
            this.val = val;
        }
    }

    private Node[] storage;
    private int buckets;

    public MyHashMap() {

        this.buckets = 10000;
        this.storage = new Node[this.buckets];

    }

    // gives prev node to current key that we are searching
    private Node search(Node head, int key) {

        Node prev = head;
        Node current = head.next;
        while(current != null && current.key!=key){

            prev = current;
            current=current.next;


        }
        return prev;
    }

    private int hash(int key) {

        return key / buckets;

    }

    public void put(int key, int value) {

        int index = hash(key);
        if (storage[index] == null) {

           storage[index] = new Node(-1, -1);
        }
        // fresh vs non fresh
        Node prev = search(storage[index], key);
        if (prev.next != null) {
            prev.next.val = value;

        } else {

            prev.next = new Node(key, value);
        }

    }

    public int get(int key) {  
                 int index = hash(key);    
                 if(storage[index]==null){
                      return -1;
                 }
    Node prev = search(storage[index],key);

       if(prev.next==null){
           return -1;
       }
       else{
             return prev.next.val;

       }
  
       
    }

    public void remove(int key) {

        int index = hash(key);
        if (storage[index] == null) {
            return;
        }

        Node prev = search(storage[index], key);
        if(prev.next==null) return;
        Node temp=prev.next;
        prev.next=temp.next;
        temp.next=null;
           
        


    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
