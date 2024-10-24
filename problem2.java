//Design Hashmap (https://leetcode.com/problems/design-hashmap/)

public class problem2 {

    class MyHashMap {

        class Node
        {
            int key;
            int value;
            Node next;
            public Node(int key, int value) {this.key = key; this.value = value; }
        }

        Node[] storage;
        int buckets;

        public MyHashMap() {
            this.buckets = 10000;
            this.storage = new Node[buckets];
        }
        private int getPrimaryHash(int key)
        {
          return (key % buckets);
        }
        private Node getPrev(Node head, int key)
        {
            Node prev=null;
            Node curr=head;
            while(curr!=null && curr.key!=key)
            {
                prev=curr;
                curr=curr.next;
            }
            return prev;
        }
        public void put(int key, int value)
        {
            int primaryIdx= getPrimaryHash(key);
            if(storage[primaryIdx]==null)
            {
                storage[primaryIdx] = new Node(-1,-1);
            }
            Node prev= getPrev(storage[primaryIdx], key);
            if (prev.next==null)
            {
                prev.next= new Node(key,value);
            }
            else {
                prev.next.value= value;
            }
        }
        public int get(int key)
        {
            int primaryIdx= getPrimaryHash(key);
            if (storage[primaryIdx]==null)
            {
                return -1;
            }
            Node prev= getPrev(storage[primaryIdx], key);
            if (prev.next==null)
            {
                return -1;
            }
            else {
                return prev.next.value;
            }
        }
        public void remove(int key)
        {
            int primaryIdx= getPrimaryHash(key);
            if (storage[primaryIdx]==null)
            {
                return ;
            }
            Node prev= getPrev(storage[primaryIdx], key);
            if (prev.next==null)
            {
                return;
            }
            Node curr= prev.next;
            prev.next = curr.next;
            curr.next = null;
        }
    }
}
