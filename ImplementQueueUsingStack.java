// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// We will have 2 stacks. InStack and Outstack. 
//We use inStack for all the elements that need to be pushed. And then when we get the pop operation, we pop the items from instack and push to outstack and then pop the top element from outstack that way, it has the properties of queue 
//which is First in First out. 
// Next time we get pop, we can pop from outstack until it is empty. Then when we get pop again and if outstack is empty, pop items from instack and push to outstack. 
class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        this.in.push(x);
    }
    
    public int pop() {
        int popped = peek();
        return this.out.pop();
    }
    
    public int peek() {
        if( this.out.isEmpty()) {
            while(!this.in.isEmpty()){
                this.out.push(this.in.pop());                
            }
        }
          return this.out.peek();        
    }
    
    public boolean empty() {
        return this.in.isEmpty() && this.out.isEmpty();
    }
}