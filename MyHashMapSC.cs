public class MyHashMap
{
    public class Node
    {
        public int key;
        public int value;
        public Node next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    int bucket;
    Node[] hashMap;

    public MyHashMap()
    {
        this.bucket = 1000;
        this.hashMap = new Node[this.bucket];
    }

    public Node Find(Node dummy, int key)
    {
        var current = dummy;
        Node prev = dummy;
        while (current != null && current.key != key)
        {
            prev = current;
            current = current.next;
        }
        return prev;
    }
    public int GetBucket(int key)
    {
        return key % this.bucket;
    }
    public void Put(int key, int value)
    {
        var bucket = GetBucket(key);
        if (hashMap[bucket] == null)
        {
            hashMap[bucket] = new Node(-1, -1);
        }
        var node = Find(hashMap[bucket], key);
        if (node.next == null)
        {
            node.next = new Node(key, value);
            return;
        }
        node.next.value = value;
    }

    public int Get(int key)
    {
        var bucket = GetBucket(key);
        if (hashMap[bucket] == null)
        {
            hashMap[bucket] = new Node(-1, -1);
        }
        var node = Find(hashMap[bucket], key);
        return node.next == null ? -1 : node.next.value;
    }

    public void Remove(int key)
    {
        var bucket = GetBucket(key);
        if (hashMap[bucket] == null)
        {
            hashMap[bucket] = new Node(-1, -1);
        }
        var node = Find(hashMap[bucket], key);
        if (node.next != null)
        {
            node.next = node.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key,value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */