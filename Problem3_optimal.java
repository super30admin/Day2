
/* The code is completed and submitted successfully in Leet code. The time complexity is O(1) => O(1) and space complexity is O(1). However, worst TC is O(n) if pop after pushing all data and other stack is empty() */ 

class MyQueue {
    
    /** Initialize your data structure here. */
    
    //Normal Stack use for pushing the data
    Stack<Integer> s1 = new Stack <>();
    
    //Use it for pop and peek to maintain FIFO
    Stack<Integer> s2 = new Stack <>();
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
       //Clever Strategy learned in class to use two stacks and imprpove performance
       /*else{
            int i = 0
                ;
            //New Array List to store pop elements (This can be avoided I think)
            ArrayList<Integer> pop_element = new ArrayList<Integer>(s1.size());
            
            //Counter to store stack size
            int size = s1.size();
            while(i < size){
                //popping elements in stack
                pop_element.add(s1.pop());
                i++;
            }
            
            //Push latest value at the end of stack
            s1.push(x);
            
            //Push old values back at the stack
            for(i=pop_element.size() - 1; i>=0;i--){
                s1.push(pop_element.get(i));
            }
            
        }*/
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()){
            //Pop all elements from Stack S1 to Stack S2
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return(s2.pop());
        }else{
            return(s2.pop());
        }
        //return -1;
    }
    
    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()){
            //Pop all elements from Stack S1 to Stack S2
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return(s2.peek());
        }else{
            return s2.peek();
        }
        //return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

