// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Implement Queue using Stacks
// Approach: 2 Stacks
// Time Complexity:
//      Push: O(1)
//      Pop: Average - O(1), Worst Case - O(n)
//      Peek: Average - O(1), Worst Case - O(n)

class MyQueue
{

private:
    stack<int> inStack;
    stack<int> outStack;

public:
    MyQueue() {}

    void push(int x) { inStack.push(x); }

    void getArranged()
    {
        // Case to check if inStack array contains value and followed by outStack has nothing present
        if (!inStack.empty() && outStack.empty())
        {
            // Loop around inStack and push values to outStack as they will be rearranged in outStack and ready to peek or pop
            while (!inStack.empty())
            {
                int inStackTop = inStack.top();
                outStack.push(inStackTop);
                inStack.pop();
            }
        }
    }

    int pop()
    {
        // Check if outStack contain values and pop if it's not empty
        if (!outStack.empty())
        {
            int outStackTop = outStack.top();
            outStack.pop();
            return outStackTop;
        }
        else
        {
            // If outStack is empty transfer values from inStack to outStack
            getArranged();
        }

        // Once values are present, pop from the outStack
        int outStackTop = outStack.top();
        outStack.pop();
        return outStackTop;
    }

    int peek()
    {

        // Similar to pop, just that we do not pop instead just return the top of outStack

        if (!outStack.empty())
        {
            return outStack.top();
        }
        else
        {
            getArranged();
        }

        int outStackTop = outStack.top();
        return outStackTop;
    }

    bool empty() { return inStack.empty() & outStack.empty(); }
};
