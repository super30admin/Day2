class MyHashSet {
    
    private int H1_Helper=1000;
    private int H2_Helper=1000;
    private boolean arr[][];
    
    public MyHashSet() {
        arr=new boolean[H1_Helper][];
    }
    
    public int getHashOne(int key){
        return key%H1_Helper;
    }
    public int getHashTwo(int key){
        return key/H2_Helper;
    }
    
    public void add(int key) {
        if(!contains(key)){
                int hashOne=getHashOne(key);
            if(arr[hashOne]==null){
                    arr[hashOne]=new boolean[H1_Helper+1];
                }
                int hashTwo=getHashTwo(key);
                arr[hashOne][hashTwo]=true;
            }
        }
    
    public void remove(int key) {
        if(contains(key)){
            int hashOne=getHashOne(key);
            int hashTwo=getHashTwo(key);
            arr[hashOne][hashTwo]=false;
        }
    }
    
    public boolean contains(int key) {
        int hashOne=getHashOne(key);
        if(arr[hashOne]==null)
            return false;
        int hashTwo=getHashTwo(key);
        return arr[hashOne][hashTwo];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
