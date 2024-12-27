// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO

public class DesignHashMap {
 //Create a Node class
    class Node{
        int key,value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    int buckets;
    Node[]storage;

     int getBuckets(int key) {
         return Integer.hashCode(key) % this.buckets;
    }
// Responsible for finding the Node in the array. Will be used for all put,get,remove operations.
    private Node find(Node dummy, int key){
         Node prev = dummy;
         Node curr = dummy.next;
         while(curr != null && curr.key != key){
             prev = curr;
             curr = prev.next;
         }
         return prev;
    }

    public DesignHashMap(){
         this.buckets = 1000;
         storage = new Node[this.buckets];

    }
//get the bucket value and find  the Node
// If Node already present update it
// If not add it at the end

    public void put(int key,int value){
         int bucket = getBuckets(key);
         if(storage[bucket] == null){
             storage[bucket] = new Node(-1,-1);
         }
         Node prev = find(storage[bucket],key);
         if (prev.next != null){
             prev.next.value = value;

         }
         else{
             prev.next = new Node(key,value);
         }
    }
//get the bucket value.
// If you can't find the value return -1 or return the value.

    public int get(int key){
        int bucket = getBuckets(key);
        if(storage[bucket] == null){
            return -1;
        }
        Node prev = find(storage[bucket],key);
        if (prev.next == null){
            return -1;
        }
        return prev.next.value;
    }

//get the bucket value.
//If you find the node assign prev next to next node.

    public void remove(int key) {
        int bucket = getBuckets(key);
        if(storage[bucket] == null){
            return ;
        }
        Node prev = find(storage[bucket],key);
        if (prev.next != null){
            prev.next = prev.next.next;
        }
    }
}
