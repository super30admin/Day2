class MyHashSet {
    private int size1 = 10000;
    private int size2 = 10000;
    private boolean[][] hashSet;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new boolean[size1][];
    }
    public int hashFunc1(int key){
        return key%size1;
    }
    public int hashFunc2(int key){
        return key/size2;
    }
    public void add(int key) {
        int index1 = hashFunc1(key);
        int index2 = hashFunc2(key);
        
        if(hashSet[index1]==null){
            hashSet[index1] = new boolean[size2];
        }
        hashSet[index1][index2] = true;
        
    }
    
    public void remove(int key) {
        int index1 = hashFunc1(key);
        int index2 = hashFunc2(key);
        
        if(hashSet[index1]!=null){
            hashSet[index1][index2] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashFunc1(key);
        int index2 = hashFunc2(key);
        if(hashSet[index1]!=null){
            return hashSet[index1][index2];
        }
        return false;
    }
}
