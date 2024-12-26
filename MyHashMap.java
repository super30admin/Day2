// Time Complexity :O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : To find the space complexity.

//the logic here is to use array of ll (using separate chaining).
class MyHashMap {
    //Class Node which contains key, value and next node
    public class Node{
        int key, value;
        Node  next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    //size of the array
    int buckets;
    //Node(s) array to store the key , vaue and next node(s).
    Node[] storage;
    //hash function to get the index
    private int getHashValue(int key){
        return key % buckets;
    }
    //This is main logic which return the previous node in linked list of the key which we've provided.
    private Node findPreviousNode(Node dummyNode, int key){
        //point prev node to dummy node which will contains (-1,-1) in every case.
        Node prev = dummyNode;
        Node curr = prev.next;
        //Stop only if the current node has reached to null and key value doesnt match which mean we couldn't find the key in the linked list.
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        //return the previous node.
        return prev;
    }

    public MyHashMap() {
        buckets = 1000;
        storage =  new Node[buckets];
    }

    public void put(int key, int value) {
        //1st get the hash value to find the index of the array.
        int bucket = getHashValue(key);
        //check if the value if that index is null if yes create a new dummy node.
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
        //find the previous node to the key
        Node previousNode = findPreviousNode(storage[bucket],key);
        //if the prev node next value is null it means there is no node present with key provided create a new node and point the previous.next to that node.
        if(previousNode.next == null){
            previousNode.next = new Node(key,value);
        }
        //if prev.next has value it means there was alreay a node with that key , then replace the value.
        else{
            previousNode.next.value = value;
        }
    }

    public int get(int key) {
        int bucket = getHashValue(key);
        //check if the value if that index is null if yes return -1 as asked.
        if(storage[bucket] == null){
            return -1;
        }
        Node previousNode = findPreviousNode(storage[bucket],key);
        if(previousNode.next != null){
            return previousNode.next.value;
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = getHashValue(key);
        if(storage[bucket] == null){
            return;
        }
        Node previousNode = findPreviousNode(storage[bucket],key);
        if(previousNode.next != null){
            previousNode.next = previousNode.next.next;
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