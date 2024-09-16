class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
    stack1 = new Stack<Integer>();
    stack2 = new Stack<Integer>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
         while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        int toReturn = stack2.pop();

            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        return toReturn;
    }

    /** Get the front element. */
    public int peek() {
        while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        int toReturn = stack2.peek();

        while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }

        return toReturn;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        if (stack1.isEmpty() && stack2.isEmpty() ){
            return true;
        }
        else{
            return false;
        }
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