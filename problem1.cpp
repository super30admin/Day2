// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MyQueue
{
public:
    stack<int> in;
    stack<int> out;
    MyQueue()
    {
    }

    void push(int x)
    {
        in.push(x);
    }

    int pop()
    {
        // delete element by maintaing the relative order
        peek();
        int res = out.top();
        out.pop();
        return res;
    }

    int peek()
    {
        // return value if exists in the stack with data stored in relative order
        if (!out.empty())
        {
            return out.top();
        }
        else
        {
            while (!in.empty())
            {
                out.push(in.top());
                in.pop();
            }
        }
        return out.top();
    }

    bool empty()
    {
        // return value if no elements exists in any of the stack
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