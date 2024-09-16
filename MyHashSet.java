// Time Complexity
// add - O(1)
// remove - O(1)
// contains - O(1)
// Space Complexity - O(n)
// Ran Successfully on the leetcode

class MyHashSet {
    
    int [][] row_array;
    int row_value=1000;
    int col_value=1001;
    
    public MyHashSet() {
        row_array= new int [row_value][];
    }
    
    private int hash_row(int key){
        return key%row_value;
    }
    private int hash_col(int key){
        return key/col_value;
    }
    
    public void add(int key) {
        int row_index= hash_row(key);
        int col_index=hash_col(key);
        // checking for availabity of array
        if(row_array[row_index]==null){
            row_array[row_index]= new int [col_value];
            Arrays.fill(row_array[row_index],-1);
        }
        row_array[row_index][col_index]=key;
    }
    
    public void remove(int key) {
        int row_index= hash_row(key);
        int col_index=hash_col(key);
        if(row_array[row_index]!=null){
            row_array[row_index][col_index]=-1;
        }
    }
    
    public boolean contains(int key) {
        int row_index= hash_row(key);
        int col_index=hash_col(key);
        if(row_array[row_index]!=null){
            if(row_array[row_index][col_index]!=-1){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */