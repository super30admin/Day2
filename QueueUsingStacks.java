Time Complexity-push-O(1)
                pop-Average-O(1)
Space Complexity-O(n)

Leetcode Submission-Successful

class MyQueue {

    Stack<Integer> in = new Stack();
    Stack<Integer> out = new Stack();
    
    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty())
        {
            while (!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
       return out.pop();
    }

    public int peek() {
        if (out.isEmpty())
        {
            while (!in.isEmpty())
            {
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
