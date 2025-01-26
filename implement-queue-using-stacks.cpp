/*The queue is implemented using two stacks (s1 and s2).
For push, elements are added to s1.
For pop and peek, elements are transferred from s1 to s2 if s2 is empty, allowing us to perform the front operation efficiently.

Time Complexity:
push: O(1)
pop:  O(1) 
peek:  O(1) 
empty: O(1)

Space Complexity: O(n)*/
#include<bits/stdc++.h>
using namespace std;
class MyQueue {
    stack<int> s1;
    stack<int> s2;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        s1.push(x);
    }
    
    int pop(void) {
        if(!s2.empty()){
            int val =s2.top();
            s2.pop();
            return val;
        }else{
            while(!s1.empty()){
                s2.push(s1.top());
                s1.pop();
            }
            int val=s2.top();
            s2.pop();
            return val;
        }
    }
    
    int peek(void) {
        if(!s2.empty()){
            return s2.top();
        }else{
            while(!s1.empty()){
                s2.push(s1.top());
                s1.pop();
            }
            return s2.top();
        }
    }
    
    bool empty(void) {
        if(s1.empty() && s2.empty()){
            return true;
        }else{
            return false;
        }
    }
};