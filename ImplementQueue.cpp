// now before starting with the implementation queues we need to undetstand the key difference between them
// stack and queue so the queue works on the property of the first in and first out
// and stack, has property is the last in first out
// so we can use this property to store the values of the queue
class MyQueue {
public:
    stack<int>inStack;
    stack<int>outStack;
    MyQueue() {
        
    }
    
    void push(int x) {
        inStack.push(x);
    }
    
    int pop() {
    if(outStack.empty())
    {
        while(!inStack.empty())
        {
            int x = inStack.top();
            inStack.pop();
            outStack.push(x);
        }
    }
        int x = outStack.top();
        outStack.pop();
        return x;
    }
    
    int peek() {
        if(outStack.empty())
        {
            while(!inStack.empty())
            {
                int x = inStack.top();
                inStack.pop();
                outStack.push(x);
            }
        }
        return outStack.top();
    }
    
    bool empty() {
        return inStack.empty() && outStack.empty();
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