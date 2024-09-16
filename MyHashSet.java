class MyHashSet {

  boolean[] map;
  /** Initialize your data structure here. */
  public MyHashSet() {
      map = new boolean[1000001];
      Arrays.fill(map, false);
  }
  
  public void add(int key) {
      map[key] = true;
  }
  
  public void remove(int key) {
      map[key] = false;
  }
  
  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
      return map[key];
  }
}
