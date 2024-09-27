#include <stack>
#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class MyQueue {
    stack<int> pushStack;
    stack<int> popStack;

public:
    /** Initialize your data structure here. */
    MyQueue() {}
    
    /** Push element x to the back of queue. */
    void push(int x)
    {
        pushStack.push(x);   
    }
    
    void flipOver()
    {
        if (!popStack.empty()) {
            return;
        }

        while (!pushStack.empty()) {
            popStack.push(pushStack.top());
            pushStack.pop();
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop()
    {
        if (empty()) {
            return -1;
        }

        flipOver();
        int top = popStack.top();
        popStack.pop();
        return top;
    }
    
    /** Get the front element. */
    int peek()
    {
        if (empty()) {
            return -1;
        }
    
        flipOver();
        return popStack.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty()
    {
        return (pushStack.empty() && popStack.empty());
    }
};


int main ()
{
    MyQueue q;

    q.push(3);
    q.push(4);
    q.push(5);
    q.push(6);
   
    cout << "Front = " << q.peek() << endl; 
    cout << "Front = " << q.pop() << endl; 
    q.push(7);
    cout << "Front = " << q.peek() << endl; 
    cout << "Empty? " << q.empty() << endl; 
    q.push(9);
    cout << "Front = " << q.pop() << endl; 
    cout << "Front = " << q.pop() << endl; 
    cout << "Front = " << q.pop() << endl; 
    cout << "Front = " << q.pop() << endl; 
    cout << "Front = " << q.pop() << endl; 
    cout << "Front = " << q.pop() << endl; 
    cout << "Front = " << q.pop() << endl; 
}
