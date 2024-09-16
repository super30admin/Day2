// Time Complexity : O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    
    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);//push values as they come
    }
    
    public int pop() {
        peek();
        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){//is stack 1 is not empty 
                s2.push(s1.pop());//keep popping element so its first element on top
            }
        }
        return s2.peek();//this gives first element
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