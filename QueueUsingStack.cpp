// Time Complexity : push O(1); pop O(n); peek O(1); empty O(1)
// Space Complexity :push O(n); pop O(n); peek O(1); empty O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Maintain a push_stack_ to push new elements (except first) and pop_stack_ which'll store only 1 element
// 2. While popping, return the only element in pop_stack_ and transfer the bottom element of push_stack_ to pop_stack_
// 3. empty checks if both stacks are empty and peek returns the element from pop_stack_ without removing it

class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int> push_stack_;
    stack<int> pop_stack_;
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        if(push_stack_.empty() && pop_stack_.empty())
            pop_stack_.push(x);
        else
            push_stack_.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        // value to return
        int val=pop_stack_.top();
        pop_stack_.pop();

        // transfer element from bottom of push_stack
        stack<int> temp_stack_;
        while(!push_stack_.empty()){
            int temp_el = push_stack_.top();
            push_stack_.pop();
            temp_stack_.push(temp_el);
        }
        if(!temp_stack_.empty()){
            int temp_el=temp_stack_.top();
            temp_stack_.pop();
            pop_stack_.push(temp_el);
        }
        while(!temp_stack_.empty()){
            int temp_el = temp_stack_.top();
            temp_stack_.pop();
            push_stack_.push(temp_el);
        }
        return val;
    }
    
    /** Get the front element. */
    int peek() {
        return pop_stack_.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return(push_stack_.empty() && pop_stack_.empty());
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