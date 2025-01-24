// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashMap {

    class Node{

        int key;
        int val;
        Node next; // Reference to the next node in the linked list

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }

    }

    // Array to store the hash map's buckets
    Node arr[];

    public MyHashMap() {
        this.arr = new Node[10000];
    }

    // Returns the previous node to enable insertion/deletion
    Node search(Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while(curr!=null && curr.key!=key){ // Traverse the linked list until the key is found or end is reached
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    // Hash function to convert key to an index in the array
    int hashIndx(int key){
        return key%10000;
    }

    // Insert or update a key-value pair
    public void put(int key, int value) {
        int index = hashIndx(key);
        // Create a dummy head node if the bucket is empty
        if(arr[index] == null){
            arr[index] = new Node(-1,-1);
        }
        Node prev = search(arr[index], key); // Find the previous node to the target key
        if(prev.next != null){
            prev.next.val = value;
        }else{
            prev.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int index = hashIndx(key); // Find the bucket index for the key
        if(arr[index] == null){
            return -1;
        }
        Node prev = search(arr[index], key);
        if(prev.next == null){
            return -1;
        }else{
            return prev.next.val;
        }
    }

    public void remove(int key) {
        int index = hashIndx(key);
        if(arr[index] == null){
            return;
        }
        Node prev = search(arr[index], key);
        if(prev.next == null){
            return;
        }
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

/*
* Direct Access: Arrays allow O(1) index-based access, which is crucial for hash map performance
* The array serves as buckets where the hash function maps keys to specific indices, enabling quick distribution and retrieval.
* Collision Handling: Each array index can be the head of a linked list, allowing multiple key-value pairs to be stored at the same index.
* */