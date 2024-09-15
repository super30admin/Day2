#include <stack>
using namespace std;


// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyQueue {
public:
    stack<int> *main_stack;
    stack<int> *pop_stack;
    MyQueue() {
        main_stack = new stack<int>();
        pop_stack = new stack<int>();
    }
    
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    void push(int x) {
        main_stack->push(x);
    }
    
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    int pop() {
        if(pop_stack->empty())
        {
            while(!main_stack->empty())
            {
                int temp = main_stack->top();
                main_stack->pop();
                pop_stack->push(temp);
            }
        }
        
        int retVal = pop_stack->top();
        pop_stack->pop();
        return retVal;
    }
    
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    int peek() {
        if(pop_stack->empty())
        {
            while(!main_stack->empty())
            {
                int temp = main_stack->top();
                main_stack->pop();
                pop_stack->push(temp);
            }
        }
        
        return pop_stack->top();
    }
    
    // Time Complexity : O(1)
    // Space Complexity : O(n)
    bool empty() {
        return main_stack->empty() && pop_stack->empty();   
    }
};

int main()
{
    MyQueue mq;
}