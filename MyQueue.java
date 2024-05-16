/**
 * Approach: Using two stacks in and out,
 * in stack(enqueue) - pushing the values to the stack;
 * out stack(dequeue) - poping the value from the top of the stack
 *
 * Working:
 *      enqueue - same as regular stack push operation
 *      dequeue - pop the values from the in stack and push the values to the out stack,
 *                and return the top of the out stack, the copying of values is done in peek() operation
 *      peek - if the out stack is empty, pop the values form the in stack and push it to the out stack,
 *             and peek the out stack. this is done to ensure that the values in out stack are popped/ peeked
 *             in FIFO order of a queue. id out is not empty just peek the value from the out stack
 *
 * Time Complexity:
 *      - O(1) (push,empty)
 *      - O(1) Amortized (peek, pop) - this calculated when the average case < worst case (the occurs occasionally)
 *
 * Space Complexity: O(n), where n is the number of elements in the queue.
 *
 */


class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {

        in.push(x);

    }

    public int pop() {

        return peek() == -1?-1:out.pop();

    }

    public int peek() {
        if(out.empty()) {

            while(!in.empty()) {
                int poppedVal = in.pop();
                out.push(poppedVal);
            }
        }

        return out.peek();
    }

    public boolean empty() {

        return in.empty() && out.empty();
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