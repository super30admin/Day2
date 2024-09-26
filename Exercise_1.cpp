// Time Complexity                                  : Push - O(1), 
//                                                    Pop - Asymtotic O(1), 
//                                                    Peek - Asymtotic O(1), 
//                                                    Empty - O(1) 
//
// Space Complexity                                 : O(2*N) = O(N)
// Did this code successfully run on Leetcode       : Yes.
// Any problem you faced while coding this          : No.
#include <bits/stdc++.h>
using namespace std;

class MyQueue {
private:
    stack<int> st1;
    stack<int> st2;
    void transfer() {
        while(!st1.empty()) {
            st2.push(st1.top());
            st1.pop();
        }
    }
public:
    MyQueue() {
        while(!st1.empty()) {
            st1.pop();
        }

        while(!st2.empty()) {
            st2.pop();
        }
    }
    
    void push(int x) {
        st1.push(x);
    }
    
    int pop() {
        
       if(st2.empty()) {
           if(!st1.empty()) {
               transfer();
           } else {
               return -1;
           }
       }
        int tp = st2.top();
        st2.pop();
        return tp;
        
    }
    
    int peek() {
        
        if(st2.empty()) {
          if(!st1.empty()) {
             transfer();
          } else {
             return -1;
          }
       }
        
        int tp = st2.top();
        return tp;
    }
    
    bool empty() {
        if(st1.empty() and st2.empty()) return true;
        return false;
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