// Time Complexity : O(n) for push and pop and O(1) for other operation
// Space Complexity : O(n) for the stack for push and pop| rest all O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    //Stack 1 is used for inserting the rear element
    //Stack 2 is used for getting the front element
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // shift all the elements from stack2 to stack1
        if(!stack2.isEmpty()) {
            while(!stack2.isEmpty())
                stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // shift all the elements from stack1 to stack2
        if(!stack1.isEmpty()) {
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        //shift all the elements from stack1 to stack2
        if(!stack1.isEmpty()) {
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        // if both stack1 and stack2 are empty then the queue is empty
        if(stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        return false;
    }
}


// Your code here along with comments explaining your approach
// Time Complexity : Push - O(1), Pop - Average O(1) and worst O(n), O(1) for rest operations
// Space Complexity : Push - O(n) (for storing values in stack), Pop - O(1), O(1) for rest operations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    //Stack 1 is used for inserting the rear element
    //Stack 2 is used for getting the front element
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // We always insert in stack 1
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        peek();
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        // we check if stack2 is empty. If stack2 is empty shift all the elements from stack1 to stack2 such that stack2 gives us the front element of the queue
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        // if both stack1 and stack2 are empty then the queue is empty
        if(stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        return false;
    }
}

// Design a hashset
// Your code here along with comments explaining your approach
// Time Complexity : O(1)
// Space Complexity : O(Max value of key) which is constant here so O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet {

    /** Initialize your data structure here. */
    // Create an array of size 1000001
    boolean [] arr;
    public MyHashSet() {
        arr = new boolean[1000001];
    }

    public void add(int key) {
        arr[key] = true;
    }

    public void remove(int key) {
        if(arr[key] == false) {
            return;
        }
        arr[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(arr[key] == false) {
            return false;
        }
        return true;
    }
}

// Your code here along with comments explaining your approach
// Time Complexity : O(1)
// Space Complexity : O(square root of key) which is constant here so O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

    /** Initialize your data structure here. */
    // Use a 2D array of size 1000 x 1001 --> 1001 because 10^6/10^3 is 1000
    //10^3 is square root of 10^6
    boolean [][] arr;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001; //1001 because 10^6/10^3 is 1000
        arr = new boolean[buckets][];
    }
    private int bucket(int key) {
        // hash function
        return key%buckets;
    }
    private int bucketItem(int key) {
        // hash function
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(arr[bucket] == null) {
            // initialise only if you want to add
            arr[bucket] = new boolean[bucketItems];
        }
        arr[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(arr[bucket] == null) {
            // not bucket not initalised
            return;
        }

        arr[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(arr[bucket] == null) {
            // if bucket not initialised
            return false;
        }

        return arr[bucket][bucketItem];
    }
}
