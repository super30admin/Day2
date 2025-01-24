# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)


## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)
class MyHashMap {

    private class ListNode {
        int key, value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private ListNode[] buckets;

    public MyHashMap() {
        buckets = new ListNode[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new ListNode(key, value);
        } else {
            ListNode current = buckets[index];
            while (true) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                if (current.next == null) break;
                current = current.next;
            }
            current.next = new ListNode(key, value);
        }
    }

    public int get(int key) {
        int index = hash(key);
        ListNode current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        ListNode current = buckets[index];
        ListNode prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    buckets[index] = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}




