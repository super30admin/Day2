// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    
   
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
   
    public void push(int x) {
        stack1.push(x);
    }
    
    //Remove from front of queue and and return
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int elem = stack1.pop();
                stack2.push(elem);
            }
        }
        return stack2.pop();
    }
    
    //Return front element
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int elem = stack1.pop();
                stack2.push(elem);
            }
        }
        return stack2.peek();
    }
    
    
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
------------------------------------------------------------------------------------------
// Time Complexity :O(n) due to initialization of buckets in bucketArray? bit confused about this
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no
class Bucket {
  private LinkedList<Integer> storage;

  public Bucket() {
    storage = new LinkedList<Integer>();
  }

  public void insert(Integer key) {
    int index = this.storage.indexOf(key);
    if (index == -1) {
      this.storage.addFirst(key);
    }
  }

  public void delete(Integer key) {
    this.storage.remove(key);
  }

  public boolean exists(Integer key) {
    int index = this.storage.indexOf(key);
    return (index != -1);
  }
}

class MyHashSet {
  private Bucket[] bucketArray;
  private int keyRange;

  /** Initialize your data structure here. */
  public MyHashSet() {
    this.keyRange = 769;
    this.bucketArray = new Bucket[this.keyRange];
    for (int i = 0; i < this.keyRange; ++i)
      this.bucketArray[i] = new Bucket();
  }

  protected int hash(int key) {
    return (key % this.keyRange);
  }

  public void add(int key) {
    int bucketIndex = this.hash(key);
    this.bucketArray[bucketIndex].insert(key);
  }

  public void remove(int key) {
    int bucketIndex = this.hash(key);
    this.bucketArray[bucketIndex].delete(key);
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int bucketIndex = this.hash(key);
    return this.bucketArray[bucketIndex].exists(key);
  }
}
