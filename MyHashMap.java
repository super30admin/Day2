// Time Complexity :put: O(1)
//                  get: O(1)
//                  remove: O(1)
// Space Complexity :put: O(1)
//                   get: O(1)
//                   remove: O(1)
//                   constructor: O(n) (because we are creating storage array)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing



class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }

    Node[] storage;
    int buckets;

    public MyHashMap() {
        this.buckets=10000;
        this.storage = new Node[buckets];
    }

    private int getPrimaryHash(int key){
        return key % buckets;
    }

    private Node getPrevNode(Node head, int key){
        Node prev = null;
        Node curr = head;

        while(curr != null && curr.key != key){
            prev = curr;
            curr = prev.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int pIndex = getPrimaryHash(key);
        if(storage[pIndex] == null){
            storage[pIndex] = new Node(-1,-1);
        }
        Node prev= getPrevNode(storage[pIndex], key);
        if(prev.next == null){
            prev.next = new Node(key , value);
        } else {
            prev.next.value = value;
        }

    }

    public int get(int key) {
        int pIndex = getPrimaryHash(key);
        if(storage[pIndex] == null){
            return -1;
        }
        Node prev = getPrevNode(storage[pIndex], key);
        if(prev.next == null){
            return -1;
        } else {
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int pIndex = getPrimaryHash(key);
        if(storage[pIndex]== null){
            return;
        }
        Node prev = getPrevNode(storage[pIndex], key);
        if(prev.next == null){
            return;
        } else {
            Node temp = prev.next;
            prev.next = temp.next;
            temp = null;
        }
    }


    public static void main(String args[])
    {
        MyHashMap obj = new MyHashMap();
        obj.put(2,10);
        obj.put(4,10);
        obj.put(2,12);
        obj.put(5,30);
        obj.put(6,3000);
        obj.put(7,4000);
        obj.remove(4);
        System.out.println("Value corresponding to key 6 is "+obj.get(6));

    }
}

