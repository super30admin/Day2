// Time Complexity : O(1) for push, pop, getMin, top
// Space Complexity : O(1) as I am just storing an extra integer for each element of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class MinStack {
    // Node class to store in the stack
    class Node{
        public:
            int val;
            int minVal;
        
            Node(int v, int m){
                val = v;
                minVal = m;
            }
    };
    
    // Created a stack which stores the nodes
    stack<Node> minStack;
public:
    /** initialize your data structure here. */
    MinStack() {
        
    }
    
    /* Push the node to the stack along with the current minimum. 
       If the value adding to the stack is less than current minimum(get that from top node) create the node with val and min also as val
       Else get the min from the top node and push the val along with min
    */
    void push(int val) {
        if(minStack.empty()){
            minStack.push(Node(val, val));
        }
        else{
            Node top = minStack.top();
            int temp;
            
            if(val < top.minVal){
                temp = val;
            }
            else{
                temp = top.minVal;
            }
            
            minStack.push(Node(val, temp));
        }
    }
    
    // Pop the top node from stack
    void pop() {
        minStack.pop();
    }
    
    // Return the top val
    int top() {
        return minStack.top().val;
    }
    
    // Return the current min from the top node
    int getMin() {
        return minStack.top().minVal;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */