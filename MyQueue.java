//Time complexity: O(N) at worst case or else it would be less than O(N) at amortised time complexity.
//space complexity: O(N)


import java.util.Stack;
public class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;
    public MyQueue() {
        inputStack=new Stack<>();
        outputStack=new Stack<>();
    }
    
    public void push(int x) {
            inputStack.push(x);
    }
    
    public int pop() {
       peek();
       return outputStack.pop();
    }
    
    public int peek() {
         if(outputStack.isEmpty()){
            while(!inputStack.isEmpty()){
                int temp=inputStack.pop();
                outputStack.push(temp);
            }
            
        }
        return outputStack.peek();
    }
    
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
    public static void main(String args[]){
        MyQueue obj=new MyQueue();
        obj.push(10);
        obj.push(100);
        System.out.println(obj.pop());
        System.out.print(obj.peek());
    }
}
