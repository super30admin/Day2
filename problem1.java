//implement Queue using 2 Stacks
/*
Constraints given:
1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.


Complexity analysis:
Time- O(1) on each call but for N elements O(N) would be the worst case complexity
Space- O(2N)~O(N): since I am creating 2 stacks to implement the queue. This is already given so cannot optimize further.
*/


class MyQueue {
    
    private Stack<Integer> s1= new Stack<>();
    private Stack<Integer> s2= new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if(s2.isEmpty()){
            
            while(!s1.isEmpty()){
                
                s2.push(s1.pop());
            }
        }
        
        return s2.pop();
    
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(!s2.isEmpty()) return s2.peek();
        
        else{
            
            while(!s1.isEmpty()){
                
                s2.push(s1.pop());
            }
        }
        
        return s2.peek();

    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        return s1.isEmpty() && s2.isEmpty();
    }
}