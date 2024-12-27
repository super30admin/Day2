// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MyHashMap {
    //Node class
    class Node{
        int key,value;
        Node next; //null by default
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int buckets; // every array index
    Node[] storage;

    //get the hash key
    int getBuckets(int key) {
        return Integer.hashCode(key) % this.buckets;
    }

    // returns the previous node in the list.
    //T.C: O(n) n is number of bucket items
    private Node find(Node dummy, int key){
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public MyHashMap(){
        this.buckets = 1000;
        storage = new Node[this.buckets];
    }


    public void put(int key, int value){
        int bucket = getBuckets(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1); //create a dummy node
        }
        //finds the previous node, and checks if next node exists? If not create a new node and add the value. If present, update the value.
        Node prev = find(storage[bucket], key);
        if (prev.next != null){
            prev.next.value = value;

        }
        else{
            prev.next = new Node(key,value);
        }
    }


    public int get(int key){
        int bucket = getBuckets(key);
        if(storage[bucket] == null){
            return -1;
        }
        //finds the previous node, and checks if next node exists? If exists, returns the next value, if not return -1.
        Node prev = find(storage[bucket],key);
        if (prev.next == null){
            return -1;
        }
        return prev.next.value;
    }


    public void remove(int key) {
        int bucket = getBuckets(key);
        if(storage[bucket] == null){
            return ;
        }
        Node prev = find(storage[bucket],key);
        //remove the node and update the prev.next to next node of removed node
        if (prev.next != null){
            prev.next = prev.next.next;
        }
    }
}
