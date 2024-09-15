class MyHashMap {

    int arr[];

    class Node {
        int key,val;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;

        }
    }

    Node[] nodes;
    int buckets;

    private int getBucket(int key){
        return Integer.hashCode(key)%buckets;
    }

    private Node find (Node head, int key) {
        Node prev =head;
        Node curr = head.next;

        while(curr!=null && curr.key!=key){
            prev = curr;
            curr= curr.next;
        }

        return prev;
    }

    public MyHashMap() {       
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    public void put(int key, int val) {
       int pos = getBucket(key);
       if(nodes[pos] == null){
            nodes[pos] = new Node(-1,-1);
       }
       Node prev = find(nodes[pos],key);

       if(prev.next==null){
        prev.next = new Node(key,val);
       }
       else{
           prev.next.val = val;
       }


    }
    
    public int get(int key) {
        int pos = getBucket(key);
        if(nodes[pos] == null){
            return -1;
        }
        
        Node prev = find(nodes[pos],key);

        if(prev.next==null){
            return -1;
        }

        return prev.next.val;

    }
    
    public void remove(int key) {
        int pos = getBucket(key);
        if(nodes[pos] == null){
            return ;
        }
        
        Node prev = find(nodes[pos],key);

        if(prev.next==null){
            return ;
        }

        prev.next=prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */