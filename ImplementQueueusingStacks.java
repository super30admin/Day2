// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I have difficulty in understanding time and space complexities


// Your code here along with comments explaining your approach
class MyQueue {

    List<Integer> list=new ArrayList<>();
    Stack<Integer> stack=new Stack<>();
    
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
        list.add(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        stack.pop();
        int n=list.remove(0);
        return n;
    }
    
    /** Get the front element. */
    public int peek() {
        return list.get(0);
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

