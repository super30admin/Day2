class MyHashSet {

    class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    Node[] arr;
    int buckets;
    public MyHashSet() {
        buckets = 10000;
        arr = new Node[buckets];
    }

    public Node find(Node head,int key)
    {
        Node prev = head;
        Node current = head.next;

        while(current!=null && current.val!=key)
        {
            prev = current;
            current = current.next;
        }
        return prev;
    }

    public void add(int key) {
        int hash = hash1(key);

        if(arr[hash]==null)
        {
            arr[hash] = new Node(-1);
        }
        Node lastNode = find(arr[hash], key);

        if(lastNode.next == null)
            lastNode.next = new Node(key);
        else
            lastNode.next.val = key;

    }

    public void remove(int key) {
        int hash = hash1(key);

        if(arr[hash]==null)
        {
            return;
        }
        Node n = find(arr[hash],key);

        if(n.next == null)
            return;
        else
            n.next = n.next.next;
    }

    public boolean contains(int key) {
        int hash = hash1(key);

        if(arr[hash]==null)
        {
            return false;
        }
        Node n = find(arr[hash],key);

        if(n.next == null)
            return false;
        else
            return true;
    }

    private int hash1(int key) {
        return key % buckets;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */