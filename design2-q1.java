// lc 232
// queue using stack

// we stored all the pushed elements in the inSt and on every pop/peek operation move them to outSt popping all the elements one by one

class MyQueue {
    private Stack<Integer> inSt;
    private Stack<Integer> outSt;

    public MyQueue() {
       inSt = new Stack<>();
       outSt = new Stack<>();
    }
    // Overall Time complexity - O(1)
    public void push(int x) {
        inSt.push(x);
    }
    // Overall Time complexity - O(1)
    public int pop() {
        peek();
        return outSt.pop();
    }
    // Overall Time complexity - O(1)
    public int peek() {
        if (outSt.isEmpty()){
            while (!inSt.isEmpty())
                outSt.push(inSt.pop());
        }
        return outSt.peek();
    }
    // Overall Time complexity - O(1)
    public boolean empty() {
        return (inSt.isEmpty() && outSt.isEmpty());
        
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