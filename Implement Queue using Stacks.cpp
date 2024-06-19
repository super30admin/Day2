// Approach: (took help from the sol) we will have 2 stacks - one for pushing elements and one for when pop is called. we will push everything to s1 and maintain a front var for the first element pushed. when pop is called, we will transfer all to s2 and pop the top element from s2 as that will be our front var. if s2 is not empty, we will directly pop from s2 because that means we have already popped atleast once in the past and hence the top of s2 will be our front. peek: either return front if s1 is not empty, else return top of s2. isEmpty(): if both s1 s2 are empty then true, else false.
// Time complexity: O(1) - amortized, worst O(n) for pop when we have to transfer all the elements
// Space complexity: O(n)

class MyQueue {
stack<int> s1, s2;
int front;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        if(s1.empty()) {
            front = x;
        }
        s1.push(x);
    }
    
    int pop() {
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.top());
                s1.pop();
            }
        }
        int popped = s2.top();
        s2.pop();
        return popped;
    }
    
    int peek() {
        if(s2.empty()) {
            return front;
        }
        return s2.top();
    }
    
    bool empty() {
        return s1.empty() && s2.empty();
    }
};