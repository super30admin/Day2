// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class MyQueue {

    Stack<Integer> inSt; // In stack to insert elements
    Stack<Integer> outSt; // Out stack to peek elements or remove

    public MyQueue() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();
    }

    public void push(int x) {
        inSt.push(x); // push elements to the In stack
    }

    public int pop() {
        peek(); // To reorder the elements of the In stack
        return outSt.pop();
    }

    public int peek() {
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
    }

    public boolean empty() {
        return inSt.isEmpty() && outSt.isEmpty();
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