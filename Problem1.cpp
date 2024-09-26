class MyQueue {
public:
    /** Initialize your data structure here. */
    vector<int> newVector;
    vector<int> temp;
    int element; 
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        if(newVector.empty())element = x;
        while(!newVector.empty())
        {
            int z = newVector.back();
            temp.push_back(z);
            newVector.pop_back();
        }
        
        
        newVector.push_back(x);
        while(!temp.empty())
        {
            int y = temp.back();
            newVector.push_back(y);
            temp.pop_back();
        }
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int pop = newVector.back();
        newVector.pop_back();
        if(!newVector.empty())element= newVector.back();
        return pop;
    }
    
    /** Get the front element. */
    int peek() {
        return element;
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return newVector.empty();
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