// Problem-1
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class MyQueue {
        Stack<Integer> in; // input stack
        Stack<Integer> out; // output stack
        
    /** Initialize your data structure here. */
    public MyQueue() {
       in = new Stack<Integer>();
       out = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
       in.push(x); // pushing through input stack. It will act as the rear end
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()) // if it is the first pop i.e no element in out stack
        {
            while(!in.isEmpty()) // check if in stack is not empty for popping
            {
                out.push(in.pop()); // pop out of in stack and push all elements to out stack. It will act as the front end
            }
        }
          return out.pop(); // pop and return
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()) // if it is the first peek i.e no element in out stack
        {
            while(!in.isEmpty()) // check if in stack is not empty for checking peek
            {
                out.push(in.pop()); // pop out of in stack and push all elements to out stack. It will act as the front end
            }
        }
        
        return out.peek(); // check peek and return
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (in.isEmpty() && out.isEmpty()); // when both in and out stack is empty
            
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


 // Problem-2
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Encountered IndexOutOfBoundsException and could not understand why

class MyHashSet {
    //Double Hashing
    boolean hashset[][]; 
    //for 1 million records, assumed square root of the items as the dimension
    int buckets = 1000, bucketItems = 1001; // items considered one more to handle edge case
    /** Initialize your data structure here. */
    public MyHashSet() { 
      hashset = new boolean[buckets][]; // only initialized the rows of the array. Columns will be initialized according to the need to optimize the code
    }
    
    //custom method
    private int bucketIndex(int key)
    {
        return key % buckets; // hashing function to find row index
    }
   
    //custom method
     private int bucketItemIndex(int key)
    {
        return key / bucketItems; // hashing function to find column index
    }
    
    public void add(int key) {
        int bucket = bucketIndex(key); // find row index
        int bucketItem = bucketItemIndex(key); // find column index
        if(hashset[bucket] == null) // initially array initialized with null as contains pointers to the lists
             hashset[bucket] = new boolean[bucketItems]; // initialize the column list
        
        hashset[bucket][bucketItem] = true; // set the value at the found index where key should go to true to indicate addition to array
    }
    
    public void remove(int key) {
        int bucket = bucketIndex(key);
        int bucketItem = bucketItemIndex(key);
        if(hashset[bucket] != null) // value not null i.e value present
             hashset[bucket][bucketItem] = false; // set to false to indicate removal
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucketIndex(key);
        int bucketItem = bucketItemIndex(key);
        if(hashset[bucket]!=null) // value not null i.e value present
         return hashset[bucket][bucketItem]; // return the value at the index i.e true or false
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */