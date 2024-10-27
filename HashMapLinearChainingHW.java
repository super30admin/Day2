/*
    Time Complexity : {Time Complexity is analyzed based on => Whenever we are receiving some input, with the increase in our input, how our
                        algorithm performs}
                      In order to  optimize performance we are increasing the primary data structure size and decreasing the secondary data
                      structure size to have fewer collisions. If our time complexity is not increasing after a particular point,and that point
                      is a very small number, we can tell our average time complexity is O(1), here the small number for us is 100 in
                      secondary data structure.

    Note: If interviewer is asking that 100 size of secondary bucket is also large number, and it is affecting performance, then the answer can
    be I can check in production and based on performance if time complexity is not O(1) or more, I can increase the size of primary data structure.

    Note: It is also means increase of size of primary data structure and decrease of secondary data structure is trade off between
    performance and space.

    Space Complexity : For user oriented functions, all the functions put(), get(), remove() will be having amortized complexity O(1). For constructor,
    we are creating storage so it will have O(n) but that is not what we be looking at. We only look at what we created for user.

    Did this code successfully run on Leetcode : Yes

    HASH MAP USING LINEAR CHAINING {HOMEWORK}

    Here the primary dataset will be a Node Array and secondary will be linkedlist, in java hash map by default uses Linear chaining to
    handle collisions

    null, __ , null, null {primary buckets}
           ↓
        -1, -1            {linked list}
           ↓
        2001, 3
           ↓
        3001, 5

    Here, like in previous homework Design 1, we choose 1000 for primary bucket and 1000 for secondary bucket, we followed this formula
    where we took square root of 10^6 so we got 1000 Primary bucket and 1000 secondary bucket, but here if we use that size, we will have 1000
    collisions.
 */
class HashMapLinearChainingHW {

    class Node
    {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] storage; //Primary array
    int primaryBucketSize;

    public HashMapLinearChainingHW() {
        /*
        As the bucket size is 10000, there will be 100 collisions, due to less collisions, after 100 elements, the time to access
        the element, basically search will become constant i.e. O(1)
        */
        this.primaryBucketSize = 10000;
        this.storage = new Node[primaryBucketSize];
    }

    private int getPrimaryHash(int key) {
        return key%primaryBucketSize;
    }

    private Node getPrevNode(Node head, int key) {
        Node prev = null;
        Node curr = head;

        //Traversing through the nodes to find previous
        while(curr != null && curr.key!=key)
        {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public void put(int key, int value) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] ==  null){
            storage[primaryIndex] = new Node(-1, -1);
        }
        /*
        There will be two scenarios:
        1) If the node exists, replace the value.
        2) If he node doesn't exist, we will reach the end of linked list and the last node will point to null, so point the last node
        to point to new node and new node will point to null.

        Note: We will not need a tail pointer, as anyway due to point 1, we have to traverse through complete linked list to check if the
        value exists, it doesn't then only we will add a new node in end, so tail pointer is of no use.
         */

        Node prev = getPrevNode(storage[primaryIndex], key);
        if(prev.next == null) //Point 2
        {
            prev.next = new Node(key, value);
        }
        else {
            prev.next.value = value; //Point 1
        }
    }

    public int get(int key) {

        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] ==  null) { //Primary index location in array itself is null
            return -1;
        }

        Node prev = getPrevNode(storage[primaryIndex], key);
        if(prev.next == null) { //Point 2, element not found after traversal
            return -1;
        }

        return prev.next.value;
    }

    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] ==  null) { //Primary index location in array itself is null
            return;
        }

        Node prev = getPrevNode(storage[primaryIndex], key);
        if(prev.next == null) { //Point 2, element not found after traversal
            return;
        }

        /*
        eg: remove 3 hashmap {100,2 ; 101,3 ; 102,5}
            prev = {100}
            prev.next = curr.next => old value of prev.next is 101, new value is 102
            curr.next = null meaning 101 is made to point to null
        */
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */