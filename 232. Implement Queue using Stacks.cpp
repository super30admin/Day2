// Time Complexity :PUSH-O(N),POP-O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class MyQueue {
public:
    stack<int> st1;
    stack<int> st2;
    MyQueue() {
        
    }
    
    void push(int x) {
        st2.push(x);
        while(!st1.empty()){
            st2.push(st1.top());
            st1.pop();
        }
        swap(st1,st2);
    }
    
    int pop() {
        int y=st1.top();
        st1.pop();
        return y;
    }
    
    int peek() {
        int x=st1.top();
        return x;
    }
    
    bool empty() {
        return st1.empty();
    }
};