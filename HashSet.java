// Time complexity add,remove = O(1)
// Space complexity = O(n)
class MyHashSet {
    int buckets;
    int bucketItems;
    boolean storage[][];
    
    public int hashFunc(int key){
        return key%1000;
    }
     public int hashFunc2(int key){
        return key/1000;
    }

    public MyHashSet() {
        this.buckets=1000;
        this.bucketItems=1000;
        this.storage= new boolean[buckets][];
    }
    
    public void add(int key) {
        int index = hashFunc(key);
        int index2=hashFunc2(key);
        if(storage[index]==null){
            if(index==0){
                storage[index]= new boolean[bucketItems+1];
            } else {
                storage[index]= new boolean[bucketItems];
            }
        }
        storage[index][index2]=true;
    }
    
    public void remove(int key) {
        int index = hashFunc(key);
        int index2=hashFunc2(key);
        if(storage[index]==null){
            return;
        }
        storage[index][index2]=false;
        
    }
    
    public boolean contains(int key) {
        int index = hashFunc(key);
        int index2=hashFunc2(key);
        if(storage[index]==null){
            return false;
        }
        return storage[index][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
