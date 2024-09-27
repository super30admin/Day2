/*This program uses 2 stacks to implement a queue. The first stack
holds the actual queue, and the second stack holds the variable at 
the front of the queue at the top so that it may be easily peeked 
or popped. For the pop operation, the whole queue is shifted into 
the second stack before the variable is popped. A variable activeStack
is maintained to track the currently active stack.

Did this code run on leetcode: Yes
*/

class MyQueue {
private:    
    int top1 = -1, top2 = -1, activeStack = 1;
    int stack1[100], stack2[100];
    
public:
    MyQueue() {
        
        }
    //Time complexity = O(1), Space complexity = O(1)
    void push(int x) 
    {
        //Initial case when both stacks are empty.
        if(top1 == -1)
        {
            stack1[++top1] = x;
            stack2[++top2] = x;
        }
        
        else if(activeStack == 1)
        {
            stack1[++top1] = x;
        }
        
        else if(activeStack == 2)
        {
            stack2[++top2] = x;
        }
    }
    //Time complexity = O(n), Space complexity = O(n)
    int pop() 
    {
        if(activeStack == 1)
        {   //If the queue has only one element, return that element and exit.
            if(top1 == 0)
            {
                top2 = -1;
                return stack1[top1--];
            }
            // Temporarily store the popped variable   
            int popVar = stack2[top2--];
            //Shifting the active stack into inactive stack
            for(int i = 1; i <= top1; i++)
                stack2[++top2] = stack1[i];
            /*Making inactive stack as new active stack, and setting the 
            top of current inactive stack to front of queue*/
            activeStack = 2;
            top1 = 0;
            stack1[top1] = stack2[0];
            
            
            return popVar;
        }
        
        else
        {
            if(top2 == 0)
            {
                top1 = -1;
                return stack2[top2--];
            }
               
            int popVar = stack1[top1--];
            
            for(int i = 1; i <= top2; i++)
                stack1[++top1] = stack2[i];
            
            activeStack = 1;
            top2 = 0;
            stack2[top2] = stack1[0];
            
            return popVar;
        }
    }
    //Time complexity = O(1), Space complexity = O(1)
    int peek() 
    {
        if(activeStack == 1)
            return stack2[top2];
        return stack1[top1];
    }
    //Time complexity = O(1), Space complexity = O(1)
    bool empty() 
    {
        if(top1 == -1)
            return true;
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