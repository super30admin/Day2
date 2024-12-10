/*
    Leecode Problem 232: Implement Queue using Stacks
    T.C push(): O(1), T.C pop() & peek(): O(1) Amortized - O(n) Worst case, T.C empty(): O(1)
    S.C: O(n) - two stacks i.e O(n) + O(n) = O(2n) - 2 is constant

    Solved using 2 Stacks: refer comments for Impl.
*/

class MyQueue {
    //Declare the 2 stacks to perform queue operations
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        //Initialize the stacks in the constructor
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        //Directly push to in stack
        in.push(x);
    }
    
    public int pop() {
        //Check is out stack is empty, if yes transfer all the elements 
        //from in stack to out, then pop elements one by one.
        //Else pop directly from out stack.
        peek();
        return out.pop();
    }
    
    public int peek() {
        if (!out.isEmpty()) {
            return out.peek();
        } else {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        return out.peek();
    }
    
    public boolean empty() {
        //Check if both the stacks are empty and return the truth value
        if (out.isEmpty() && in.isEmpty()) {
            return true;
        }

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