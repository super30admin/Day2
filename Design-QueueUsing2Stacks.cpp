// Time Complexity : O(1) for push and empty operations. amortized O(1) for peek and pop operations.
// Space Complexity : O(N) for storing data
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue 
{
    stack<int>s1;
    stack<int>s2;
public:
    MyQueue() 
    {
        
    }
    
    void push(int x) 
    {
            s1.push(x);
    }
    
    int pop() 
    {
        if(empty())
           return -1;
        
        if(!s2.empty())
        {
            int ele = s2.top();
            s2.pop();
            return ele;
        }
        
        while(!s1.empty())
        {
            int ele = s1.top();
            s1.pop();
            s2.push(ele);
        }
        
        int ele = s2.top();
        s2.pop();
        
        return ele;
     
    }
    
    int peek() 
    {
        if(empty())
            return -1;
        
        if(!s2.empty())
            return s2.top();
        
        while(!s1.empty())
        {
            int ele = s1.top();
            s1.pop();
            s2.push(ele);
        }
        return s2.top();
    }
    
    bool empty() 
    {
        return ( (s1.empty()) && (s2.empty()) );
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