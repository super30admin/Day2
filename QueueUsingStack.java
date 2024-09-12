/** Leet Code Problem 232
    Implement Queue using Stacks
    Language Used : Java
    Link: https://leetcode.com/problems/implement-queue-using-stacks/
    Results: Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
    Memory Usage: 36.6 MB, less than 86.07% of Java online submissions for Implement Queue using Stacks.

Explaination:

 Data Structures Used : 2 Stacks s1 and s2
 Push function sets the queue from lifo to fifo every time a value is entered
 */

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();  
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(s1.size()>0){
            s2.push(s1.pop());
        }
        s2.push(x);
        while(s2.size()>0){
            s1.push(s2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty()&&s2.isEmpty();
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

