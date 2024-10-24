class MyHashMap {

    //Here primary DS is array so we need to store the Node to get the secondary DS
    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node[] storage;
    int buckets;

    public MyHashMap() {
        //increased the primary data structure size to reduce the secondary DS
        //this way way we are reducing no. of collisions
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }
    private int getPrimaryHash(int key){
        return key % buckets;
    }

    private Node getPrev(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            storage[primaryIndex] = new Node(-1,-1); //creating dummy node to get prev node for the 1st Node
        }
        Node prev = getPrev(storage[primaryIndex],key);
        if(prev.next == null){ //last node and couldn't find the node
            prev.next = new Node(key,value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return -1;
        }
        Node prev = getPrev(storage[primaryIndex],key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;
    }

    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == null){
            return;
        }
        Node prev = getPrev(storage[primaryIndex],key);
        if(prev.next == null){
            return;
        }
        Node curr = prev.next;
        prev.next=curr.next;
        curr.next = null;
    }
}