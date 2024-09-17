/**
 Time Complexity of all the operation is O(1)
 for pop() it will be amortized o(1) because at one point of time code will stop coping over values from in to out array

 Space complexity is o(n) as we are using to stacks

 Approach: So here in array will always add the element when push and pop operation will see if there is already some elements in out stack if not we pop i.e LIFO from in array to out arrray so we get first elemnet added as queue is FIFO
 */
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.add(x);
    }

    public int pop() {
        peek();

        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        return out.peek();
    }


    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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