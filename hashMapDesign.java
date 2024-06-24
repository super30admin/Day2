/*
O(1)ForPut,Get,AndRemove
O(n) for space
 */
import java.util.*;

class MyHashMap {

    //Chaining method
    class Node {

        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    Node[] storage;

    public MyHashMap() {

        storage = new Node[1000];

    }

    public void put(int key, int value) {
        int k = key % 1000;
        if (storage[k] == null) {
            Node head = new Node(-1, -1);
            storage[k] = head;
        }//if
        Node curr = storage[k];
        Node prev = curr;
        boolean isPresent = false;
        while (curr != null) {

            if (curr.key == key) {
                isPresent = true;
                curr.val = value;
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        if (!isPresent) {
            Node newNode = new Node(key, value);
            prev.next = newNode;

        }

    }

    public int get(int key) {

        int k = key % 1000;
        if (storage[k] == null) {
            return -1;
        }
        Node curr = storage[k];
        while (curr != null) {
            if (curr.key == key) {
                return curr.val;
            }
            curr = curr.next;
        }//while
        return -1;

    }

    public void remove(int key) {

        int k = key % 1000;
        if (storage[k] == null) {
            return;
        }
        Node prev = storage[k];
        while (prev.next != null) {
            if (prev.next.key == key) {
                prev.next = prev.next.next;
                return;
            }
            prev = prev.next;

        }//while
        return;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
