// Did this code successfully run on Leetcode : yes
/**
 * Implemented HashMap using Double Hashing
 * 
 * NOTE: Used Integer[][] primary;
 * Only storing the values not the keys;
 * as the key will always be mapped to the same index in the secondary array after collision handling
 * so, if the value exists, it means the key is mapped to this value
 * else, the key doesn't exists
 */
/**
 * Time Complexity :
 * 
 * put(): O(1)
 * remove(): O(1)
 * get(): O(1)
 */
/**
 * Space Complexity :
 * 
 * O(n) aux. space
 * 
 * put(): O(1)
 * remove(): O(1)
 * get(): O(1)
 */
public class HashMap_DoubleHashing {

    private static final int SIZE = (int) 1e3;
  
    private Integer[][] primary;
  
    public HashMap_DoubleHashing() {
      this.primary = new Integer[SIZE][];
    }
  
    private int primaryHash(int key) {
      return key % SIZE;
    }
  
    private int secondaryHash(int key) {
      return key / SIZE;
    }
  
    public int get(int key) {
      int primaryIndex = primaryHash(key);
      Integer[] secondary = primary[primaryIndex];
      if (secondary == null) {
        return -1;
      }
      int secondaryIndex = secondaryHash(key);
      Integer value = secondary[secondaryIndex];
      return value == null ? -1 : value;
    }
  
    public void put(int key, int value) {
      int primaryIndex = primaryHash(key);
      Integer[] secondary = primary[primaryIndex];
      if (secondary == null) {
        if (primaryIndex == 0) {
          secondary = new Integer[SIZE + 1];
        } else {
          secondary = new Integer[SIZE];
        }
        primary[primaryIndex] = secondary;
      }
      int secondaryIndex = secondaryHash(key);
      secondary[secondaryIndex] = value;
    }
  
    public void remove(int key) {
      int primaryIndex = primaryHash(key);
      Integer[] secondary = primary[primaryIndex];
      if (secondary == null) {
        return;
      }
      int secondaryIndex = secondaryHash(key);
      Integer node = secondary[secondaryIndex];
      if (node != null) {
        secondary[secondaryIndex] = null;
      }
    }

}