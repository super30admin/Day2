//// Problem 1

// Time Complexity : O(n) for pop | O(1) other functions
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MyQueue {

  //Using two stacks to reverse the entered set of elements
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    /** Initialize your data structure here. */
    public MyQueue() {
      //initialized both stacks
        stack1 = new Stack();
        stack2 = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
      //using stack1 to store pushed elements directly achieving O(1) time complexity
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek(); //calling peek function which implements logic of putting all elements first in stack2
        return stack2.pop();
    }
    
    /** Get the front element. */
    
  //takes each element out of stack1 and pushes it inside stack2
    public int peek() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
  //ends up with reversed stack (which is closest to how queue should look like  
  
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stack1.empty() && stack2.empty()); //checks for empty case for both stacks
    }
}


//// Problem 2

// Time Complexity : O(1)
// Space Complexity : O(K+M) K: number of buckets M: number of items in bucket
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyHashSet {

    boolean[][] storage;
    int buckets;
    int bucketItems;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000; //decided on the basis of rough hack (square root of the total number of elements) in this case 1000000 so square root is 1000
        bucketItems = 1000; //1000*1000 = 1000000
        storage = new boolean[buckets][]; //initializing just one directional
    }
    
    private int bucket(int key){
        return key%buckets; //for storing in 1st direction
    }
    
    private int bucketItem(int key){
        return key/bucketItems; //for storing inside each bucket
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
      
      //achieving double hashing
      
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1]; //to avoid creation of 1000 element array at 0th index
            }
            else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
      //achieving double hashing
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        

        if(storage[bucket] == null){
            return; //since the element is not present returning true because there is nothing to remove
        }
        storage[bucket][bucketItem] = false; //indicating the value is no longer present in the set
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
      //achieving double hashing
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(storage[bucket] == null){
            return false;
        }
        
        return storage[bucket][bucketItem]; //returning the value present at the location
    } 
}
