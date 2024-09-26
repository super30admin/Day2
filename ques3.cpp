Time Complexity-O(n)
Space Complexity-O(n)
Did the code run successfully on Leetcode?yes

#include <iostream>
#include<stack>
using namespace std;

class MyQueue {
public:
    stack<int>m;
    stack<int>k;
    /** Initialize your data structure here. */
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        m.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
       if(k.empty())
       {
           while(!m.empty())
           {
               k.push(m.top());
               m.pop();
           }
       }
        int i=k.top();
        k.pop();
        cout<<i;
        cout<<"\n";
    }
    
    /** Get the front element. */
    int peek() {
        if(k.empty())
       {
           while(!m.empty())
           {
               k.push(m.top());
               m.pop();
           }
       }
        cout<<k.top();
        cout<<"\n";
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        if(m.empty() && k.empty())
            cout<<true;
        else
            cout<<false;
    }
};

int main() {
	MyQueue obj;
	obj.push(1);
    obj.push(2);  
    obj.peek();  // returns 1
    obj.pop();   // returns 1
    obj.empty(); // returns false
	return 0;
}