// Time Complexity : O(100) | O(Length of the linked list)
// Space Complexity : O(N*Length of the linked lists)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    static class Node {
        int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    Node[] pool;
    static final int bucketSize = 10000;
    public MyHashSet() {
        pool = new Node[bucketSize];
    }

    public Node[] findNode(Node head, int valueToFind) {
        Node[] resultant = new Node[2];
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.value != valueToFind) {
            prev = curr;
            curr = curr.next;
        }
        resultant[0] = prev;
        resultant[1] = curr;
        return resultant;
    }

    public void add(int key) {
        int bucketIndex = primaryHashKey(key);
        Node bucketItem = pool[bucketIndex];
        if(bucketItem == null) {
            pool[bucketIndex] = new Node(-1);
        }
        Node[] nodes = findNode(pool[bucketIndex], key);
        if(nodes[1] == null) {
            System.out.println("Inserted ->"+key);
            nodes[0].next = new Node(key);
        }
    }

    public void remove(int key) {
        int bucketIndex = primaryHashKey(key);
        Node bucketItem = pool[bucketIndex];
        if(bucketItem == null) return;
        Node[] nodes = findNode(bucketItem, key);
        if(nodes[1] != null) {
            System.out.println("Removed ->"+key);
            nodes[0].next = nodes[1].next;
        }
    }

    public boolean contains(int key) {
        int bucketIndex = primaryHashKey(key);
        Node bucketItem = pool[bucketIndex];
        if(bucketItem == null) return false;
        Node[] nodes = findNode(bucketItem, key);
        if(nodes[1] == null) return false;
        return true;
    }

    public int primaryHashKey(int key) {
        return key%bucketSize;
    }

    public static void main(String[] args) {
        MyHashSet hs = new MyHashSet();
        hs.add(10);
        hs.add(11);
        hs.add(10);
        System.out.println(hs.contains(11));
        hs.remove(10);
        System.out.println(hs.contains(10));
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */