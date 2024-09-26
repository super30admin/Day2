// Time Complexity : 
// add:o(n)
// remove:o(1)
// contains:o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

    class MyHashSet {

        /** Initialize your data structure here. */
        int bucket;
        int bucketItems;
        boolean[][] storage;
        public MyHashSet() {
            bucket =1000;
            bucketItems=1000;
            storage = new boolean[bucket][];
        }
        public int bucket(int key){
            return key%1000;
        }
        
        public int bucketItems(int key){
            return key/1000;
        }
        
        public void add(int key) {
            int pi = bucket(key);
            int si = bucketItems(key);
            if(storage[pi]==null){
                if(pi==0){
                    storage[pi]= new boolean[bucketItems+1];
                }
                else{
                    storage[pi] = new boolean[bucketItems];
                }
            }
            storage[pi][si]=true;
        }
        
        public void remove(int key) {
           int pi = bucket(key);
            int si = bucketItems(key);
            if(storage[pi]==null)return;
            storage[pi][si]=false;
        }
        
        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int pi = bucket(key);
            int si = bucketItems(key);
            if(storage[pi]==null)return false;
            return storage[pi][si];
        }
    }
    
    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */

