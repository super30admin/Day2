// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

using System;

public class MyHashMap
{
    int buckets;
    Node[] storage;

    public class Node
    {
        public int value;
        public int key;
        public Node next;

        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap()
    {
        buckets = 10000;
        storage = new Node[buckets];
    }

    private int getHash(int key)
    {
        return key % buckets;
    }

    private Node getPrev(Node head, int key)
    {
        Node prev = null;
        Node curr = head;

        while (curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;


    }

    public void Put(int key, int value)
    {
        int hash = getHash(key);
        if (storage[hash] == null)
        {
            storage[hash] = new Node(-1, -1);
        }
        Node prev = getPrev(storage[hash], key);
        if (prev.next == null)
        { // handling new node
            prev.next = new Node(key, value);
        }
        else
        {
            prev.next.value = value; // update the existing value
        }
    }

    public int Get(int key)
    {
        int hash = getHash(key);
        if (storage[hash] == null)
        {
            return -1;
        }
        Node prev = getPrev(storage[hash], key);
        if (prev.next == null)
        {
            return -1;
        }
        else
        {
            return prev.next.value;
        }

    }

    public void Remove(int key)
    {
        int hash = getHash(key);
        if (storage[hash] == null)
        {
            return;
        }
        Node prev = getPrev(storage[hash], key);
        if (prev.next == null)
        {
            return;
        }
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }
}

class Program
{
    static void Main(string[] args)
    {
        // Create a MyHashMap object
        MyHashMap hashMap = new MyHashMap();

        // Perform the input sequence
        Console.WriteLine("Output:");

        // ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
        // [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]

        // Output for "MyHashMap"
        Console.WriteLine("null");

        // Output for "put(1, 1)"
        hashMap.Put(1, 1);
        Console.WriteLine("null");

        // Output for "put(2, 2)"
        hashMap.Put(2, 2);
        Console.WriteLine("null");

        // Output for "get(1)"
        Console.WriteLine(hashMap.Get(1)); // Should print 1

        // Output for "get(3)"
        Console.WriteLine(hashMap.Get(3)); // Should print -1

        // Output for "put(2, 1)"
        hashMap.Put(2, 1);
        Console.WriteLine("null");

        // Output for "get(2)"
        Console.WriteLine(hashMap.Get(2)); // Should print 1

        // Output for "remove(2)"
        hashMap.Remove(2);
        Console.WriteLine("null");

        // Output for "get(2)"
        Console.WriteLine(hashMap.Get(2)); // Should print -1
    }
}

