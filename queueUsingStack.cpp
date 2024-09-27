//Time Complexity - Amortised O(1)
// Space Complexity - O(n)


#include <iostream>
#include<stack>
using namespace std;

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
        if(out.empty())
        {
            while(!in.empty())
            {
                int topElement=in.top();
                in.pop();
                out.push(topElement);
            }
        }
        int returnElement=out.top();
        out.pop();
        return returnElement;
    }
    
    int peek() {
        if(out.empty())
        {
            while(!in.empty())
            {
                int topElement=in.top();
                in.pop();
                out.push(topElement);
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