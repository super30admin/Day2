class MyHashSet {

     class Node{
      int key;
        Node next;
    public Node(int key){
        this.key= key;
       
        }  
    }
    Node[] nodes;
    int buckets= 10000;
  
    public MyHashSet() {
          nodes = new Node [buckets];
    }
     private int index(int key){
        return Integer.hashCode(key) % buckets;
    }
    
    private Node find(int key, Node node){
        Node prev= null;
        Node curr = node;
        while(curr != null && curr.key != key){
            prev= curr;
            curr= curr.next;
        }
        return prev;
    }
    
    
    public void add(int key) {
         int index = index(key);
        if(nodes[index] ==null){
            nodes[index] = new Node(-1);
        }
        Node prev = find(key, nodes[index]);
        if (prev.next== null){
            prev.next = new Node (key);
        }
        
    }
    
    public void remove(int key) {
        int index= index(key);
        if(nodes[index]==null){
            return ;
        }
        Node prev = find(key, nodes[index]);
        if (prev.next == null) return ;
        prev.next= prev.next.next;
    }
    
    public boolean contains(int key) {
       int index= index(key);
        if(nodes[index]==null){
            return false;
        }
        Node prev = find(key, nodes[index]);
        if (prev.next == null) return false;
        return true; 
    }
}
