package demo;

class MyHashSet {
 private int buckets = 1000;
    private int itemsPerBucket = 1000;
    private boolean[][] table;
    public int key;
    /** Initialize your data structure here. */
    public MyHashSet() {
                table = new boolean[buckets][];

    }

    public void add(int key) {
        int hash = key%buckets;
        int pos = key / buckets;
        
        if (table[hash] == null) {
            table[hash] = new boolean[itemsPerBucket];
        }
        table[hash][pos] = true;
    }
    
    public void remove(int key) {
        int hash = key %buckets;
        int pos = key / buckets;

        if (table[hash] != null)
            table[hash][pos] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         int hash = key % buckets;
        int pos = key / buckets;
            if(table[hash] != null && table[hash][pos]){
                return true;
            }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */