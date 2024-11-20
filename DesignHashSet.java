class MyHashSet {

  class Node{
    int val;
    Node next;

    public Node(int val){
      this.val = val;
    }
  }

  Node[] buckets;

  public MyHashSet() {
    buckets = new Node[10000];
  }

  //Time Complexity - O(1)
//Space Complexity - O(1)
  public void add(int key) {
    int hash_key = hash(key);

    if(buckets[hash_key] == null){
      buckets[hash_key] = new Node(-1);
    }

    Node node = getNode(buckets[hash_key], key);

    if(node.next == null){
      node.next = new Node(key);
    }

  }

  //Time Complexity - O(1)
//Space Complexity - O(1)
  public void remove(int key) {
    int hash_key = hash(key);

    if(buckets[hash_key] == null){
      return;
    }

    Node node = getNode(buckets[hash_key], key);

    if(node.next == null){
      return;
    }

    node.next = node.next.next;
  }

  //Time Complexity - O(1)
//Space Complexity - O(1)
  public boolean contains(int key) {
    int hash_key = hash(key);

    if(buckets[hash_key] == null){
      return false;
    }

    Node node = getNode(buckets[hash_key], key);

    if(node.next != null && node.next.val == key){
      return true;
    }

    return false;
  }

  private int hash(int val){
    return Integer.hashCode(val) % buckets.length;
  }


  private Node getNode(Node node, int val){
    Node temp = node, prev = null;

    while(temp != null && temp.val != val){
      prev = temp;
      temp = temp.next;
    }

    return prev;
  }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
