// Time Complexity : Push() is done in 0(1) whereas pop and peek are in 0(n). I am not sure But this is just my understanding. Correct me if I am wrong.
// Space Complexity : 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None except for calclulating time and space complexities


// Your code here along with comments explaining your approach
/* 3 point approach to my problem is the following -
	1. Push happens into the first stack and the top of this stack serves as the back of the queue.
	2. To pop, we need to get the element at the other end of the stack. So I push elements from stack1 to stack2 so that the order is reversed  in s2. Then I can pop out of s2.
	3. To get the top element, if s2 is not empty, I can get top directly. Else, I will push elements from s1 to s2 again by popping off s1. Once done, I can retrieve top of s2.

class MyQueue {
public:
    stack<int>s1;
    stack<int>s2;
    /** Initialize your data structure here.*/
    MyQueue() {
    }
   
        
    /** Push element x to the back of queue. */
    void push(int x) {
        s1.push(x);   
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        if(empty()==1)
            return -1;
        else
        {
            if(s2.empty())
            {
                while(!s1.empty())
                {
                    s2.push(s1.top());
                    s1.pop();
                }
            }
            int a=s2.top();
            s2.pop();
            return a;
        }
    }
    
    /** Get the front element. */
    int peek() {
        if(empty()==1)
            return -1;
        else if(!s2.empty())
            return s2.top();
        else
        {
            while(!s1.empty())
            {
                s2.push(s1.top());
                s1.pop();
            }
            return s2.top();
        }
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        if(s1.empty() && s2.empty())
            return 1;
        else
            return 0;
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