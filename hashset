class MyHashSet {

    //private Boolean isExist = false;
    private int[] HS = new int[1000001]; //problem this is if we have 0 in test
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        HS[key] = key;
        
        //for 0
        if (key == 0){
            HS[key] = -1;
        }
        
    }
    
    public void remove(int key) {
        HS[key] = -2;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(key == 0){
            if(HS[key] == -1){
                return true;
            }
        }
        else{
            if(HS[key] == key){
                return true;
            }
        }
    
        return false;
     }
    }