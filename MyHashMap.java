import java.util.Arrays;

class MyHashMap {

      /*
     * Time Complexity:: put() - O(1), get() - O(1), remove() - O(1)
     * Space Complexity:: O(n)
     * 
     * Ran successfully on leetcode.
     */
    private int buckets = 1000;
    private int bucketItems = 1000;
    private int[][] arr;
    public MyHashMap() {
        arr = new int[buckets][];
    }
    
    public void put(int key, int value) {
        int hash1 = key%buckets;
        int hash2 = key/bucketItems;
        if (arr[hash1] == null) {
            arr[hash1] = new int[bucketItems+1];
            Arrays.fill(arr[hash1], -1);
        }
        arr[hash1][hash2] = value;
            
    }
    
    public int get(int key) {
        int hash1 = key%buckets;
        int hash2 = key/bucketItems;
        if (arr[hash1] == null)
            return -1;
        return arr[hash1][hash2];
    }
    
    public void remove(int key) {
        int hash1 = key%buckets;
        int hash2 = key/bucketItems;
        if (arr[hash1] == null)
            return;
        arr[hash1][hash2] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */