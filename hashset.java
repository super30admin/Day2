class MyHashSet {
    private static int H1_HELPER = 1000;
    private static int H2_HELPER = 1000;
    private boolean[][] arr;

    public MyHashSet() {
        arr = new boolean[H1_HELPER][];
    }
    
    private int gethash1(int key){ 
        return key%H1_HELPER;
        
    }
    
    private int gethash2(int key){
        return key/H2_HELPER;
    }
    
    public void add(int key) {
        if(!contains(key)){
            int hash1 = gethash1(key);
                if(arr[hash1]==null){
                    // to handle the edge case when key is 10^6
                    if(hash1==0)
                        arr[hash1]= new boolean[H2_HELPER+1];
                    else
                        arr[hash1]= new boolean[H2_HELPER];
                }
            int hash2 = gethash2(key);
            arr[hash1][hash2]= true;
        }
        
    }
    
    public void remove(int key) {
        if(contains(key)){
            int h1 = gethash1(key);
            int h2 = gethash2(key);
            arr[h1][h2]= false;
        }
        
    }
    
    public boolean contains(int key) {
        int i = gethash1(key);
        if(arr[i]==null)
            return false;
        int j = gethash2(key);
        return arr[i][j];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
