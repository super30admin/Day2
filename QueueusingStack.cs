public class MyQueue {

     private Stack<int> inStack;
    private Stack<int> outStack;

    public MyQueue() {
        inStack = new Stack<int>();
        outStack = new Stack<int>();
    }

    public void Push(int x) {
        inStack.Push(x);
    }

    public int Pop() {
        Peek(); // Ensure `outStack` is populated
        return outStack.Pop();
    }

    public int Peek() {
        if (outStack.Count == 0) {
            while (inStack.Count > 0) {
                outStack.Push(inStack.Pop());
            }
        }
        return outStack.Peek();
    }

    public bool Empty() {
        return inStack.Count == 0 && outStack.Count == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * int param_3 = obj.Peek();
 * bool param_4 = obj.Empty();
 */