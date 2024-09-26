// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

//to implement queue using stacks

class MyQueue {
    private Stack<Integer> input=new Stack();
    private Stack<Integer> output=new Stack();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        input.push(x);
        
    }
    
    public int pop() {
        
        if(output.isEmpty()){
            shiftStacks();
        }
       return output.pop();
    }
    
    public int peek() {
         if(output.isEmpty()){
            shiftStacks();
        }
        return output.peek();
        
    }
    
    public boolean empty() {
        return input.isEmpty()&&output.isEmpty();
        
    }
    public void shiftStacks(){
         while(!input.isEmpty()){
              int temp=input.pop();
             output.push(temp);
             
         }
        
    }
}

