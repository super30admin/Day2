// Time Complexity : O(N) (Overall)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
// I am using two stacks to maintain the queue property or rule called FIFO, here stack (in) will push all the items and while removing the item we can use peek method to take the top most item from the (in) stack and push it to out stack and we can pop the element by using the peek mehtod, Empty method will return the value from isEmpty method of stack




class MyQueue {
    Stack<Integer>in;
    Stack<Integer>out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    // Time complexity will be O(N)
    public void push(int x) {
        in.push(x);
    }
    
    // Time complexity will be O(1)
    public int pop() {
        peek();
        return out.pop();
    }
    
    // Time complexity will be O(1)
    public int peek() {
        if(out.isEmpty())
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        return out.peek();
    }
    
    // Time complexity will be O(1)
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
