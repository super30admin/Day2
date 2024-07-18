//Time Complexity: O(1)
//Space Complexity: O(n)

import java.util.Arrays;
class MyHashMap {
    private int buckets = 1000;
    private int buckItems = 1000;
    private int[][] arr;

    public MyHashMap() {
        arr = new int[buckets][];
    }
    
    public void put(int key, int value) {
        int h1 = key%buckets;
        int h2 = key/buckItems;
        if(arr[h1] == null){
            arr[h1] = new int[buckItems+1];
            Arrays.fill(arr[h1], -1);
        }
        arr[h1][h2] = value;
    }
    
    public int get(int key) {
        int h1 = key%buckets;
        int h2 = key/buckItems;
        if(arr[h1] == null){
            return -1;
        }
        return arr[h1][h2];
    }
    
    public void remove(int key) {
        int h1 = key%buckets;
        int h2 = key/buckItems;
        if(arr[h1] == null){
            return;
        }
        arr[h1][h2] = -1;
    }
}