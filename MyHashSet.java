// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : n/a


// Your code here along with comments explaining your approach
class MyHashSet {
    private boolean[][] arr; //hashset storing whether element is present or not
    private static int H1_HELPER = 1000; //10^3
    private static int H2_HELPER = 1000; // 10^3
    
    public MyHashSet() {
        arr = new boolean[H1_HELPER][];
        
    }
    
    // %1000
    private int getHash1(int key){
        return key%H1_HELPER;
    }
    
    private int getHash2(int key){
        return key/H2_HELPER;
    }
    
    // key/1000
    public void add(int key) {
        if (!contains(key)){
            int hash1 = getHash1(key);
            if (arr[hash1] == null){
                // handle edge case of 10^6
                if(hash1 == 0){
                    arr[hash1] = new boolean[H1_HELPER+1];
                }
                else{
                    arr[hash1] = new boolean[H1_HELPER];
                }
            }
            int hash2 = getHash2(key);
            arr[hash1][hash2] = true;
        }
    }
    
    public void remove(int key) {
        if(contains(key)){
            int hash1 = getHash1(key);
            int hash2 = getHash2(key);
            arr[hash1][hash2] = false;
        }
    }
    
    public boolean contains(int key) {
        int hash1 = getHash1(key);
        if(arr[hash1] == null){
            return false;
        }
        int hash2 = getHash2(key);
        return arr[hash1][hash2];
    }

    public static void main(String[] args) 
    {
        MyHashSet obj = new MyHashSet();
        obj.add(22);
        obj.add(155);
        obj.remove(224);
        boolean r1 = obj.contains(155);
        boolean r2 = obj.contains(224);
        boolean r3 = obj.contains(38);       
    }
}