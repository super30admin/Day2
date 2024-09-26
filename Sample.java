class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketitems;

    public MyHashSet() {
        buckets=1000;
        bucketitems=1000;
        storage = new boolean[buckets][]; // array will be initialized
    }
    
    private int getbucket(int key){
        return key % buckets;
    }
    
    private int getbucketitem(int key){
        return key / bucketitems;
    }
    
    public void add(int key) {
        int bucket = getbucket(key);
        int bucketitem = getbucketitem(key);
         if(storage[bucket] == null) {
             if(bucket == 0){
                 storage[bucket] = new boolean[bucketitems+1];
             }
             else{
                 storage[bucket] = new boolean[bucketitems];
             }
         }
        storage[bucket][bucketitem]= true; 
        
    }
    
    public void remove(int key) {
       int bucket = getbucket(key);
        int bucketitem = getbucketitem(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketitem]= false; 
    }
    
    public boolean contains(int key) {
        int bucket = getbucket(key);
       int bucketitem = getbucketitem(key);
         if(storage[bucket] == null){
            return false;
    }
        return storage[bucket][bucketitem];
}
}