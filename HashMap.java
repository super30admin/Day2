/*Time Complexity O(1)
Space Complexity O(n)*/
class MyHashMap {

    class Node{
        int key;
        int val;
        Node next; // pointer - pointing to next node
        //Constructor
        public Node(int key, int val){
            //Init key and value
            this.key = key;
            this.val = val;
        }
    }

    Node[] storage;
    private int hash(int key){
        return key%10000;
    }

    public MyHashMap() {
        //Init storage
        this.storage = new Node[10000];
    }

    private Node find(Node node, int key){ // Passing head poiner and key
        //2 pointers
        Node prev = null;
        Node curr = node;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        if(storage[hash] == null){
            storage[hash] = new Node(-1,-1); // dummy node as a place holder
        }
        Node prev = find(storage[hash], key);
        if(prev.next == null){ // prev is the last node if null
            //add a new node here
            prev.next = new Node(key,value);
        }else{
            prev.next.val = value; //If already exists, update the value
        }
    }

    public int get(int key) {
        int hash = hash(key);
        if(storage[hash] == null) return -1; // no mapping, key not found
        Node prev = find(storage[hash], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }

    public void remove(int key) {
        int hash = hash(key);
        if(storage[hash] == null) return;
        Node prev = find(storage[hash], key);
        if(prev.next == null) return;
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