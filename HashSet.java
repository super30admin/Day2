// Time Complexity :add,remove,contains->O(1);
// Space Complexity :O(n); where n is no of elements
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :tried to make array as int array then realised we can use boolean

class MyHashSet {
    public int keyList = 1000;// taking keyList Size
    public int keyItem = 1001;// taking nested array size as 1001 as item 1000000 will be on //index
                              // arr[0][1000]
    boolean[][] hashSet = new boolean[keyList][];// initializing list

    public MyHashSet() {

    }

    public void add(int key) {
        int x = key % keyList;// calculating index using hash function
        int y = key / keyList;
        if (hashSet[x] == null) {
            hashSet[x] = new boolean[keyItem];// initializing nested array
        }
        hashSet[x][y] = true;// setting value to true

    }

    public void remove(int key) {
        int x = key % keyList;
        int y = key / keyList;
        if (hashSet[x] != null) {
            hashSet[x][y] = false;// removing element by setting it to false at calculated //index
        }

    }

    public boolean contains(int key) {
        int x = key % keyList;
        int y = key / keyList;
        if (hashSet[x] != null) {
            return hashSet[x][y];// if nested array is not null return its status
        }
        return false;// else it will automatically be false

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */