class MyHashMap {
class Node{
    int key;
    int value;
    Node next;
    public Node(int key, int value)
    {
        this.key=key;
        this.value=value;
    }
}
private Node [] array;
private int size;

    public MyHashMap() {
        this.size=10000;
        this.array = new Node[size];
    }
    private int hashIndex(int key)
    {
        return key%size;
    }
    private Node search(Node node,int key)
    {
            Node prev = node;
            Node current = prev.next;
            while(current != null && current.key!=key)
            {
                prev=current;
                current= current.next;
            }
            return prev;
    }
    public void put(int key, int value) {
        int index=hashIndex(key);
        if(array[index]==null)
        {
            array[index] = new Node(-1,-1);
        }
        Node prev = search(array[index],key);
        if(prev.next!=null)
        {
            prev.next.value=value;
        }
        else
        {
            prev.next = new Node(key,value);
        }
    }
    
    public int get(int key) {
         int index=hashIndex(key);
        if(array[index]==null)
        return -1;
         Node prev = search(array[index],key);
         if(prev.next == null)
         return -1;
         else
         return prev.next.value;
    }
    
    public void remove(int key) {
        int index=hashIndex(key);
        if(array[index]==null)
        return;
        Node prev = search(array[index],key);
        if(prev.next == null)
         return ;
        
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */