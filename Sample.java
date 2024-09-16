// Problem-1

// Time Complexity : O(n) for pop and peek functions O(1) for Push
// Space Complexity : O(n) as we are using an additional stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


class MyQueue {
    // Initlization of 2 Stacks
    Stack <Integer> st1 = new Stack<>(); 
    Stack <Integer> st2 = new Stack<>();
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       if(st2.isEmpty())
       {
           while(!st1.isEmpty()){
               st2.push(st1.pop());
           }
       }
        return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       if(st2.isEmpty())
       {
           while(!st1.isEmpty()){
               st2.push(st1.pop());
           }
       }
        return st2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
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




//Problem 2.

// Time Complexity : O(1) for add and remove
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No. Basic Java syntactical errors. I am catching up.


// Your code here along with comments explaining your approach
class MyHashSet {

    //Initialization of data structure
    // As the range is 1000 we require a matrix of 1000*1000
    int buckets =1000;
    int bucketItems= 1000; 
    boolean [][] storage = new boolean[buckets][];//row   initlaiztions is compulsory coulumns can be decided run time.
    
    //Hashfunction-1
    private int bucket(int key){
        return key % buckets;
    }
    //Hashfunction-2
    private int bucketItem(int key){
       return key / bucketItems;  
    }
    
        public MyHashSet() {
        
    }
       
    // Time complextity will be O(1)
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null){
            storage[bucket]= new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }
    
    
  // Time Comlexity will be O(1)
  public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
    // Edge Case (incase there is no boolean array at all)
        if(storage[bucket]!=null){
            storage[bucket][bucketItem]=false;
        }
    }
   
    /** Returns true if this set contains the specified element else returns false. */
    public boolean contains (int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]!=null){
            return storage[bucket][bucketItem];
        }else{
            return false;
        } 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
  





