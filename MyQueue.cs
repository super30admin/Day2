public class MyQueue
{

    Stack<int> stack, tempStack;
    int peek;
    public MyQueue()
    {
        stack = new Stack<int>();
        tempStack = new Stack<int>();
        peek = Int32.MaxValue;
    }

    public void Push(int x)
    {
        if (stack.Count() == 0)
        {
            peek = x;
        }
        stack.Push(x);
    }

    public int Pop()
    {
        while (stack.Count() > 0)
        {
            tempStack.Push(stack.Pop());
        }
        var popped = tempStack.Pop();
        peek = tempStack.Count() > 0 ? tempStack.Peek() : Int32.MaxValue;
        while (tempStack.Count() > 0)
        {
            stack.Push(tempStack.Pop());
        }
        return popped;
    }

    public int Peek()
    {
        return peek;
    }

    public bool Empty()
    {
        return stack.Count() == 0;
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