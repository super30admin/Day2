// Problem-1
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> stack1 = new Stack<>(); // stack 1 created to store elements of queue
    Stack<Integer> stack2 = new Stack<>(); // stack 2 used for pop operation
    int front; // to keep track of front element so there is no need to pop all elements and insert to stack 2 again
/** Initialize your data structure here. */
public MyQueue() {
   
}

/** Push element x to the back of queue. */
public void push(int x) {
    if(stack1.isEmpty()) // for first element
    {
        front = x; // initialzied front to data x
    }
    stack1.push(x); // pushing elements to the stack
}

/** Removes the element from in front of queue and returns that element. */
public int pop() {
    
    while(!stack1.isEmpty()) // traversing through all the elements of stack 1
    {
       stack2.push(stack1.pop()); // popping elements out of stack1 and pushing to stack 2 
    }
    int val = stack2.pop(); // now the value at top of stack 2 gives the front element that is to be popped
    
    while(!stack2.isEmpty()) // putting elements back to stack 1
    {
        if(stack1.isEmpty()) // if first element is inserted
             front = stack1.push(stack2.pop()); // pop it out of stack 2 and push to stack 1 and initialize front to the element value
        else
            stack1.push(stack2.pop()); // pop elements out of stack 2 and push back to stack 1
    }
    return val; // return the popped element
}

/** Get the front element. */
public int peek() {
    return front; // return the front that stores front of queue
}

/** Returns whether the queue is empty. */
public boolean empty() {
    return stack1.isEmpty(); // checking if stack 1 is empty
        
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
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Encountered IndexOutOfBoundsException and could not understand why


// Your code here along with comments explaining your approach

class MyHashSet {
    int size = 769; // size intialized to prime number to avoid collision
    LinkedList<Integer> arr[] = new LinkedList[size]; // Initialized array of type linkedlist
    /** Initialize your data structure here. */
    public MyHashSet() { 
        for (int i=0; i<size ; i++) // traversing through the array
        {    
            this.arr[i] = new LinkedList<Integer>();  // initializing a new linkedlist at each index
        }
    }
    
    public int findIndex(int key)
    {
        return key % size; // hash function given by value modulo size taken of array
    }
    
    public void add(int key) {
        
        int mod = findIndex(key); // finding the index where value has to be stored
        int index = arr[mod].indexOf(key); // finding if the value is already present at the index
        if(index == -1) // if not present i.e unique values
            arr[mod].addFirst(key); // adding to the start of linkedlist at the found index
        
    }
    
    public void remove(int key) {
        
        int mod = findIndex(key); // finding the index where value has to be removed
        int index = arr[mod].indexOf(key); // finding if the value is already present at the index
        if(index != -1) // if present
             arr[mod].remove(key); // removing the value at the index 
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int mod = findIndex(key); // finding the index where value is present
      return (arr[mod].indexOf(key) != -1); // returning true if index of the value present otherwise false
            
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */