// Time Complexity : O(1)
// Space Complexity : O(n) - Node array size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
* Used an array of linkedlists of size 10^4 (because atmost only 10^4 calls are made). we compute
* the hash of the key and create a linkedlist to that index and then insert a new node in that list
* with the given values.
*/

class MyHashMap {

  class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }

  Node[] arr;
  private static final int bs = 10_000;

  public MyHashMap() {
    arr = new Node[bs];
  }

  private int getHash(int key) {
    return key/bs;
  }

  private Node findPrev(int key) {
    Node prev, curr;
    int hval = getHash(key);

    if(arr[hval] != null) {
      prev = arr[hval];
      curr = prev.next;

      while(curr != null && curr.key != key) {
        prev = curr;
        curr = curr.next;
      }
      return prev;
    }
    return null;
  }

  public void put(int key, int value) {
    // 2 cases: 1) key is present -- then just update the value 2) key is not present create a new node and attach.

    // Key is not present.
    Node prev;
    int hval = getHash(key);
    prev = findPrev(key);
    if(arr[hval] == null) {
      // This is just a dummy Node.
      Node head = new Node(-1, -1);
      arr[hval] = head;
      prev = arr[hval];
    }
    if(prev.next == null) {
      Node root = new Node(key, value);
      prev.next = root;
    }
    // key is present scenario.
    else {
      prev.next.value = value;
    }
  }

  public int get(int key) {
    Node prev = findPrev(key);
    if(prev == null || prev.next == null) {
      return -1;
    }
    return prev.next.value;
  }

  public void remove(int key) {
    Node prev = findPrev(key);
    if(prev == null || prev.next == null) {
      return;
    }
    prev.next = prev.next.next;
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
