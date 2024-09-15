/*
Time complexities: Push: O(1)
                   Pop: O(n)  //n is the number of elements to be moved from push stack to pop stack. Worst case is when the pop operation is at the end of all push operations
                   Peek: O(n) // to get the first added element in pushstack all the elements need to be moved from pushStack to popStack hence O(n)
                   Empty: O(1) Stack 
Space:  O(n) If all incoming n entries are to be stored in stack then at a given time space used by n elements will be n.
*/
import java.util.Stack;

class MyQueue {
    Stack<Integer> pushStack, popStack; // Create 2 stacks, 1 to perform push(offer/insert) operation and other for pop(poll)
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    // Push only deals with Push stack and performs in O(1) time
   public void push(int x) {
        pushStack.push(x);
    }
    // popStack only deals with pop operation. If it is empty, all the elements in pushStack will be automatially come in last in first out manner which in resultant give us Queue like FIFO mechanism for MyQueue object
    public int pop() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.empty() ? -1 : popStack.pop();
    }
    //Peek the first element and this will be on top of popStack
    public int peek() {
         if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.empty() ? -1 : popStack.peek();
    }
    // when both stacks are empty then our queue is empty
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.peek();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop() +"Removed from the queue");
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