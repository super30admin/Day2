class MyHashSet {
    boolean[][] buckets;
    int bucketSize=1000;
    int bucketItemsSize=1000;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=new boolean[bucketSize][];
    }
    private int hash1(int key){
        return key%bucketSize;
    }
    private int hash2(int key){
        return key/bucketSize;
    }
    public void add(int key) {
        int index1=hash1(key);
        int index2=hash2(key);
         if(buckets[index1] == null){
             if(index1==0){
                buckets[index1]=new boolean[bucketItemsSize+1];
            }
            else{
                buckets[index1]=new boolean[bucketItemsSize];

            }
         }
             buckets[index1][index2]=true;

    }
    
    public void remove(int key) {
        int index1=hash1(key);
        int index2=hash2(key);
        if(buckets[index1]!=null)
        {
             buckets[index1][index2]=false;
        }

    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1=hash1(key);
        int index2=hash2(key);
        if(buckets[index1]==null) return false;
        return  buckets[index1][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
