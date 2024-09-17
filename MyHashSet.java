// Time Complexity : O(1) to add, udpdate
// Space Complexity : O(1000000)-> constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

class MyHashSet {

    int MAX = 1000000;
    List<Integer> set[];

    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new ArrayList[MAX];
    }

    private int getIndex(int key){
        return key%MAX;
    }

    private int getPos(int key,int index){

        if (set[index] == null){
            return -1;
        }
        else{
            for (int i = 0; i < set[index].size(); i++){
                if (set[index].get(i) == key){
                    return i;
                }
            }
            return -1;
        }
    }

    public void add(int key) {
        int index = getIndex(key);
        int pos = getPos(key,index);
        if (pos < 0){
            if (set[index] == null){
                set[index] = new ArrayList<Integer>();
            }
            set[index].add(key);
        }
        else{
            set[index].set(pos,key);
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        int pos = getPos(key,index);
        if (pos >= 0){
            set[index].remove(pos);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        int pos = getPos(key,index);
        return pos >= 0;
    }
}

/*
28 / 28 test cases passed.
Status: Accepted
Runtime: 16 ms
Memory Usage: 47.6 MB
 */