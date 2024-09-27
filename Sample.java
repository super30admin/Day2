//Problem 2(https://leetcode.com/problems/design-hashset/)
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : First I tried it using linked list and after in-class explanation i tried with boolean array


// Your code here along with comments explaining your approach

class MyHashSet {

//boolean 2-d boolean array
   private boolean[][] storageArray;
    int buckets;
    int bucketItems;

    public MyHashSet() {

//Intitalized primary array to 10^3 and seconday array as 10^3  
    buckets = 1000;
    bucketItems=1000;
    storageArray = new boolean[buckets][];

    }
    //First hash function to get index in primary array
    public int getBucket(int key)
    {
        return key%buckets;
    }
    //second hash function to get index in secondary array
    public int getBucketItem(int key)
    {
        return key/bucketItems;
    }

//if primary array is null , it will create secondary array and make that index true
    public void add(int key) {
       int bucket = getBucket(key);
       int bucketItem = getBucketItem(key);
      if(storageArray[bucket]==null)
      {
          if(bucket ==0)
          storageArray[bucket]=new boolean[bucketItems+1];

          else
          storageArray[bucket]=new boolean[bucketItems];
      }
        storageArray[bucket][bucketItem]=true;      

    }
    //make that index as false
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storageArray[bucket]==null) return;        
        else storageArray[bucket][bucketItem]=false;          

    }
    //return the boolean value of that index
    public boolean contains(int key) {
        int bucket = getBucket(key);
       int bucketItem = getBucketItem(key);
        if(storageArray[bucket]==null) return false;        
        else return storageArray[bucket][bucketItem];
     }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */









//Problem 1(https://leetcode.com/problems/implement-queue-using-stacks/)
// Time Complexity :O(1) in best case and O(n) in worst case
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach


//used two stack to implement queue
class MyQueue {

    private Stack<Integer> st1;
    private Stack<Integer> st2;
   
    public MyQueue() {
     st1 = new Stack<>(); 
     st2 = new Stack<>();  
    }
    
    public void push(int x) {  
      st1.push(x);
    }
    
    public int pop() {
       peek();
       return st2.pop();
    }
    
    public int peek() {
        if(st2.isEmpty())
        {
           while(!st1.isEmpty())
           {
               st2.push(st1.pop());
           }
        }
       return st2.peek(); 
    }
    
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
