// Time Complexity : O(n) , Armotized Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Time Complexity : pop - on average its O(1) in worst case its O(n) if we keep on adding many numbers and then pop
// Time Complexity : push - O(1)
// Time Complexity : peek - on average its O(1) in worst case its O(n) if we keep on adding many numbers and then peek

// Your code here along with comments explaining your approach

class MyQueue {
    
    Stack<Integer> st1; // stack to push all incoming numbers
    Stack<Integer> st2; //stack to reverse the order of elemnets already present
    
    /** Initialize your data structure here. */
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!st2.isEmpty())
            return st2.pop();
        else{ // if stack 2 is empty push all elements of stack 1 to it 
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            return st2.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if(!st2.isEmpty())
            return st2.peek();
        else{
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            return st2.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty(); //if both stacks are empty there is no element in queue.
    }
}