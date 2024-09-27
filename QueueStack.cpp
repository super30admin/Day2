// Time Complexity : O(log(m*n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

#include <iostream>
#include <stack>

using namespace std;
class MyQueue {
public:
    stack<int> in;
    stack<int> out;
    
    /** Push element x to the back of queue. */
    void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int s = peek();
        out.pop();
        return s;
    }
    
    /** Get the front element. */
    int peek() {
        if(out.empty()){
            while(!in.empty()){
                out.push(in.top());
                in.pop();
            }
        }
        return out.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return (in.empty() && out.empty());
    }
};

int main(){
    MyQueue myQueue;
    myQueue.push(1);
    myQueue.push(2);
    myQueue.peek();
    myQueue.pop();
    myQueue.empty();
    return 0;
}
