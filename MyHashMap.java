//Time Complexity: O(1) on average, O(n) for worst-case
//Space Complexity:O(constant), the number of entries is fixed.

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyHashMap { //create a node with key,value and next pointer in it
    Node[] nodes;

    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() { //instantiate with size 10001

        nodes = new Node[10001];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) { //for pushing, getting the index of the key 
        int index = getIndex(key);

        // fetching previous node, so that we can trace to next element since its singly linked list
        Node prev = findElement(index, key);

        if (prev.next == null) { //checking if that node points to null
            prev.next = new Node(key, value); //assigning the new node to that
        } else {
            // If same key with collision then update value
            prev.next.value = value;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) { //getting the index of the key, getting the prev
        int index = getIndex(key);
        Node prev = findElement(index, key);
        return prev.next != null ? prev.next.value : -1; //if prev.next is not null then returning the prev.next data or returning -1
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) { //for removing, getting the index, getting the prev
        int index = getIndex(key);
        Node prev = findElement(index, key);

        if (prev.next != null) //checking if prev.next is not null, that is if its null then we have reached the last element i.e,. nothing else to remove
            prev.next = prev.next.next; //if true then modify the prev.next
    }

    public int getIndex(int key) { //hashing mechanism to get the index
        return Integer.hashCode(key) % nodes.length;
    }

    public Node findElement(int index, int key) { 
        //If no value exist at the particular index, create a node with (-1,-1) (key,value) pair , store it in the array and return it.
        if (nodes[index] == null)  //if the there is no node with that index then return null
            return nodes[index] = new Node(-1, -1);

        //for traversing the array
        Node prev = nodes[index]; 

        //index is the hashed value of the key, we will compare the keys and return the value accordingly where the key matches.
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;

    }


public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // returns 1
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.get(2);            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found)
    }
}
