// Time Complexity :O(1)
// Space Complexity : used one array O(n), variables
// Did this code successfully run on Leetcode : yes

class MyHashSet {
    boolean[][] hs;
    public MyHashSet() {
        hs = new boolean[1000][]; 
    }
    
    public int getBuc(int key)
    {
        int buc = key%1000;
        
        return buc;      
    }
    
    public int getBucVal(int key)
    {
        int buc = key/1000;
        
        return buc;        
    }
    
    public void add(int key) {
        int buc = getBuc(key);
        int bucVal = getBucVal(key);
        if(hs[buc] == null){
            if(buc == 0){
                boolean[] bArr = new boolean[1001];
                hs[0] = bArr;
            }else{
                boolean[] bArr = new boolean[1000];
                hs[buc] = bArr;    
            }
        }
        hs[buc][bucVal] = true;
        
    }
    
    public void remove(int key) {
        int buc = getBuc(key);
        int bucVal = getBucVal(key);  
        if(hs[buc] != null)            
            hs[buc][bucVal] = false;
        
        
    }
    
    public boolean contains(int key) {
        int buc = getBuc(key);
        int bucVal = getBucVal(key);   
        if(hs[buc] == null){
            return false; 
        }else{
            return hs[buc][bucVal];
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
