// Time Complexity : put --> average O(1) worst case O(N) where N is 10 same for get(), remove() and search
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes it did
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


package hashmap;

public class UsingLinearChaining {

    public static void main(String[] args) {

        UsingLinearChaining hashMap = new UsingLinearChaining();
        System.out.println(hashMap.get(101));
        hashMap.put(101, 121);
        hashMap.put(100101, 122);
        hashMap.put(200101, 122);

        System.out.println(hashMap.get(101));
        System.out.println(hashMap.get(100101));
//        System.out.println(hashMap.get(200101));
        hashMap.remove(101);
        hashMap.test();

    }

    /**
     * Testing remove scenario
     */
    void test ()
    {
        System.out.println(storage[101]);
    }

    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private Node[] storage;

    public UsingLinearChaining() {
        this.storage = new Node[100000];
    }

    private int hashIdx(int key) {
        return key % 100000;
    }

    private Node search(Node head, int key) {

        Node prev = head;
        Node curr = prev.next;

//        System.out.println(prev);
//        System.out.println(curr);  -- null at the start

        while (curr != null && curr.key != key) {
//            System.out.println("inside -----");
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public void put(int key, int value) {

        int idx = hashIdx(key);
//        System.out.println(idx);
        // 101

//        mull at the start
//        System.out.println(storage[idx]);

        if (storage[idx] == null) {
//            initialise with dummy node
//            this is added as in the case if we want to remove the 1st node then for the prev node to have reference
            storage[idx] = new Node(-1, -1);
        }

//        System.out.println(storage[idx]);

//        get the prev node
//        storage[idx] -- this is the head now
        Node prev = search(storage[idx], key);
//        here we get the same node back which is the dummy node for 1st insert at the key

//        this happens for insrerting at the node

//        node is present
        if (prev.next != null) {
            System.out.println("2nd time comes here");

            prev.next.val = value;

            return;
        }

        System.out.println("1st time comes here");
//        create new node
        prev.next = new Node(key, value);
    }

    public int get(int key) {

        int idx = hashIdx(key);

        if (storage[idx] == null) {
            return -1;
        }

        Node prev = search(storage[idx], key);

        if (prev.next == null) {
            System.out.println("key not found");

            return -1;
        }

        return prev.next.val;
    }

    public void remove(int key) {

        int idx = hashIdx(key);

        if (storage[idx] == null) {
            return;
        }

        Node prev = search(storage[idx], key);

//        here there are 2 cases prev is dummy node or prev next has values

        if (prev.next == null) {
            System.out.println("key not found");
            return;
        }

//        this is the case if the key is found
        Node tmp = prev.next;
        prev.next = prev.next.next;
//        remove dangling pointer
        tmp.next = null;
    }
}
