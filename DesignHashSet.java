class Node{
    int key;
    Node next;
    public Node(int key){
        next = null;
        this.key = key;
    }
}
class MyHashSet {
    Node[] map;
    public MyHashSet() {
        map = new Node[100057 ];
    }

    public void add(int key) {
        Node head = map[key%100057 ];
        if(head==null){
            map[key%100057 ] = new Node(key);
            return;
        }
        if(head.key == key)
            return;
        while(head.next!=null && head.next.key !=key)
            head = head.next;
        if(head.next == null){
            head.next=new Node(key);
        }
    }

    public void remove(int key) {
        Node head = map[key%100057 ];
        if(head==null){
            return;
        }
        if(head.key == key)
            map[key%100057 ] = head.next;
        while(head.next!=null && head.next.key !=key)
            head = head.next;
        if(head.next != null){
            head.next=head.next.next;
        }
    }

    public boolean contains(int key) {
        Node head = map[key%100057 ];
        if(head==null){
            return false;
        }
        while(head!=null)
            if(head.key == key)
                return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */