/*
Time complexity : add : O(1)
                  remove O(1)
                  contains O(1)
Space Complexity : O(N) N = input size

Is worked on leetcode : YES
*/

class HashSet {
    boolean [][] _set;
    int buckets;
    int bucket_items;
    
    public MyHashSet() {
        buckets=1001;
        bucket_items=1000;
        _set =  new boolean[buckets][];
    }
    private int  hash_1(int key){
        System.out.println();
        return key % buckets;
    }

    private int  hash_2(int key){
        return key / bucket_items;
    }
    
    public void add(int key) {
        int bucket_no = hash_1(key);
        if(_set[bucket_no] == null){
            _set[bucket_no]= new boolean [bucket_items];
        }
        int bucket_item_no = hash_2(key);
        _set[bucket_no][bucket_item_no] = true;    
    }
    
    public void remove(int key) {
        int bucket_no = hash_1(key);
        int bucket_item_no = hash_2(key);
        if(_set[bucket_no] != null){
            _set[bucket_no][bucket_item_no] = false;
        }

    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket_no = hash_1(key);
        if(_set[bucket_no] != null){
            return _set[bucket_no][bucket_item_no];
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