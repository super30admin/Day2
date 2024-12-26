// Time Complexity : O(1) for push and O(n)for pop
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
  //We will use two stacks instack and oustack to perform push and pop operations

class MyQueue1 {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<Integer>();
        this.outStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.inStack.push(x);
        
    }
    
    public int pop() {
        peek();
        return this.outStack.pop();
        
    }
    
    public int peek() {
        if(this.outStack.isEmpty()){
           while(!this.inStack.isEmpty()){
            this.outStack.push(this.inStack.pop());
           }
        
    }
    return this.outStack.peek();
    }
    
    public boolean empty() {
        return this.inStack.isEmpty() && this.outStack.isEmpty();
        
    }
    // Driver code 
p/*ublic static void main(String[] args) 
{ 
	MyQueue obj = new MyQueue1();
	obj.push(1);obj.push(2);obj.push(3);obj.push(4);
	System.out.println(obj.pop());
	System.out.println(obj.peek());
	System.out.println(obj.empty());
}*/

}
