// Implement Queue using Stacks
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Approach
// Create 2 stacks; in stack & out stack. All push happens in in stack.
// When a pop happens, transfer all elements from in stack to out stack and then pop the element.
// In some cases, when the out stack is empty and we need to do pop, then again push all the elements from in to out stack if in stack is not empty.

// TC: push = O(1), pop = O(n), peek = O(n), empty = O(1)
// SC: O(n)
// we will be pushing the elements in one of the two stacks and will be using the other stack to pop
class MyQueue {
private:
    stack<int> in;
    stack<int> out;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        in.push(x);
    }
    
    int pop() {
        int popped = peek();
        out.pop();
        return popped;
    }
    
    int peek() {
        if(out.empty()) {
            while(!in.empty()) {
                out.push(in.top());
                in.pop();
            }
        }
        return out.top();
    }
    
    bool empty() {
        return in.empty() && out.empty();
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