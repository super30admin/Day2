// Time Complexity : O(1)
// Space Complexity : O(N), where N is the number of entries
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//using separate chaining
public class MyHashMap {

    //bucket
    int bucket;
    Node[] nodes;
    int key, value;

    //linkedlist node
    public class Node{
        Integer key, value;
        Node next;
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }


    public MyHashMap() {
        //bucket size is 10000 since we need the linked list size to be only 100 for each of the buckets as it will decrease the complexity. O(100) -> O(1)
        bucket = 10000;
        nodes = new Node[bucket];
    }

    //get bucket through the given key and the bucket size
    public int getBucket(int key){
        return key % bucket;
    }

    //
    public void put(int key, int value) {
        //get the bucket for the given key
        int index = getBucket(key);
        Node prev;

        //if the head is null for linkedlist, key is encountered for the first time,
        // so create a new linkedlist with dummy head and values that cannot be keys
        if(nodes[index] == null){
            nodes[index] = new Node(null, null);;
        }

        //get the pointer to previous node
        prev = find(nodes[index], key);

        //if the key exists, update the value of the key
        if(prev.next != null){
            prev.next.value = value;
        }
        else {
            //if the key doesn't exist, create a new node with the key and the value
            prev.next = new Node(key, value);
        }

    }

    //find the if the key exists in the bucket by parsing through the linked list of the bucket
    public Node find(Node head, int key){
        Node prev = head;
        Node curr = head.next;

        while(curr!= null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        //return the prev node when the key is found
        return prev;
    }

    //get the value of the key
    public int get(int key) {

        //get the bucket for the given key
        int index = getBucket(key);

        //if the head is null for linkedlist, return -1
        if(nodes[index] == null){
            return -1;
        }

        //get the pointer to previous node
        Node prev = find(nodes[index], key);

        //if the prev node is null, key doesn't exist
        if(prev.next == null) return -1;

        //return next of prev value i.e.,curr value
        return prev.next.value;
    }

    //remove the key and the corresponding value
    public void remove(int key) {

        //get the bucket for the given key
        int index = getBucket(key);

        //if the head is null for linkedlist, return
        if(nodes[index] == null){
            return;
        }

        //get the pointer to previous node
        Node prev = find(nodes[index], key);

        //if the prev node is null, key doesn't exist
        if(prev.next == null) return;

        //if the key exists, make it point to current node's next node
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */