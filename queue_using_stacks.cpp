// Time Complexity : push - O(1); pop - O(n) Amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Used two stacks to do the queue operation. InStack stores all the elements incoming. 
// OutStack is used for accessing elements in FIFO style and hence used in pop/peek operations.
// Whenever I want to pop an element, I will see if outStack has elements already present. if yes 
// then I will get the top value from there. If outStack is empty, I will transfer all the elements
// to it such that my first elements sits at the top of the stack. 

#include <stack>

class MyQueue {
private:
    // Stacks for queue operation.
    std::stack<int> inStack;
    std::stack<int> outStack;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        inStack.push(x);
        return;
    }
    
    int pop() {
        peek();
        int topVal = outStack.top();
        outStack.pop();
        return topVal;
    }
    
    int peek() {
        if(outStack.empty())
        {
            while(!inStack.empty())
            {
                int topVal = inStack.top();
                inStack.pop();
                outStack.push(topVal);
            }
        }
        return outStack.top();
    }
    
    bool empty() {
        return (inStack.empty() && outStack.empty());
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */