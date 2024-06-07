import java.util.Stack;

//Time - O(1) for push, empty. O(1) - avg i.e amortized time but O(n) in worst case
//Space - O(n) number of pushes
class ImplementQueueUsingStacks {

    Stack<Integer> in, out;
    public ImplementQueueUsingStacks() {
        in = new Stack();
        out = new Stack();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                int val = in.pop();
                out.push(val);
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
