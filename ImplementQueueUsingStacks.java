//Time complexity is O(1) in push , empty, pop and peek is amortized O(1)
//Code ran successfully on leetcode platform
//Space complexity : O(n)
class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<Integer>();
        this.outStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.inStack.push(x); //simply push the element in instack
    }
    
    public int pop() {
      peek(); //this will give the first element in queue
      return this.outStack.pop();
    }
    
    public int peek() {
        if(this.outStack.isEmpty()){ //check if the outstack is empty and if it move all the elements from in to out while the instack is empty
            while(!this.inStack.isEmpty()){
                this.outStack.push(this.inStack.pop());
            }
        }
        return this.outStack.peek(); //this will give the first element of queue
    }
    
    public boolean empty() {
        //empty when instack and outstack is empty.
        return this.inStack.isEmpty() && this.outStack.isEmpty();
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
