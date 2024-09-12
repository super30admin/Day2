// Time Complexity : Add : O(1), Remove : O(1), Contains : O(1), Arrays.fill() : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Wondering how it can be optimized. Tried 2d array but failed in some edge cases.


// Your code here along with comments explaining your approach
class MyHashSet {
    int[] nums;

    public MyHashSet() {
        nums = new int[1000001]; //Use size as 1+10^6 because of the given range of input
        Arrays.fill(nums, -1); //Default values in an array is 0. But 0 is in our input range so -1 indicates number not added in hashset
    }

    public void add(int key) {
        nums[key] = key;
    }

    public void remove(int key) {
        if(nums[key]==-1) return;
        nums[key] = -1;
    }

    public boolean contains(int key) {
        if(nums[key]==-1) return false;
        else return true;
    }
}
