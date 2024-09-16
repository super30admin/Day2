//Time complexity:O(1)
//Space complexity:O(N)
class MyHashMap {
    //Creating a class node
class Node{
    int key;
    int value;
    Node next;
    public Node(int key, int value){
        this.key=key;
        this.value=value;
    }
}Node[] nodes;
    public MyHashMap() {
        //Creating a primary array containing nodes
        nodes=new Node[10000];
    }
    public int idx(int key){
        return key% 10000;
    }
    private Node find(Node head, int key){
        //Iterating over the linkedlist to find the pointer to the previous element
        Node prev=null;
        Node current=head;
        while (current!=null && current.key!=key){
        prev=current;
        current=current.next;
        }return prev;
    }
    public void put(int key, int value) {

        int idx=idx(key);
        if(nodes[idx]==null){
            //Creating a dummy node if thee are no nodes at that index
            nodes[idx]=new Node(-1,-1);
}Node prev=find(nodes[idx],key);
        //if at the last node we are creating a new node to insert the new key 
        if(prev.next==null){
            prev.next=new Node(key,value);
}else{
            prev.next.value=value;
        }
    }
    
    public int get(int key) {
        int idx=idx(key);
        if(nodes[idx]==null) return -1;
        Node prev=find(nodes[idx],key);
        if(prev.next==null) return -1;
        //Getting the value at that particular key
        return prev.next.value;
    }
    
    public void remove(int key) {
        int idx=idx(key);
        if(nodes[idx]==null) return;
        Node prev=find(nodes[idx],key);
        if(prev.next==null) return;
        //Removing the key by changingthe pointer to the next node
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