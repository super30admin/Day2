class MyQueue {
public:
    /** Initialize your data structure here. */
    MyQueue() {
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        while(!myQueue.empty()){
            myStack.push(myQueue.top());
            myQueue.pop();
        }
        myQueue.push(x);
        while(!myStack.empty()){
            myQueue.push(myStack.top());
            myStack.pop();
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int top = myQueue.top();
        myQueue.pop();
        return top;
    }
    
    /** Get the front element. */
    int peek() {
        return myQueue.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        if(myQueue.empty()){
            return true;
        }
        else{
            return false;
        }
    }
    
    private:
        std::stack<int> myStack;
        std::stack<int> myQueue; 
};