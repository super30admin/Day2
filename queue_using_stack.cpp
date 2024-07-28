// Time Complexity : Push and empty are O(1). Pop and Peek are amortized O(n)
// Space Complexity : O(n) for stacks storing N elements at a time.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


// Your code here along with comments explaining your approach

/*
1. We maintain 2 stacks. One stack is for pushing the elements for every push operation and another for pop and peek operations 
2. Whenever we get a push command, we'll push the element to stack 1
3. Whenever we receive a pop command, we check if stack2 has any elements in it. If yes, return the top element of stack2.
4. If stack2 is empty, move all elements from stack1 to stack2 until stack1 is empty. then return top elelemt of stack2. 
*/

class MyQueue {
public:
    MyQueue() {}
    
    void push(int x) {
        stack1.push(x);
    }
    
    // trasnfer items from stack1 to stack2
    void trasnferStacks(stack<int>& stack1, stack<int>& stack2)
    {
        while(stack1.empty() == false)
            {
                stack2.push(stack1.top());
                stack1.pop();
            }
    }

    int pop() {
        int top_element_of_queue = peek();
        stack2.pop();
        return top_element_of_queue;
    }
    
    int peek() {
        if(stack2.empty() == true)
        {
            trasnferStacks(stack1, stack2);
        }

        return stack2.top(); // peek will aways be valid as per requirements
    }
    
    bool empty() {
        return(stack1.empty() && stack2.empty());
    }

private:
    std::stack<int> stack1; // stack used for pushing the items
    std::stack<int> stack2; // stack used for popping the items
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */