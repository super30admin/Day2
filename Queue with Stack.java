class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
        /** Initialize your data structure here. */
        public MyQueue() {
            
        }
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(s2.isEmpty())
            {
                while(!s1.isEmpty())
                {
                    s2.push(s1.pop());
                 }
            }
            return s2.pop();
        }
        
        /** Get the front element. */
        public int peek() {
            
            if(s2.isEmpty())
            {
                while(!s1.isEmpty())
                {
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
    
    /**
     * Time Complexity:
     * Push : O(1)
     * Pop : O(n)
     * Peek: O(n)
     * Space complexity : O(n)
     */