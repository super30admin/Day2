
/**
 *
 // Time Complexity : Add on an average O(1), O(n) worst case, remove: O(n) worst case, O(1), Contains: O(n) worst case, O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
I refered multiple places as I was coding this question.
// Your code here along with comments explaining your approach
1. Initial assumption values set to literal values.
2. Created a HashTable of buckets(list of list)
3. Each bucket in turn has a list as child bucket.
4. Created a constructor with initial index calculated with modulo operator = key % sizeOfArray.
5. Each bucket as an ArrayList and default values set to null.
6. Created an add function if in the bucket childList is empty, we create a LL and add key else if key is not in list we add it.
7. Created a remove function, where it check if list not empty then remove the valueofKey.
8. Created a contains function by just return a boolean with a mutual exclusive condition checking list not empty and contains key.
 */

import java.util.*;

public class MyHashSet {
  private final int sizeOfArray = 100;
  private List<List<Integer>> mainBucket;

  public MyHashSet() {
    mainBucket = new ArrayList<>(sizeOfArray);
    for (int idx = 0; idx < sizeOfArray; idx++) {
      mainBucket.add(null);
    }
  }

  public void add(int key) {
    int idx = key % sizeOfArray;
    List<Integer> lisInBucket = mainBucket.get(idx);
    if (lisInBucket == null) {
      List<Integer> list = new LinkedList<>();
      list.add(key);
      mainBucket.set(idx, list);
    } else {
      if (!lisInBucket.contains(key)) {
        lisInBucket.add(key);
      }
    }
  }

  public void remove(int key) {
    int idx = key % sizeOfArray;
    List<Integer> lisInBucket = mainBucket.get(idx);
    if (lisInBucket != null) {
      lisInBucket.remove(Integer.valueOf(key));
    }

  }

  public boolean contains(int key) {
    int idx = key % sizeOfArray;
    List<Integer> lisInBucket = mainBucket.get(idx);
    return lisInBucket != null && lisInBucket.contains(key);

  }

  public static void main(String args[]) {
    MyHashSet hs = new MyHashSet();
    hs.add(1);
    hs.add(2);
    System.out.println();
    boolean is1Present = hs.contains(1);
    System.out.println(is1Present);
    boolean is3Present = hs.contains(3);
    System.out.println(is3Present);
    hs.add(4);
    boolean is5Present = hs.contains(5);
    System.out.println(is5Present);
    boolean is4Present = hs.contains(4);
    System.out.println(is4Present);
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */