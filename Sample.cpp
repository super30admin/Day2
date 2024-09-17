class MyHashSet {
public:
    
    bool arr[1001][1001]; 
    MyHashSet() { 
        memset(arr,0,sizeof(arr));
    }
    
    void add(int key) {
        
        int bucketS = bucketSize(key);
        int bucketI = bucketIndex(key);
        arr[bucketS][bucketI] = true;
        
    }
    
    void remove(int key) {
        int bucketS = bucketSize(key);
        int bucketI = bucketIndex(key);
        arr[bucketS][bucketI] = false;
    }
    
    bool contains(int key) {
        int bucketS = bucketSize(key);
        int bucketI = bucketIndex(key);
          
        return arr[bucketS][bucketI];
    }
    
    int bucketSize(int key){
        return key%1000;
    }
    
    int bucketIndex (int key){
        return key/1000;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
