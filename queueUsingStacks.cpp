// Time Complexity : 
// 1. push(): O(1)
// 2. pop(): O(n) - n is the number of elements present in the stack
// 3. peek(): O(1)
// 4. empty(): O(1)
// Space Complexity : O(n) - n is the number of elements present in the stack

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyQueue {
    stack<int> s1;
    stack<int> s2;
    int front;
public:
    MyQueue() {
        
    }
    
    // if s1 is empty we assign the first element as top
    // we push it to stack 1
    void push(int x) {
        if (s1.empty()) {
            front = x;
        }

        s1.push(x);
    }
    
    // transfer elements from s1 to s2 and return the top element of s2
    int pop() {
        if (s2.empty()) {
            while(!s1.empty()) {
                int top = s1.top();
                s1.pop();
                s2.push(top);
            }
        }
        int top = s2.top();
        s2.pop();

        return top;
    }
    
    // if s2 is empty return front else return front.
    int peek() {
        if(!s2.empty()) {
            return s2.top();
        }

        return front;
    }
    
    // check both the stacks, if both of them are empy return true
    bool empty() {
        if (s1.empty() && s2.empty()) {
            return true;
        }

        return false;
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