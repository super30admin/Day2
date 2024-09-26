// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : When using object Boolean array. It was much slower.
// Can you please clarify on an ideal condition to use object type of primitive variable?

// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] arr;
    int col,row;

    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new boolean[1000][];
    }

    private void setLoc(int key){
        col = key % 1000;
        row = key / 1000;
    }

    public void add(int key) {
        setLoc(key);
        if(arr[col] == null){
            if(col == 0)
                arr[col] = new boolean[1001];
            else if(col != 0)
                arr[col] = new boolean[1000];
        }
        arr[col][row] = true;
    }

    public void remove(int key) {
        setLoc(key);
        if(arr[col] != null)
            arr[col][row] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        setLoc(key);
        if(arr[col] != null)
            return arr[col][row];
        else
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