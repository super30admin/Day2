// Time Complexity : O(N)
// Space Complexity : O(N+M) where N is size of node array and M is number of nodes present in the data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Have to revise concepts again while coding.


// Your code here along with comments explaining your approach

class MyHashMap {

    class Node{ // creating node class for implementing singly linkedList
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node[] nodes; // creating nodes array as our main array
    int bucket; // the size of the node array

    public MyHashMap() { // cosntructor for hashmap
        bucket = 10000; // size of bucket i.e. our main node array
        nodes = new Node[bucket]; // initializing our node array
    }

    public int getBucket(int key){ // this is our hashing function which will determine the index of the key in the node array
        return Integer.hashCode(key)%bucket;
    }

    public void put(int key, int value) {
        int index = getBucket(key); // getting index of given key
        Node newNode = new Node(key,value); // initializing a new node with given key and value pair.
        if(nodes[index] == null){ // if the index is null that means we will have to initialise this linkedlist
            nodes[index] = new Node(-1,-1); // Initializing every start of singly linkedList with dummy node
        }

        Node searched = find(nodes[index],key); // using find method to get 1 node behind the serached node
        if(searched.next == null){ // if current node is null i.e. key not found then create a new node and update it at end of linkedlist
            searched.next = newNode; // if not present then add at the end of the linked list
        } else{
            searched.next.value = value; // if present then update the node with the respective key.
        }

    }

    public int get(int key) {
        int index = getBucket(key);
        if(nodes[index] == null){ // if index is not initialized then key is not present.
            return -1;
        }
        Node searched = find(nodes[index],key); // find the node
        if(searched.next == null){ // if current node is null then it means element not present
            return -1;
        }
        return searched.next.value; // return the value of the node found
    }

    public void remove(int key) {
        int index = getBucket(key);
        if(nodes[index] == null){
            return;
        }
        Node searched = find(nodes[index],key);
        if(searched.next == null){
            return;
        }
        searched.next = searched.next.next; // deleting the searched node by bypassing it
    }

    public Node find(Node head, int key){ // creating our own find method.
        Node prev = head; // this will help in remove method
        Node current = prev.next;
        while(current != null && current.key != key){ //searching till the end and till the key is not found
            prev = current;
            current = current.next;
        }
        return prev;

    }
}