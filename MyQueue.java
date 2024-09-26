import java.util.Stack;

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
	/*
		- While pushing the elements.
		- Because Queue is FIFO.
		- The first element that is pushed should be always available for POP immediately/Or at the top.
		- Because of this for every pushed element should be at the bottom/start index of stack.
		- Whenever we call pop the top/last pushed element should be always popped first.
	 */
    public void push(int x) {
        //before pushing pop all elements from main stack in to temporary stack.
        while (!in.empty()) {
            out.push(in.pop());
        }
        out.push(x);

        //again put back the elements with the order of most recent element residing at the bottom of stack.
        while (!out.empty()) {
            in.push(out.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return in.pop();
    }

    /** Get the front element. */
    public int peek() {
        return in.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.empty();

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