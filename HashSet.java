// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {
    
    private int noOfBuckets = 15000; //Initialise bucket
    private LinkedList<Integer>[] list;
    
    private int hashValue(int key){ //calculate the modulo function for hashkey
        return key % noOfBuckets;
    }

    public MyHashSet() {
        list = new LinkedList[noOfBuckets];
    }
    
    public void add(int key) {
        int hashKey = hashValue(key);
        if(list[hashKey]==null){
            list[hashKey] = new LinkedList<>();
        }
        if(list[hashKey].indexOf(key)==-1){//if no value present at location found from hashValue function then add
            list[hashKey].add(key);
        }
    }
    
    public void remove(int key) {
        int hashKey = hashValue(key);
        if(list[hashKey]==null){
            return;
        }
        if(list[hashKey].indexOf(key)!=-1){// if value found at location remove
            list[hashKey].remove(list[hashKey].indexOf(key));
        }
    }
    
    public boolean contains(int key) {
        int hashKey = hashValue(key);
        if(list[hashKey]==null || list[hashKey].indexOf(key)==-1){// if list is empty or no value present return false
            return false;
        }
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */