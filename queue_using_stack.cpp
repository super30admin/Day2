// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class MyQueue {
public:
    MyQueue() {
        
    }
    stack<int> inStk;
    stack<int> outStk;

    void push(int x) {
        //just push in in stack
        inStk.push(x);
    }
    
    int pop() {
        if(outStk.empty()) {
         //if out stack is empty we need to fetch elems in it from instk
          while(!inStk.empty()) {
             outStk.push(inStk.top());
             inStk.pop();
          }
        }
        int temp = outStk.top();
        outStk.pop();
        return temp;
        
    }
    
    int peek() {
        if(outStk.empty()) {
         //if out stack is empty we need to fetch elems in it from instk
         while(!inStk.empty()) {
            outStk.push(inStk.top());
            inStk.pop();
         }
        }
        return outStk.top();
        
    }
    
    bool empty() {
        if(inStk.empty() && outStk.empty()) {
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
