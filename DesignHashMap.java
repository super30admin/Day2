// Time Complexity : put(), get(), remove() - O(N)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {

  // Defines what a Node is and its properties.
  class Node {
    int key;
    int value;
    Node next;
    Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }

  // To check if a particular key already exists.
  Node find(Node dummy, int key) {
    Node prev = dummy;
    Node current = dummy.next;
    while(current!=null && current.key!=key) {
      prev = current;
      current = current.next;
    }
    return prev;
  }

  int buckets;
  Node[] storage;

  // Constructor
  public MyHashMap() {
    buckets = 1000;
    storage = new Node[buckets];
  }

  // Hashfunction to bind the keys within a value.
  int getBucket(int key) {
    return key % buckets;
  }

  // Put/update a key-value pair
  public void put(int key, int value) {
    int bucket = getBucket(key);
    if(storage[bucket]==null) {
      storage[bucket] = new Node(-1,-1);
    }
    Node prev = find(storage[bucket], key);
    if(prev.next!=null) {
      prev.next.value = value;
    }else {
      prev.next = new Node(key, value);
    }
  }

  // To find if a node exists and return that value, orelse -1.
  public int get(int key) {
    int bucket = getBucket(key);
    if(storage[bucket]==null) return -1;
    Node prev = find(storage[bucket], key);
    if(prev.next!=null) {
      return prev.next.value;
    }
    return -1;
  }

  // To remove a node if that key exists.
  public void remove(int key) {
    int bucket = getBucket(key);
    if(storage[bucket]==null) return;
    Node prev = find(storage[bucket], key);
    if(prev.next!=null) {
      prev.next = prev.next.next;
    }
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */