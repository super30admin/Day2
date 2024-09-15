// Time Complexity : O(1)

// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Use two stacks
//first one to push and
//second one to pop elements
//Reverse the list from first stack into second stack: to pop elements in fifo manner

class MyQueue {
public:
    //Aim is to queues using stack
    
    stack <int> fisrt_push_elements_stack;
    stack <int> second_pop_elements_stack;
    
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        fisrt_push_elements_stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        if(second_pop_elements_stack.empty()){
            while(!fisrt_push_elements_stack.empty()){
                second_pop_elements_stack.push(fisrt_push_elements_stack.top());
                fisrt_push_elements_stack.pop();
            }
        }
        int item = second_pop_elements_stack.top();
        second_pop_elements_stack.pop();
        return item;
        }

    
    /** Get the front element. */
    int peek() {
        if(second_pop_elements_stack.empty()){
            while(!fisrt_push_elements_stack.empty()){
                second_pop_elements_stack.push(fisrt_push_elements_stack.top());
                fisrt_push_elements_stack.pop();
            }
        }
        return second_pop_elements_stack.top();;
        }

    
    /** Returns whether the queue is empty. */
    bool empty() {
        if(fisrt_push_elements_stack.empty() && second_pop_elements_stack.empty()){
            return true;
        }
        return false;
    }
};

