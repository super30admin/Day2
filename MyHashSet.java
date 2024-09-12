// Time Complexity : O(n) poor solution but since range is 1-100000 , should not be a problem
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Unable to solve it without intiilaizing a huge array. Poor solution.


// Your code here along with comments explaining your approach


import java.util.Arrays;
class MyHashSet {
    int[] arr;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arr=new int[1000001];
        Arrays.fill(arr,-1);
    }
     
    
    public void add(int key) {
        arr[key]=key;
    }
    
    public void remove(int key) {
        arr[key]=-1;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         return arr[key]!=-1;
    }

}