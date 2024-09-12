// Time Complexity - push(), pop(), peek(), empty() are O(1) since I am using empty(), push() and pop() operations on stack which are O(1).
// Space COmplexity - Space complexity is O(N) since the space taken by our queue depends on the number of elements being pushed into the queue.
// Problems Faced - No!
// It runs on leetcode.

class MyQueue {
public:
    stack<int> stack1;
    stack<int> stack2;
    MyQueue() {
        
    }
    
    void push(int x) {
        stack1.push(x);
    }
    
    int pop() {
        int x = -1;
        if(stack2.empty()){
            if(stack1.empty()){
                cout<<"Queue is Empty!";
                return x;   
            }
            else{
                while(!stack1.empty()){     
                    int y = stack1.top();
                    stack1.pop();
                    stack2.push(y);
                }
            }
        }
                x = stack2.top();
                stack2.pop();
                return x;
        }
    
    int peek() {
        int x = -1;
        if(stack2.empty()){
            if(stack1.empty())
                return x;
            else{
                while(!stack1.empty()){
                    int y = stack1.top();
                    stack1.pop();
                    stack2.push(y);
                }
            }
        }
        return stack2.top();
    }
    
    bool empty() {
        if(stack2.empty()){
            if(stack1.empty())
                return true;
            else
                return false;
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
