class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    Node buckets[];
    public MyHashMap() {
        buckets = new Node[10000];
    }
    
    public int getHash(int key){
        int rem=key%10000;
        return rem;
    }
    
    public void put(int key, int value) {
        int location = getHash(key);
        if(buckets[location]==null){
            buckets[location] = new Node(-1,-1);
        }
        Node prev = find(buckets[location],key);
        if(prev.next==null){
            prev.next = new Node(key,value);
        }else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int location = getHash(key);
        if(buckets[location]==null){
            return -1;
        }
        Node prev = find(buckets[location],key);
        if(prev.next==null){
            return -1;
        }else{
            return prev.next.value;
        }
    }
    
    public void remove(int key) {
        int location = getHash(key);
        if(buckets[location]==null){
            buckets[location] = new Node(-1,-1);
        }
        Node prev = find(buckets[location],key);
        if(prev.next==null){
            return;
        }else{
            prev.next = prev.next.next;
        }
    }
    public Node find(Node head,int key){
        Node prev = head;
        Node current = head.next;
        while(current!=null && current.key!=key){
            prev=current;
            current = current.next;
        }
        return prev;
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */