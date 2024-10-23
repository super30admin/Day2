// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no
class MyQueue {
public:
      //
     stack<int>ip;  // main stack
     stack<int>op;   // helps to reverse the order
    MyQueue() {
        
    }
    //stack LIFO
      //queue FIFO
    void push(int x) {
       
        while(!ip.empty()){
            op.push(ip.top());
            ip.pop();
        } 
        ip.push(x);

         while(!op.empty()){
            ip.push(op.top());
            op.pop();
        }
    }
    
    int pop() {
        if(ip.empty()) return -1;
      int ans=ip.top();
           ip.pop();
         return  ans;
    }
    
    int peek() {
        return ip.top();
    }
    
    bool empty() {
        return ip.empty();
    }
};
