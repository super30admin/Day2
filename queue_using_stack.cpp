/*
Time Complexity :
push ->O(1)
pop -> O(n)
peek -> O(1)
empty -> O(1)

Space Complexity :
push ->O(n)
pop -> O(n)
peek ->O(1)
empty ->O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NO

logic: 
whenever we are pushing we can push to the stack but when we are popping we move all the elements from stack 1 to stack2
so that they are in the reverse order as required by the queue pop function.
Inititally Peek function was same as Pop but then later I found out that it could be made efficient(O(1)TC) using a front variable for
stack 1; 

*/

class MyQueue {
private: 
    stack<int>st1;
    stack<int>st2;
    int front;
public:
    /** Initialize your data structure here. */
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        if(st1.empty())front = x;
        st1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        if(st2.empty()){
            while(!st1.empty()){
                st2.push(st1.top());st1.pop();
            }
        }
        int result = st2.top();st2.pop();
        return result;
        
    }
    
    /** Get the front element. */
    int peek() {
        if(!st2.empty())return st2.top();
        if(!st1.empty())return front;
        else return -1;
        
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        if(st1.empty()&&st2.empty())return true;
        else return false;
        
        
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

