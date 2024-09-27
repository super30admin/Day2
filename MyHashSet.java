class MyHashSet {

    static class Node 
    {
        int key;
        Node next;
        public Node (int key)
        {
            this.key = key;
            next = null;
        }
    }
    
    Node [] nodeArr = new Node[1000];
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    
     public void add(int key) {
        int index = key%1000;
        Node insert = new Node(key);
        if (nodeArr[index] == null)
        {
            nodeArr[index] = insert;
            return;
        }
       if (nodeArr[index].key == key)
        {
            return;
        }
        Node curr = nodeArr[index];
        while(curr.next != null)
        {
            if (curr.next.key == key)
            {
                return;
            }
            curr = curr.next;
        }
        curr.next = insert;
    }
    
    public void remove(int key) {
        int index = key%1000;
        if (nodeArr[index] == null)
        {
            return;
        }

        if (nodeArr[index].key == key)
        {
            nodeArr[index] = nodeArr[index].next;
            return;
        }
        Node curr = nodeArr[index].next;
        Node prev = nodeArr[index];
        while(curr != null)
        {            
            if (curr.key == key)
            {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key%1000;
        if (nodeArr[index] == null)
        {
            return false;
        }
        Node curr = nodeArr[index];
        while(curr != null)
        {
            if (curr.key == key)
            {
                return true;
            }
            curr = curr.next;
        }
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
