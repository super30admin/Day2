// Time Complexity : o(1)
// Space Complexity : 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/*Approach: Always pop the element using second  stack.
while pop is called,

if stack 2 is empty, push the elements one by one form stack 1 to stack2 and delete 
element in stack 1 as soon as it is pushed.(happens for 1st pop action).


if stack2 has data directly pop the first element.similarly user the same appraoch for peek.
*/



class MyQueue {
public:
    /** Initialize your data structure here. */
    
    stack <int> stack1;
    stack <int> stack2; //create two stacks
    MyQueue() {
        
        
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        
        stack1.push(x); //use inbuild push function to just push the elements in stack1
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {  //pop will always be done using the second stack
        
        int x;
        if(!stack2.empty())   //approach mentioned above
        {
            x = stack2.top();
            stack2.pop();
            
        }
        else
        {
            while(!stack1.empty())
            {
            stack2.push(stack1.top());
            stack1.pop();
            }
            x = stack2.top();
            stack2.pop();
        }
        return x;
        
    }
    
    /** Get the front element. */
    int peek() {
        
        int x;
        if(!stack2.empty())
        {
            x = stack2.top();
            
        }
        else
        {
            while(!stack1.empty())
            {
            stack2.push(stack1.top());
            stack1.pop();
            }
            x = stack2.top();
        }
        return x;
        
    }
        
    
    
    /** Returns whether the queue is empty. */
    bool empty() {
        
        return (stack1.empty() && stack2.empty());
        
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