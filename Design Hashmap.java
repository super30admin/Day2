// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class MyHashMap {
    int ans[];
    int size=1000001;
    public MyHashMap() {
       ans=new int[size]; 
    }

    public void put(int key, int value) {
        ans[key]=value+1;
    }

    public int get(int key) {
      return ans[key]-1;

    }

    public void remove(int key) {
        ans[key]=0;
    }
} 