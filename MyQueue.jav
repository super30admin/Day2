class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack1.add(x);
    }
    
    public int pop() {
        if (!stack2.isEmpty()) {
            return (int)stack2.pop();
        }

        while (!stack1.isEmpty()) {
            stack2.add((int)stack1.pop());
        }

        if (!stack2.isEmpty()) {
            return (int)stack2.pop();
        }

        return -1;
    }
    
    public int peek() {
        if (!stack2.isEmpty()) {
            return (int)stack2.peek();
        }

        while (!stack1.isEmpty()) {
            stack2.add((int)stack1.pop());
        }

        if (!stack2.isEmpty()) {
            return (int)stack2.peek();
        }

        return -1;
    }
    
    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty())
            return true;
        return false;
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