Push Operation
// Time Complexity : O(1)
// Space Complexity : O(n) We need additional memory to store the queue elements
Pop Operation
// Time Complexity : O(1), O(n)- worst case {When s2 is empty we need to pop all elements from s1 and push it on s2 before we pop top element from stack s2}
// Space Complexity : O(1) Popping element from top of auxiliary stack s2 
Peek Operation:
// Time Complexity : O(1) front element is either calculated during push to s1 or returned as top element of s2
// Space Complexity : O(1) 
Empty Operation:
// Time Complexity : O(1)
// Space Complexity : O(n)


// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach



class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    int front;
    public MyQueue() {
        this.s1 = s1;
        this.s2 = s2;
        this.front = front;
    }
    
    public void push(int x) { //The newly arrived element is added on top of stack s1 and the first element is kept as front queue element
    if (s1.empty()){
        front = x;
    }
        s1.push(x);
    }
    
    public int pop() { // If s2 is empty we need to pop all elements from s1 and push it on s2 before we pop top element from stack s2
        if (s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() { // If s2 is empty we return front element otherwise return top of s2
        if (!s2.isEmpty()){
            return s2.peek();
        }
        return front;
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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
