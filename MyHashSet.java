// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No

class MyHashSet {

    /** Initialize your data structure here. */
    int buckets;
    int bucketNums;
    Node[][] nums;
    public MyHashSet() {
        buckets = 1000;
        bucketNums = 1000;
        nums = new Node[buckets][];
    }
    
    public int getBucketLocation(int key){
        return key%bucketNums;
    }
    
    public int getKeyLocation(int key){
        return key/bucketNums;
        
    }
    
    public void add(int key) {
        int bucket_index = getBucketLocation(key);
        int key_index = getKeyLocation(key);
        if (nums[bucket_index] == null){
            if (bucket_index == 0){
                nums[bucket_index] = new Node[bucketNums + 1];
            }
            else{
                nums[bucket_index] = new Node[bucketNums];
            }
            
        }
        nums[bucket_index][key_index] = new Node(key);
        
    }
    
    public void remove(int key) {
        int bucket_index = getBucketLocation(key);
        int key_index = getKeyLocation(key);
        if (nums[bucket_index] == null || nums[bucket_index][key_index] == null){
            return;
        }
        else{
            nums[bucket_index][key_index] = null;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket_index = getBucketLocation(key);
        int key_index = getKeyLocation(key);
        if (nums[bucket_index] == null || nums[bucket_index][key_index] == null){
            return false;
        }
        return true;
        
    }
}

class Node{
    int data;
    public Node(int data){
        this.data = data;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */