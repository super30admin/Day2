// Time Complexity : For remove and contains its O(n) for add its O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : I am not comfortable with concepts of time,space complexity is there any way to work on the basics?


// Your code here along with comments explaining your approach
/*
* 2 things are fixe elements range and array size
   So we can keep boolean array
   when we add element we can make its index true
   when we remove element we can make its index false
* */


class MyHashSet {

    boolean[] arr=new boolean[1000000];
    int index=0;


    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {
        arr[key]=true;
    }

    public void remove(int key) {
        arr[key]=false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */