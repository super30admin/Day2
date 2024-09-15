import java.util.Stack;

class MyQueue {
Stack<Integer> qstack;
Stack<Integer> tstack;
    /** Initialize your data structure here. */
    public MyQueue() {
        qstack = new Stack<>();
        tstack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!qstack.isEmpty()){
            tstack.push(qstack.pop);
        }

        qstack.push(x);

        while(!tstack.isEmpty()){
            qstack.push(tstack.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int fr = qstack.peek();
        qstack.pop();
        return fr;
    }
    
    /** Get the front element. */
    public int peek() {
       return qstack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return qstack.isEmpty();
    }


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

 public static void main(String[] args) {
     MyQueue obj = new MyQueue();
     obj.push(1);
     obj.push(2);
     obj.push(3);
     obj.peek();
     obj.pop();
     obj.peek();

 }

}