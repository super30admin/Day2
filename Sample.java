// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean [buckets][];
    }
    
    private int getBucket(int key) {
        return key % buckets;
    }
    
     private int getBucketItem(int key) {
        return key/buckets;
    }
    
    public void add(int key) {
        int buckets = getBucket(key);
        int bucketItems = getBucketItem(key); 
        if(storage[buckets] == null){
            if(buckets == 0){
                storage[buckets] = new boolean [this.bucketItems + 1];
            }else {
                storage[buckets] = new boolean [this.bucketItems];
            }
            
            
        }
        storage[buckets][bucketItems] = true;
    }
    
    public void remove(int key) {
        int buckets = getBucket(key);
        int bucketItems = getBucketItem(key); 
        if(storage[buckets] == null){
          return; 
        }
        storage[buckets] [bucketItems] = false;
    }
        
    
    
    public boolean contains(int key) {
         int buckets = getBucket(key);
        int bucketItems = getBucketItem(key); 
        if(storage[buckets] == null){
          return false; 
        }
        return storage[buckets] [bucketItems];
    }
    }



// Queue Solution****************************************************************



    class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
       int pop = peek();
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
              out.push(in.pop());  
            }
            
        }
        return out.peek();
    }
    
    public boolean empty() {
      return out.isEmpty()&& in.isEmpty();  
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */