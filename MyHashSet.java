// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
class MyHashSet {
    boolean HashSet[][];
    int primaryBucket;
    int secondaryBucket;

    /** Initialize your data structure here. */
    public MyHashSet() {
        primaryBucket = 1000;
        secondaryBucket = 1000;
        HashSet = new boolean[primaryBucket][];
    }

    private int getPrimaryPos(int key){
        return key%primaryBucket;
    }

    private int getSecondaryPos(int key){
        return key/secondaryBucket;
    }
    
    public void add(int key) {
        int primaryArrayPos = getPrimaryPos(key);
        int secondaryArrayPos = getSecondaryPos(key);
        if(HashSet[primaryArrayPos] == null){
            if(primaryArrayPos == 0){
                HashSet[primaryArrayPos] = new boolean [secondaryBucket + 1];
            }
            else{
                HashSet[primaryArrayPos] = new boolean [secondaryBucket];
            }
        }
        HashSet[primaryArrayPos][secondaryArrayPos] = true;
    }
    
    public void remove(int key) {
        int primaryArrayPos = getPrimaryPos(key);
        int secondaryArrayPos = getSecondaryPos(key);
        if(HashSet[primaryArrayPos] == null){
            return;
        }
        HashSet[primaryArrayPos][secondaryArrayPos] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int primaryArrayPos = getPrimaryPos(key);
        int secondaryArrayPos = getSecondaryPos(key);
        if(HashSet[primaryArrayPos] == null){
            return false;
        }
        return HashSet[primaryArrayPos][secondaryArrayPos];
    }
}