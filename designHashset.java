//time complexity : O(1)
//space complexity : O(n)
class MyHashSet {
    private boolean[][] storage ;
     int buckets;
     int bucketLists;
        public MyHashSet() {
        buckets=1000;
        bucketLists=1000;
        this.storage=new boolean[buckets][];
        }
        
        public int bucket(int key){
            return key%buckets;
        }
        public int bucketList(int key){
            return key/bucketLists;
        }
        
        public void add(int key) {
            int bucket=bucket(key);
            int bucketList=bucketList(key);
            if (storage[bucket]==null){
                storage[bucket]=(bucket==0)?new boolean[bucketLists+1]:new boolean[bucketLists];
            }
            storage[bucket][bucketList]=true;
        
        }
        
        public void remove(int key) {
            int bucket=bucket(key);
            int bucketList=bucketList(key);
            if (storage[bucket]==null) return;
            storage[bucket][bucketList]=false;
            
        }
        
        public boolean contains(int key) {
            int bucket=bucket(key);
            int bucketList=bucketList(key);
            return (storage[bucket]==null)?false:storage[bucket][bucketList];
        }
    }
    
    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */