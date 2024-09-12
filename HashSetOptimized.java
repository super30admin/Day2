/*
The time complexity of add, put and remove is O(1).

Here, we use 2d matrix with double hashing. The advantage here is while initiating the hasharray we only initiate the first level.
When any new element need to be added, then we initiate the 2nd dimension of that particular element.

Yes, the solution was run of leetcode.
 */
class MyHashSet {

    boolean[][] hasharray;
    int firsthash = 1000;
    int secondhash = 1000;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hasharray = new boolean[firsthash][];
    }

    public void add(int key) {
        int first = key%firsthash;
        int second = key/secondhash;
        if(hasharray[first]==null){
            hasharray[first] = new boolean[secondhash];
        }
        hasharray[first][second] = true;
    }

    public void remove(int key) {
        int first = key%firsthash;
        int second = key/secondhash;
        if(hasharray[first]!=null){
            hasharray[first][second] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int first = key%firsthash;
        int second = key/secondhash;
        if(hasharray[first]!=null){
            return hasharray[first][second];
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