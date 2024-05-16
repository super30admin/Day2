/**
 * Approach: Using separate chaining tho solve this problem i.e Linked List for add ing and removing values in an hash map
 *
 * Working:
 *      dummyNode - always adding the first nod in an index as a dummy node with {key:-1,value-1}
 *                  the dummy node is added to make the removal of the node operation easy in was such that
 *                  the will not bea need to change the reference of a bucket index each in the storage
 *      find - Used to find i an node is already present
 *      put - if node already present update the value or traverse the list in the index and add it at the end, i first node add a dummy node and add the
 *              current node as the next of the dummyNode
 *      get - use find() to return value, if not return -1
 *      remove - remove the node from the list if present
 *
 * Time Complexity: O(n) - (put, get, remove, find)
 * Space Complexity: O(n)
 *
 */



public class MyHashMap {

    int bucketSize;
    Node[] storage;

    public MyHashMap() {
        bucketSize = (int) Math.pow(10,3);
        storage=new Node[bucketSize+1];
    }

    int getBucket(int key){

        return Integer.hashCode(key) % bucketSize;
    }

    private Node find(Node dummy, int key) {
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr!=null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }


    public void put(int key, int value) {

        int bucket = getBucket(key);
        if(storage[bucket]==null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            prev.next.value = value;
        } else {
            prev.next = new Node(key, value);
        }

    }

    public int get(int key) {

        int bucket = getBucket(key);
        if(storage[bucket]==null) {
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            return prev.next.value;
        }
        return -1;

    }

    public void remove(int key) {

        int bucket = getBucket(key);
        if(storage[bucket]==null) {
            return;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    class Node {

        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
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