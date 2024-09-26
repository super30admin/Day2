// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
//Runtime: 10 ms, faster than 91.45% of Java online submissions for Design HashSet.
/Memory Usage: 46.8 MB, less than 54.39% of Java online submissions for Design HashSet.

// Any problem you faced while coding this : No


class MyHashSet {

  /** Initialize your data structure here. */
  int buckets;
  int bucketItems;

  private boolean[][] set;
  public MyHashSet() {
    buckets = 1000;
    bucketItems = 1000;
    set = new boolean[buckets][];
  }

  public void add(int key) {
    int bucketIndex = hash1(key);
    if (set[bucketIndex] == null) {
      if (bucketIndex != 0) {
        set[bucketIndex] = new boolean[bucketItems];
      } else {
        set[bucketIndex] = new boolean[bucketItems + 1];

      }
    }
    int bucketItemIndex = hash2(key);
    set[bucketIndex][bucketItemIndex] = true;

  }

  public void remove(int key) {
    int bucketIndex = hash1(key);
    if (set[bucketIndex] == null) {
      return;
    }
    int bucketItemIndex = hash2(key);
    set[bucketIndex][bucketItemIndex] = false;
  }

  private int hash1(int key) {
    return key % 1000;
  }

  private int hash2(int key) {
    return key / 1000;
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int bucketIndex = hash1(key);
    if (set[bucketIndex] == null) {
      return false;
    }
    int bucketItemIndex = hash2(key);
    return set[bucketIndex][bucketItemIndex];
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
