// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach

class MyHashSet {

    private boolean[][] myHashSet;
    private int primaryArrSize;
    private int nestedArrSize;

    public MyHashSet() {
        primaryArrSize = 1000;
        nestedArrSize = 1000;
        myHashSet = new boolean[primaryArrSize][];
    }

    public int getPrimaryArrIndex(int val){
        return val % primaryArrSize;
    }

    public int getNestedArrIndex(int val){
        return val / nestedArrSize;
    }

    public void add(int key) {
        int primaryArrIndex = getPrimaryArrIndex(key);
        int nestedArrIndex = getNestedArrIndex(key);

        if(myHashSet[primaryArrIndex] == null){
            if(primaryArrIndex == 0)
                myHashSet[primaryArrIndex] = new boolean[primaryArrSize + 1];
            else
                myHashSet[primaryArrIndex] = new boolean[primaryArrSize];
        }
        myHashSet[primaryArrIndex][nestedArrIndex] = true;
    }

    public void remove(int key) {
        int primaryArrIndex = getPrimaryArrIndex(key);
        int nestedArrIndex = getNestedArrIndex(key);

        if(myHashSet[primaryArrIndex] == null) return;
        myHashSet[primaryArrIndex][nestedArrIndex] = false;

    }

    public boolean contains(int key) {
        int primaryArrIndex = getPrimaryArrIndex(key);
        int nestedArrIndex = getNestedArrIndex(key);

        if(myHashSet[primaryArrIndex] == null) return false;
        return myHashSet[primaryArrIndex][nestedArrIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */