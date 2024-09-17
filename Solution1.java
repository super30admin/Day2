//Implement Queue using Stacks
//T: O(N)
//S: O(N) when cosidering both the needed stack; else O(1)
class MyQueue {

    Deque<Integer> input;
    Deque<Integer> output;
    /** Initialize your data structure here. */
    public MyQueue() {
        input = new ArrayDeque<Integer>();
        output = new ArrayDeque<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(output.isEmpty()){
            while(!input.isEmpty())
                output.push(input.pop());
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(input.isEmpty() && output.isEmpty())
            return true;
        else
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
