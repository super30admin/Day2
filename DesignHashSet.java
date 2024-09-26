// Space Complexity O(1)
// Time Complexity O(1)
class MyHashSet {
    
    int buckets; 
    int bucketItems;
    
    boolean array[][] ;
    
    public int first_hash(int val){
        return val%buckets;
    }
    public int second_hash(int val){
        return val/buckets;
    }
    
    public MyHashSet() {
        this.buckets=1000;
        this.bucketItems=1000;
      this.array  = new boolean[buckets][];
    }
    
    public void add(int key) {
        int bucket = first_hash(key);
        int bucketItem = second_hash(key);
        
        if(array[bucket]==null){
            if(bucket==0){
            //case to handle last element as 1000000/1000=0, we need extra space at the end
                array[bucket] = new boolean[bucketItems+1];
            }else{
                array[bucket] = new boolean[bucketItems];
            }
            
        }
        //assign true to that index
        array[bucket][bucketItem]= true;
    }
    
    public void remove(int key) {
        int bucket = first_hash(key);
        int bucketItem = second_hash(key);
        if(array[bucket]!=null){
            array[bucket][bucketItem]= false;
        }
    }
    
    public boolean contains(int key) {
        int bucket = first_hash(key);
        int bucketItem = second_hash(key);
        
        return array[bucket]!=null && array[bucket][bucketItem];
    }
}