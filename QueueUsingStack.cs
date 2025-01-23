// Time Complexity : push - O(1), pop - amortized O(1)
// Space Complexity : O(n) where n is count of elements
// Did this code successfully run on Leetcode : yes
// Approach  : 
// took two stacks in and out. When we push it will push to in stack. and
//when pop happens, if the out stack is empty we push elements from in to out and pop element from out stack.

public class MyQueue {
    public Stack<int> inStack;
    public Stack<int> outStack;

    public MyQueue() {
        this.inStack = new Stack<int>();
        this.outStack = new Stack<int>();
    }
    
    public void Push(int x) {
        this.inStack.Push(x);
    }
    
    public int Pop() {
        if(this.outStack.Count()==0)
        {
            while(this.inStack.Count!=0)
            {
                int popped = this.inStack.Pop();
                this.outStack.Push(popped);
            }
        }
        return this.outStack.Pop();
    }
    
    public int Peek() {
        if(outStack.Count()==0)
        {
            while(inStack.Count!=0)
            {
                int popped = this.inStack.Pop();
                this.outStack.Push(popped);
            }
        }
        return outStack.Peek();
    }
    
    public bool Empty() {
        return inStack.Count()==0 && outStack.Count()==0;
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