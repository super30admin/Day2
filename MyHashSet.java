class MyHashSet {
    
     class Node {
        int key;
        Node next;
        public Node(int key) {
            this.key = key;
        }
    }

    Node[] nodes = new Node[1000];

    public MyHashSet() {
        
    }
    
    private int index(int key) {
        return (Integer.hashCode(key) % nodes.length);
    }
    
    public void add(int key) {
        int i = index(key);
        if(nodes[i] == null)
            nodes[i] =  new Node(-1);
        Node prev = find(nodes[i], key);
        if(prev.next == null)
            prev.next = new Node(key);
    }
    
    public void remove(int key) {
        int i = index(key);
        if(nodes[i] == null)
            return;
        Node prev = find(nodes[i], key);
        if(prev.next == null)
            return;
        prev.next = prev.next.next;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = index(key);
        if(nodes[i] == null)
            return false;
        Node prev = find(nodes[i], key);
        if(prev.next == null)
            return false;
        return true;
    }
    
    private Node find(Node node, int key) {
        Node prev = null;
        while(node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */