// Time Complexity :all operations T(n) = O(n) ==> push,peek,pop  ; T(n)=O(1) ==> empty
// Space Complexity :S(n)=O(n)
// Did this code successfully run on Leetcode :yes

// used two stacks 

class MyQueue {
public:
    /** Initialize your data structure here. */

    MyQueue() {


    }
    stack<int> st1;
    stack<int> st2;
    /** Push element x to the back of queue. */
    void push(int x) 
    {
        if(st1.empty() && st2.empty()) 
        {
            st1.push(x);
            return;
        }
        else if(st1.empty() && !st2.empty())
        {
            while(!st2.empty())
            {
                int temp=st2.top();
                st1.push(temp);
                st2.pop();
            }
            st1.push(x);
            return;
        }
        else if(!st1.empty())
        {
            st1.push(x);
        }
        return;
    }

    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        if (!st2.empty()) 
        {
            int temp= st2.top();
            st2.pop();
            return temp;
        }
        else if(!st1.empty() && st2.empty())
        {
            while(!st1.empty())
            {
                int temp=st1.top();
                st1.pop();
                st2.push(temp);
            }
            int temp1=st2.top();
            st2.pop();
            return temp1;
        }
        return -9999;
    }

    /** Get the front element. */
    int peek() {

        if (!st2.empty()) 
        {
            return st2.top();
        }
        else if(!st1.empty() && st2.empty())
        {
            while(!st1.empty())
            {
                int temp=st1.top();
                st1.pop();
                st2.push(temp);
            }
            return st2.top();


        }
        return 0;

    }

    /** Returns whether the queue is empty. */
    bool empty() {
        return  st1.empty() && st2.empty();
    }
};
