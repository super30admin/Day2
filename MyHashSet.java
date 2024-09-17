//Time Complexity : O(1)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


class MyHashSet {
    //declaring a boolean to note any value is present or not in the Arrays
    boolean[][] hashSet; 
    int primaryArray=1000;
    int secondaryArray=1000;
    public MyHashSet() {
        //we initially assign a primary array to the hashSet 
        hashSet=new boolean[primaryArray][];
    }
    //and we perform single hashing
    private int hash(int key){
        return key%primaryArray;
    }
    //then double hashing
    private int secondHash(int key){
        return key/secondaryArray;
    }
    
    public void add(int key) {
       int primaryArrays=hash(key);
       int secondaryArrays=secondHash(key);
        //checking if the primary Array is null and contains any keys, if contains moving to next index in the secondary array
        if(hashSet[primaryArrays]==null){
            if(primaryArrays==0){
                hashSet[primaryArrays]=new boolean[secondaryArray+1];
            }
            else{
                hashSet[primaryArrays]=new boolean[secondaryArray];
            }
        }
        hashSet[primaryArrays][secondaryArrays]=true;
    }
    
    public void remove(int key) {
        int primaryArrays=hash(key);
        int secondaryArrays=secondHash(key);
        //if the key is not present then null or else we remove it place false
        if(hashSet[primaryArrays]==null)
            return;
        hashSet[primaryArrays][secondaryArrays]=false;
    }
    
    public boolean contains(int key) {
        int primaryArrays=hash(key);
        int secondaryArrays=secondHash(key);
        //if key is not present we return false else we return the key
        if(hashSet[primaryArrays]==null)
            return false;
        return hashSet[primaryArrays][secondaryArrays];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */