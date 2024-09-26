/*
TC: 
Push - O(1)
Pop - O(n) worst case
Top - O(n) worst case

SC: (not extra space)
Push - O(n)
Pop - O(1)
Top - O(1)


*/
class MyQueue {
public:
    
    stack <int> entry;
    stack <int> exit;
    
    /** Initialize your data structure here. */
    MyQueue() {
        
                
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        
        entry.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int top_el = peek();
        exit.pop();
        return top_el;
        
    }
    
    /** Get the front element. */
    int peek() {
        
        //if exit stack is not empty return false
        if(!exit.empty())
            return exit.top();
        
        //if exit is empty, then put elements of entry in exit
        while(!entry.empty()){
            exit.push(entry.top());
            entry.pop();
        }
        
        return exit.top();

            
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        if(entry.empty() && exit.empty())
            return true;
        else return false;
        
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