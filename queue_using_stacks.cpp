//Time complexity: Average case O(1) for pop and peek with worst case for pop being O(n)
//Space complexity: O(n) where n is the number of elements in the queue
//Code executed successfully in leetcode
//Approach:

//First stack is used for storing elements. Second stack out collects all elements if a pop is there. If out is null that means all pops are done. 


class MyQueue {
private: 
    stack<int> element;
    stack<int> out; 
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        element.push(x);
    }
    
    int pop() {
        if(out.empty()){
            while(!element.empty()){
                out.push(element.top());
                element.pop();
            }
        }
        int front = out.top();
        out.pop();
        return front;
    }
    
    int peek() {
        if(out.empty()){
            while(!element.empty()){
                out.push(element.top());
                element.pop();
            }
        }
        return out.top();
    }
    
    bool empty() {
        return out.empty() && element.empty();
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