// Amortized Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Use two stacks, one for push operation and other for pop and peek operation.
 * For push operation : Push element in "in stack".
 * For pop and peek operation : If "out stack" is empty then move all the elements of in stack in out stack and return the top element of out stack.
 */

class MyQueue {
public:
    
    stack<int> in;
    stack<int> out;
    
    MyQueue() {

    }
    
    void push(int x) {
        in.push(x);
    }
    
    int pop() {
        int a = peek();
        out.pop();
        return a;
    }
    
    int peek() {
        int a;
        if (out.empty())
        {
            while (!in.empty())
            {
                a = in.top();
                in.pop();
                out.push(a);
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