// Time Complexity :
                    //pop O(n)
                    //push O(1)
                    //peek O(n)
                    //empty O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int> stk1,stk2; // 2 stack approach
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        if(stk2.empty()) { //if there is no element in the stack 2 then push the element in the stack 1
            stk1.push(x);
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {  
        //transfer the contents of the first stack in the second stack 
        while(!stk1.empty()) {
            stk2.push(stk1.top());
            stk1.pop();
        }
        //store the top element in the variable and pop this top element in the stack
        int x=stk2.top();
        stk2.pop();
        //transfer the elements of this second stack back to the first element
        while(!stk2.empty()){
            stk1.push(stk2.top());
            stk2.pop();
        }
        return x;
    }
    
    /** Get the front element. */
    int peek() {
        //transfer the elements of the first stack to the second stack 
         while(!stk1.empty()) {
            stk2.push(stk1.top());
            stk1.pop();
        }
        // store the first element in the variable
        int x=stk2.top();
        //transfer the elements from the second stack to the first stack
        while(!stk2.empty()){
            stk1.push(stk2.top());
            stk2.pop();
        }
        return x;
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        //check if both the stacks are empty or not 
        if(stk1.empty() && stk2.empty())
            return true;
        return false;
    }
};
