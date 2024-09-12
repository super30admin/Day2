// Time Complexity : O(1)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/** Initialize your data structure here. */
class MyHashSet{
    int capacity=1500;
    LinkedList<Integer>[] arr;
    public MyHashSet() {
        arr = new LinkedList[capacity];
    }
    public int getIndex(int key)
    {
        return key%capacity;
    }

    public void add(int key) {
        int index = getIndex(key);
        if(arr[index] == null)
        {
            arr[index] = new LinkedList<>();
        }
        if(arr[index].indexOf(key) == -1)
        {
            arr[index].add(key);
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        if(arr[index] == null|| arr[index].indexOf(key) == -1) return;
        arr[index].remove(arr[index].indexOf(key));
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        if(arr[index] == null|| arr[index].indexOf(key) == -1) return false;
        return true;

    }
}
// Your code here along with comments explaining your approach
