/*
********************Time complexity******************
Push()      - O(1)
Pop()       - O(N)
Peek()      - O(N)
empty()     - O(1)
********************Space complexity*****************
O(N)
*****************************************************
*/
class MyQueue {
    stack<int> s1, s2;
public:
    /** Initialize your data structure here. */
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int val, temp;
        while (!s1.empty()){
            val = s1.top(); s1.pop();
            s2.push(val);
        }
        s2.pop();
        while (!s2.empty()){
            temp = s2.top(); s2.pop();
            s1.push(temp);
        }
        return val;
    }
    
    /** Get the front element. */
    int peek() {
        int val, temp;
        while (!s1.empty()){
            val = s1.top(); s1.pop();
            s2.push(val);
        }
        while (!s2.empty()){
            temp = s2.top(); s2.pop();
            s1.push(temp);
        }
        return val;
        
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return (s1.empty());
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

