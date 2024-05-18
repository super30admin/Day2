/**
 *
 * This Hash map class is implemented using Separate Chaining
 * Save each pair as Node and arrange this nodes using separate chaining
 * Alogorithm:
 *
 * put(key, value):
 * - getBucketIndex(key) is a hash function. hash the key and get the bucket index.
 * - create a node with key and value and add it to the end of the end of the linked list in the array.
 * - if No list is present(i.e null value) then create a dummy node(-1,-1) adn the append the created node.
 *
 * get(key):
 * -Get the hash value of the key
 * -get the linked list in the array and find the key from the linked list(getPrevNode() function)
 *
 * remove(key):
 * - Just like above get the hash value of the key and find the prev value.
 *
 * Time Complexity:
 * - put(key,value) --> O(n)
 * - get(key) --> O(n)
 * - remove(key) -->O(n)
 * Space Complexity:
 * - put(key,value) --> O(1)
 * - get(key) --> O(1)
 * - remove(key) -->O(1)
 *
 */

class MyHashMap {
    private Node[] storage;
    //Took 10^4 instead of sqrt(10^6) 
    // because we are not having a space of 10^3 added while adding a array with in the bucket
    private int bucketSize = 10000;
    class Node{
        int key, value;
        Node next;
        public Node (int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public MyHashMap() {
        storage = new Node[bucketSize];
    }
    private int getBucketIndex(int key){
//        Using the default hashCode function
        return Integer.hashCode(key)%bucketSize;
    }
    public void put(int key, int value) {
        int bucketIndex = getBucketIndex(key);
        if(storage[bucketIndex] == null){
            storage[bucketIndex] = new Node(-1,-1);
        }
        Node prev = getPrevNode(storage[bucketIndex],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }else{
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int bucketIndex = getBucketIndex(key);
        Node prev = getPrevNode(storage[bucketIndex],key);
        return prev.next ==  null?-1:prev.next.value;
    }

    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        Node prev = getPrevNode(storage[bucketIndex],key);
        if(prev.next != null)
            prev.next = prev.next.next;
    }

    public Node getPrevNode(Node bucket, int key){
        Node prev = bucket;
        while(prev.next != null){
            if(prev.next.key == key){
                return prev;
            }
            prev = prev.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,2);
        map.put(2,3);
        map.put(1,4);

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */