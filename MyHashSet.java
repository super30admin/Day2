// Time Complexity : Each Operation would take around O(n) as it has to check if the element already exists in the list
// Space Complexity : Size of the ArrayList which is O(1000000)
// Did this code successfully run on Leetcode : Getting time limit exceeded error
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashSet {

  ArrayList al;
  /** Initialize your data structure here. */
  public MyHashSet() {
    al = new ArrayList<>(Collections.nCopies(1000000, -1));
  }

  public void add(int key) {
    if(!contains(key))
      al.add(key);
  }

  public void remove(int key) {
    if(contains(key))
      al.remove(new Integer(key));
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    return al.contains(key);
  }

  public static void main(String[] args) {
    MyHashSet obj = new MyHashSet();
    obj.add(key);
    obj.remove(key);
    boolean param_3 = obj.contains(key);
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */