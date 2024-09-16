class MyHashSet {
    private int hkey1;
    private int hkey2;
    private int size;
    private boolean[][] hashset;
    public MyHashSet() {
        hkey1=1000;
        hkey2=1000;
        size=1000;
        hashset = new boolean[size][];
    }
    
    private int hash1(int key) {
        return key%hkey1;
    }
    
    private int hash2(int key) {
        return key/hkey2;
    }
    
    public void add(int key) {
        int hashkey1 = hash1(key);
        if(hashset[hashkey1]==null)
         {
              hashset[hashkey1] = new boolean[hashkey1==0?size+1:size];
         }
        hashset[hashkey1][hash2(key)]=true;
    }
    
    public void remove(int key) {
        if(hashset[hash1(key)]==null)
            return;
        
        hashset[hash1(key)][hash2(key)]=false;
    }
    
    public boolean contains(int key) {
        if(hashset[hash1(key)]==null)
            return false;
        return hashset[hash1(key)][hash2(key)];
    }
}