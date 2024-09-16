// Approach : Use two stacks
// push to first one
// when popping or peeking put the elements to second stack to reverse the order and make them FIFO

public class MyQueue {
    
    Stack<int> inStack, outStack;

    public MyQueue() {
        inStack = new Stack<int>();
        outStack = new Stack<int>();
    }
    
    private void transferIfNeeded(){
        if(outStack.Count == 0){
            while(inStack.Count !=0)
                outStack.Push(inStack.Pop());
        }
    }
    
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public void Push(int x) {
        inStack.Push(x);
    }
    
    // Amortized Time Complexity: O(1)
    // Space Complexity: O(1)
    public int Pop() {
        transferIfNeeded();
        return outStack.Pop();
    }
    
    // Amortized Time Complexity: O(1)
    // Space Complexity: O(1)
    public int Peek() {
        transferIfNeeded();
        return outStack.Peek();
    }
    
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public bool Empty() {
        return inStack.Count==0 && outStack.Count==0;
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