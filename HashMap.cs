using System;
namespace Algorithms
{
    /// Time Complexity : O(n)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class MyHashMap
    {
        class Node
        {
            public int key; public int val;
            public Node next;
            public Node(int key, int val)
            {
                this.key = key;
                this.val = val;
            }
        }

        private Node[] storage;
        int buckets;

        public MyHashMap()
        {
            this.buckets = 10000;
            this.storage = new Node[buckets];
        }

        private int bucket(int key)
        {
            return key % buckets;
        }

        private Node find(Node head, int key)
        {
            Node prev = null;
            Node current = head;
            while (current != null && current.key != key)
            {
                prev = current;
                current = current.next;
            }
            return prev;
        }

        public void Put(int key, int value)
        {
            int bucket = this.bucket(key);
            if (storage[bucket] == null)
            {
                storage[bucket] = new Node(-1, -1);
            }
            Node prev = find(storage[bucket], key);
            if (prev.next == null)
            {
                prev.next = new Node(key, value);
            }
            else
            {
                prev.next.val = value;
            }
        }
        public int Get(int key)
        {
            int bucket = this.bucket(key);
            if (storage[bucket] == null) return -1;
            Node prev = find(storage[bucket], key);
            if (prev.next == null) return -1;
            return prev.next.val;
        }

        public void Remove(int key)
        {
            int bucket = this.bucket(key);
            if (storage[bucket] == null) return;
            Node prev = find(storage[bucket], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;

        }
    }
}
