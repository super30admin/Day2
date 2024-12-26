import java.util.Stack;

class MyQueueSolution2 {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueueSolution2() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        int element = out.pop();
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        return element;
    }

    public int peek() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        int element = out.peek();
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        return element;
    }

    public boolean empty() {
        return (in.isEmpty() && out.isEmpty());
    }
}

/*
TimeComplexity : For Push operations: O(1)
                 For Pop operations: O(N + N) -> For all the  Case 
                 
*/


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */