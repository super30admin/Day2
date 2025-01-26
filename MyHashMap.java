class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    Node[] storage;
    int buckets;

    public MyHashMap() {
        this.buckets=10000;
        this.storage=new Node[10000];
    }
    private Node search(Node head,int key){
        //returns the previous Node
        Node prev= head;
        Node cur=head.next;
        while(cur!=null && cur.key!=key){
            prev=cur;
            cur=cur.next;
        }
        return prev;
    }
    private int hash(int key){
        return key%10000;
    }

    public void put(int key, int value) {
        int idx=hash(key);
        if(storage[idx]==null){
            storage[idx]= new Node(key,value);
        }
        Node prev=search(storage[idx],key);
        if(prev.next==null){
            prev.next =new Node(key,value);
            return;
        }
        else{
            prev.next.val=value;
        }
    }

    public int get(int key) {
        int idx=hash(key);
        if(storage[idx]==null) return -1;
        Node prev=search(storage[idx],key);
        if(prev.next==null){
            return -1;
        }
        else{
            return prev.next.val;
        }
    }

    public void remove(int key) {
        int idx=hash(key);
        if(storage[idx]==null) return;
        Node prev=search(storage[idx],key);
        if(prev.next==null)return;
        Node temp=prev.next;
        prev.next=temp.next;
        temp=null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */