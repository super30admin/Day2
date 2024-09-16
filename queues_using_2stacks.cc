// Time Complexity : O(1) - push - O(1), pop - average O(1), worst case O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class MyQueue {
public:
    /** Initialize your data structure here. */
    std::stack<int>* pushStack;
    std::stack<int>* popStack;
    MyQueue() {
        pushStack = new std::stack<int>();
        popStack = new std::stack<int>();
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        pushStack->push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int top = peek();
        popStack->pop();
        return top;
    }
    
    /** Get the front element. */
    int peek() {
        if(popStack->empty()){
            while(!pushStack->empty()){
                int top = pushStack->top();
                popStack->push(top);
                pushStack->pop();
            }
        }
        int top = popStack->top();
        return top;
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return pushStack->empty() && popStack->empty();
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
