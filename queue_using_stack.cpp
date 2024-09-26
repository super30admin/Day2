// Time Complexity :  Push O(1), Pop O(n), Peek O(1), Empty O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes. 
// Any problem you faced while coding this : There can be a better method for solving it than transferring data between stacks.

class MyQueue {
private:
    //Primary Stack to Hold the Queue
    stack<int> pStack;

    //Secondary Stack to Temporarily Hold Data
    stack<int> sStack;
    
    //Element to keep track of front element
    int front;

    //Length of the Queue
    int len;
    
public:
    /** Initialize your data structure here. */
    MyQueue() {
        //Default -1 value of front element
        front = -1;
        //Initial length 0
        len = 0;
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        
        //Empty queue condition
        if(len == 0)
        {
            front = x;
        }
        
        pStack.push(x);
        len++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        
        int val = -1;
        int i;

        //Transfer all but 1 elements to Secondary Stack    
        for(i = 0; i < len-1; i++)
        {
            sStack.push(pStack.top());
            pStack.pop();
        }
        
        //Pop the First entered element
        val = pStack.top();
        pStack.pop();
        
        //Push the elements back in the Primary Stack
        for(i = 0; i < len-1; i++)
        {
            if(i == 0)
            {
                front = sStack.top();
            }
            
            pStack.push(sStack.top());
            sStack.pop();
        }
        
        len--;

        //Empty Queue condition   
        if(len == 0)
        {
            front = -1;
        }
        
        return val;
    }
    
    /** Get the front element. */
    int peek() {

        //First element bieng tracked    
        return front;
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {

        return pStack.empty();
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