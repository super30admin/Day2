// Time Complexity : Avg Case O(N) O(N/K) N = #Keys, Worst Case O(N)
// Space Complexity : O(K+M) K= #Buckets, M = #UniqueKeys
// Did this code successfully run on Leetcode : For one big input it did not, says wrong answer otherwise Yes
// Any problem you faced while coding this : No
class MyHashSet {
    private int len;  // nearest prime number to Math.sqrt(10^6)
    private LinkedList[] arr;

    public MyHashSet() {
        this.len = 3163;
        this.arr = new LinkedList[len];
        for(int i=0; i<len; i++) {
            this.arr[i] = new LinkedList<Integer>();
        }
    }
    
    public void add(int key) {
        //calculate hash index
        int hashIndex = this.hashFunction(key);
        //check if the linkedList has key
        //if key not present then add
        if(!contains(key))
            this.arr[hashIndex].addFirst(key);
    }
    
    public void remove(int key) {
        //calculate hash index
        int hashIndex = this.hashFunction(key);
        //check if the linkedList has key
        //if key is present then remove
        if(contains(key))
            this.arr[hashIndex].remove();
    }
    
    public boolean contains(int key) {
        int hashIndex = this.hashFunction(key);
        return this.arr[hashIndex].indexOf(key) != -1;
    }
    
    private int hashFunction(int key) {
        return (key % len);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */