/**
 * Time Complexity: O(n) since we are traversing over linked list for search
 * 
 * Space Complexity: O(1000 + M) where 1000 is the number of buckets and M is
 * the number of unique keys inserted.
 * 
 * Did this code successfully run on Leetcode : Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

public class MyHashMap {

  int buckets;
  Node[] storage;

  public MyHashMap() {
    this.buckets = 1000;
    this.storage = new Node[this.buckets];
  }

  int getBucket(int key) {
    return key % this.buckets;
  }

  Node find(Node dummy, int key) {
    Node prev = dummy;
    Node curr = dummy.next;
    while (curr != null && curr.key != key) {
      prev = curr;
      curr = curr.next;
    }
    return prev;
  }

  void put(int key, int value) {
    int bucket = getBucket(key);
    if (storage[bucket] == null) {
      storage[bucket] = new Node(-1, -1);
    }
    Node prev = find(storage[bucket], key);
    if (prev.next == null) {
      prev.next = new Node(key, value);
    } else {
      prev.next.value = value;
    }
  }

  int get(int key) {
    int bucket = getBucket(key);
    if (storage[bucket] == null) {
      return -1;
    }
    Node prev = find(storage[bucket], key);
    if (prev.next == null) {
      return -1;
    }
    return prev.next.value;
  }

  void remove(int key) {
    int bucket = getBucket(key);
    if (storage[bucket] == null) {
      return;
    }
    Node prev = find(storage[bucket], key);
    if (prev.next == null) {
      return;
    }
    prev.next = prev.next.next;
  }

  class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
