// Time Complexity : push O(1) , pop - amortized O(1) might be O(n) in worst case. , peek amortized O(1) , might be O(n) in worst case, empty O(1)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE


// Your code here along with comments explaining your approach

class MyQueue {
    
   stack<int>pushstack;
   stack<int>popstack;
    
public:
    MyQueue() {

    }
    
    void push(int x) {
          pushstack.push( x ); 
    }
    
    int pop() {
       if( popstack.size() ){
          int elem = popstack.top();
          popstack.pop();
          return elem;
       }
       if( pushstack.size() ){
             while( pushstack.size() ){
                  int elem = pushstack.top();
                  popstack.push( elem );
                  pushstack.pop();
              }
              int elem = popstack.top();
              popstack.pop();
              return elem;
       } else {
           // no elem present
           return INT_MIN;
       }
    }
    
    int peek() {
          if( popstack.size() ){
              return popstack.top();
          }
          if( pushstack.size() ){
              while( pushstack.size() ){
                  int elem = pushstack.top();
                  popstack.push( elem );
                  pushstack.pop();
              }
              return popstack.top();
          } else {
              // no elem present
              return INT_MIN;
          }
    }
    
    bool empty() {
        if( popstack.size() == 0 && pushstack.size() == 0 ){
            return true;
        }
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
