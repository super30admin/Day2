//Space Complexity- O(n)

class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int> st1;
    stack<int> st2;
    MyQueue() {
        
    }
    
    //Time Complexity- O(1)
    /** Push element x to the back of queue. */
    void push(int x) {
        st1.push(x);
    }
    
    //Time Complexity- O(n) worst case
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        while(!st1.empty()){
            st2.push(st1.top());
            st1.pop();
        }
        int ans=st2.top();
        st2.pop();
        while(!st2.empty()){
            st1.push(st2.top());
            st2.pop();
        }
        return ans;
    }
    
    //Time Complexity- O(n) worst case
    /** Get the front element. */
    int peek() {
        while(!st1.empty()){
            st2.push(st1.top());
            st1.pop();
        }
        int ans=st2.top();
        while(!st2.empty()){
            st1.push(st2.top());
            st2.pop();
        }
        return ans;
    }
    
    //Time Complexity- O(1)
    /** Returns whether the queue is empty. */
    bool empty() {
        return st1.empty();
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