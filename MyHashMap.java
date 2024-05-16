class MyHashMap {

    class Node
    {
        int val;
        int key;
        Node next;
        public Node(int key, int val)
        {
            this.val=val;
            this.key=key;
            this.next=null;
        }
    }

    int buckets;
    Node[] storage;

    private Node find(Node dummy, int key)
    {
        Node prev=dummy;
        Node curr= prev.next;
        while(curr!=null && curr.key!=key)
        {
            prev= curr;
            curr=curr.next;
        }
        return prev;
    }

    int getbucket(int key)
    {
        return key%1000;
    }

    public MyHashMap() {
        buckets=1000;
        storage= new Node[buckets];
    }

    public void put(int key, int value)
    {
        int buck= getbucket(key);
        if(storage[buck]==null)
        {
            storage[buck]=new Node(-1,-1);

        }
        Node prev= find(storage[buck], key);
        if(prev.next!=null)
        {
            prev.next.val=value;
        }
        else
        {
            prev.next= new Node(key,value);
        }

    }

    public int get(int key) {
        int buck= getbucket(key);
        if(storage[buck]==null)
        {
            return -1;
        }
        Node prev= find(storage[buck], key);
        if(prev.next!=null)
        {
            return prev.next.val;
        }
        return -1;
    }

    public void remove(int key)
    {
        int buck= getbucket(key);
        if(storage[buck]==null)
        {
            return;
        }
        Node prev= find(storage[buck], key);
        if(prev.next!=null)
        {
            prev.next=prev.next.next;
        }

    }
    public static void main(String args[])
    {
        MyHashMap hashmap = new MyHashMap();
        hashmap.put(1,1);
        hashmap.put(2,2);
        int para= hashmap.get(1);
        System.out.println(para);
        hashmap.remove(1);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */