class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private Node[] storage;

    public MyHashMap() {
        this.storage = new Node[10000];
   
    }

    private int hashIdx(int key){
        return key%10000;
    }

    private Node Search(Node head, int key){
        //returns the previous node for the current key we are searching
        Node prev = head;
        Node cur = head.next;
        while(cur!= null && cur.key!=key){
            prev = cur;
            cur = cur.next;
        }
        return prev;


    }
    
    public void put(int key, int value) {
        // if the key already exists and if the key doesn't exist previously
        int idx = hashIdx(key);
        if(storage[idx] == null){
            storage[idx] = new Node(-1,-1);
        }
        Node prev = Search(storage[idx],key);
        //fresh
        if(prev.next == null){
            Node node = new Node(key, value);
            prev.next = node;
        } else{
            prev.next.val = value;
        }
        
    }
    
    public int get(int key) {
        int idx = hashIdx(key);
        if(storage[idx] == null) return -1;
        Node prev = Search(storage[idx],key);
        if(prev.next == null) return -1;
        else return prev.next.val;
    }
    
    public void remove(int key) {
        int idx = hashIdx(key);
        if(storage[idx] == null) return;
        Node prev = Search(storage[idx],key);
        if(prev.next == null) return;
        else{
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
        }
    }
}
