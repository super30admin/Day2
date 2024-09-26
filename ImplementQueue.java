class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        //if stack is empty push the first element else push the element to the top of the stack
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        retunn s2.pop();

    }

    /** Get the front element. */
    public int peek() {
       if(s2.empty){
           while(!s1.isEmpty()){
               s2.push(s1.pop());
           }
       }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        //if any of the stack is empty then return false.
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