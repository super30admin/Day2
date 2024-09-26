//Time Complexity: Push: O(1), Pop: Amortized O(1), Peek: Amortized O(1), Empty: O(1)
//Space Complexity: O(n)

import java.util.Stack;

class MyQueue
{
    Stack<Integer> firstStack;
    Stack<Integer> secondStack;
    public MyQueue()
    {
        firstStack = new Stack();
        secondStack = new Stack();
    }

    public void push(int x)
    {
        firstStack.push(x);
    }

    public int pop()
    {
        if(!secondStack.isEmpty())
            return secondStack.pop();
        else
        {
            while(!firstStack.isEmpty())
                secondStack.push(firstStack.pop());
            return secondStack.pop();
        }
    }

    public int peek()
    {
        if(!secondStack.isEmpty())
            return secondStack.peek();
        else
        {
            while(!firstStack.isEmpty())
                secondStack.push(firstStack.pop());
            return secondStack.peek(); 
        }
    }

    public boolean empty()
    {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
}