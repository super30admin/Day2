class MyQueue {

    private int front; //maintain front of the queue
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        this.front = -1;
        this.s1 = new Stack();
        this.s2 = new Stack();
    }

    public void push(int x) {

        if(s1.isEmpty())
        {
            if(s2.isEmpty())
                front = x;
        }

        s1.push(x);
    }

    public int pop() {

        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }

        int popped = s2.pop();

        if(s2.isEmpty())
            front = -1;
        else
            front = s2.peek();

        while(!s2.isEmpty())
        {
           s1.push(s2.pop());
        }

        return popped;
    }

    public int peek() {
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
